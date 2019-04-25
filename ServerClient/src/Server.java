import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             ServerSocket serverSocket = new ServerSocket(7777)) {
            while (true) {
                System.out.println("Сервер ожидает подключения!");
                Socket socket = serverSocket.accept();

                System.out.println("Кто-то подключился: " + socket.getInetAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.print("Вы :");
                        while (scanner.hasNextLine()){
                            System.out.print("Вы :");
                            String line = scanner.nextLine();
                            try {
                                out.writeUTF(line);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                thread.start();

                while (true){
                    try {
                        System.out.println("\nКлиент :" + in.readUTF());
                        System.out.print("Вы :");
                    } catch (IOException ex){
                        ex.printStackTrace();
                        break;
                    }
                }

                thread.join();


            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}





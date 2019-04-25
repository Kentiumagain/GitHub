import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws InterruptedException {

    try (Scanner scanner = new Scanner(System.in);
         Socket socket = new Socket("localhost", 7777)) {

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());



        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("Вы :");
                while(scanner.hasNextLine()){
                    System.out.print("Вы :");
                    String line = scanner.nextLine();
                    try {
                        out.writeUTF(line);
                    } catch (IOException ex){
                        ex.printStackTrace();
                    }
                }
            }
        });
        thread.start();

        while (true){
            try {
                System.out.println("\nСервер : "+in.readUTF());
                System.out.print("Вы :");
            } catch (IOException ex){
                ex.printStackTrace();
                break;
            }
        }

        thread.join();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
}

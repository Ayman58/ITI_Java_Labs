package newserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class NewServerApp {

    public NewServerApp() throws IOException {
        try {
            ServerSocket myServerSocket = new ServerSocket(7777);
            while (true) {
                Socket s = myServerSocket.accept();
                new ChatHandler(s);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
static Vector<ChatHandler> vect = new Vector<ChatHandler>();
    public class ChatHandler extends Thread {

        DataInputStream data;
        PrintStream p;
        

        public ChatHandler(Socket s) {
            try {
                data = new DataInputStream(s.getInputStream());
                p = new PrintStream(s.getOutputStream());
                vect.add(this);
                start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            while (true) {
                try {
                    String str = data.readLine();
                    sendToAll(str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void sendToAll(String message) {
            for (ChatHandler c : vect) {
                c.p.println("[" + c.getId() + "]:" + message);
            }

        }

    }

    public static void main(String[] args) throws IOException {
        new NewServerApp();
    }
}

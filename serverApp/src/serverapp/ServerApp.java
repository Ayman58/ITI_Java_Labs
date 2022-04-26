package serverapp;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

    ServerSocket myServerSocket;
    Socket s;
    DataInputStream dis;
    PrintStream ps;

    public ServerApp() {
        try {
            myServerSocket = new ServerSocket(5005);
            s = myServerSocket.accept();
            dis = new DataInputStream(s.getInputStream());
            ps = new PrintStream(s.getOutputStream());
            String msg = dis.readLine();
            System.out.println(msg);
            ps.println("hi feom server ");
            ps.close();
            dis.close();
            s.close();
            myServerSocket.close();

        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        new ServerApp();

    }
}

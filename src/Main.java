import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        var s = new ServerSocket(8189);
        Socket incoming = s.accept();

        InputStream inStream = incoming.getInputStream();
        OutputStream outStream = incoming.getOutputStream();

        var in = new Scanner(inStream, StandardCharsets.UTF_8);
        var out = new PrintWriter(new OutputStreamWriter(outStream, StandardCharsets.UTF_8), true);

        out.println("Hello, type bye to exit!");
        String line = in.nextLine();
        out.println("Echo: " + line);

        boolean done;
        if(line.trim().equals("bye")) {
            done = true;
            incoming.close();
        }


    }
}

package com.aula;

import javax.xml.bind.SchemaOutputResolver;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerApplicationThreadHandler extends Thread {

    final Socket socket;

    ServerApplicationThreadHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            handler(in, out);
            out.flush();
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void handler(DataInputStream request, DataOutputStream response) throws IOException {
        String data = "<h3>Error</h3><p>404 Not found</p>";
        response.writeBytes("HTTP/1.0 404 OK\r\n");
        response.writeBytes("Date: Fri, 31 Dec 1999 23:59:59 GMT\r\n");
        response.writeBytes("Server: Apache/0.8.4\r\n");
        response.writeBytes("Content-Type: text/html\r\n");
        response.writeBytes("Content-Length: "+ data.length() +"\r\n");
        response.writeBytes("\r\n");
        response.writeBytes(data);
        response.writeBytes("\r\n");
    }
}

package com.aula.routes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class HelloWorldHandler {


    public static void handler(DataInputStream request, DataOutputStream response) throws IOException {
        System.out.println("HELLO WORLD");
//        float tempC = request.readFloat();
//        float tempF = (float) (tempC * 1.8 + 32);
//        response.writeBytes("<b> This is the HTTP Server Home Page.... </b><BR>");
//        response.writeFloat(30000);
        String data = "<TITLE>Example</TITLE><P>Olá mundo!</P>";
        response.writeBytes("HTTP/1.0 200 OK\r\n");
        response.writeBytes("Date: Fri, 31 Dec 1999 23:59:59 GMT\r\n");
        response.writeBytes("Server: Apache/0.8.4\r\n");
        response.writeBytes("Content-Type: text/html\r\n");
        response.writeBytes("Content-Length: "+ data.length() +"\r\n");
        response.writeBytes("\r\n");
        response.writeBytes(data);
        response.writeBytes("\r\n");
    }
}

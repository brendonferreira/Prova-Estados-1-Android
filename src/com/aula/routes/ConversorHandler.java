package com.aula.routes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConversorHandler {


    public static void handler(DataInputStream request, DataOutputStream response) throws IOException {
        float tempC = request.readFloat();
        float tempF = (float) (tempC * 1.8 + 32);
        response.writeFloat(tempF);
    }
}

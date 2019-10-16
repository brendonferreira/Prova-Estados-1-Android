package com.aula;

import com.aula.routes.ConverterHandler;
import com.aula.routes.HelloWorldHandler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class RoutesHandler extends ServerApplicationThreadHandler {
    RoutesHandler(Socket socket) {
        super(socket);
    }

    @Override
    void handler(DataInputStream request, DataOutputStream response) throws IOException {
        String firstLine = request.readLine();
        String[] parts = firstLine.split(" ");

        if( parts[1].matches("/conversor") ) {
            ConverterHandler.handler(request, response);
            return;
        }

        if( parts[1].matches("/hello") ) {
            HelloWorldHandler.handler(request, response);
            return;
        }

        super.handler(request, response);
    }
}

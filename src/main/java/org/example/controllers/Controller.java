package org.example.controllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public abstract class Controller implements HttpHandler {

    void writeResponse(HttpExchange exchange, int rCode, byte[] out) throws IOException {
                exchange.sendResponseHeaders(rCode, out.length);
        try (OutputStream body = exchange.getResponseBody()) {
            body.write(out);
        }

    }
}

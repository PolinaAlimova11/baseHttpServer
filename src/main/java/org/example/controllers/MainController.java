package org.example.controllers;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.example.SimpleServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainController implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Headers requestHeaders = exchange.getRequestHeaders();
        byte[] out;
        try (InputStream resourceAsStream = SimpleServer.class.getResourceAsStream("hello-web.html")) {
            out = resourceAsStream.readAllBytes();
        }
        exchange.sendResponseHeaders(200, out.length);
        try (OutputStream body = exchange.getResponseBody()) {
            body.write(out);
        }
    }
}

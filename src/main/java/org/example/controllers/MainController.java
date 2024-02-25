package org.example.controllers;

import com.sun.net.httpserver.HttpExchange;
import org.example.SimpleServer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class MainController extends Controller {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        int rCode = 200;
        byte[] out;
        try (InputStream resourceAsStream = SimpleServer.class.getResourceAsStream("hello-web.html")) {
            out = Objects.requireNonNull(resourceAsStream).readAllBytes();
        }
        writeResponse(exchange, rCode, out);
    }
}

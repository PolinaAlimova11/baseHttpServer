package org.example;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.example.controllers.MainController;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleServer {

    public static void main(String[] args) {
        InetSocketAddress localhost = new InetSocketAddress("localhost", 9876);
        try {
            HttpServer httpServer = HttpServer.create(localhost, 0);
            MainController mainController = new MainController();
            httpServer.createContext("/", mainController);
            httpServer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

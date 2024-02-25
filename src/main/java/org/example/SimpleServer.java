package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sun.net.httpserver.HttpServer;
import org.example.controllers.MainController;
import org.example.controllers.RestController;
import org.example.repository.MessageRepository;
import org.example.service.MessageService;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SimpleServer {

    public static void main(String[] args) {
        InetSocketAddress localhost = new InetSocketAddress("localhost", 9876);
        try {
            HttpServer httpServer = HttpServer.create(localhost, 0);
            MainController mainController = new MainController();
            MessageService messageService = new MessageService(new MessageRepository());
            RestController restController = new RestController(
                    messageService, new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT));
            httpServer.createContext("/", mainController);
            httpServer.createContext("/message/", restController);
            httpServer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

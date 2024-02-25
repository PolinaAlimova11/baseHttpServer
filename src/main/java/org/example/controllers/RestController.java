package org.example.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import lombok.AllArgsConstructor;
import org.example.model.Message;
import org.example.service.MessageService;

import java.io.IOException;

@AllArgsConstructor
public class RestController extends Controller {

    public final MessageService messageService;

    public final ObjectMapper objectMapper;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod().toUpperCase();
        String uri = exchange.getRequestURI().toString();
        // http://localhost:9876/message/
        String idStr = uri.replaceAll(".*/", "");
        Long id = idStr.isEmpty() ? -1 : Long.parseLong(idStr);
        switch (method) {
            case "GET" -> {
                Object result;
                if(id > 0) {
                    result = messageService.get(id);
                } else {
                    result = messageService.getAll();

                }
                byte[] bytes = objectMapper.writeValueAsBytes(result);
                writeResponse(exchange, 200, bytes);
            }
            case "POST" -> {
                String json = new String(exchange.getRequestBody().readAllBytes());
                Message message = objectMapper.readValue(json, Message.class);
                if (messageService.create(message)) {
                    byte[] out = objectMapper.writeValueAsBytes(message);
                    writeResponse(exchange, 201, out);
                }
                else {
                    writeResponse(exchange, 501, objectMapper.writeValueAsBytes("error"));
                }

            }
            default -> {
                writeResponse(exchange, 500, objectMapper.writeValueAsBytes("error"));
            }
        }
    }
}

package org.example.service;

import org.example.model.Message;
import org.example.repository.Repository;

import java.util.List;

public class MessageService implements Rest<Message>{


    private final Repository<Message> repository;

    public MessageService(Repository<Message> repository) {
        this.repository = repository;
        repository.safeOrUpdate(new Message(1L, "Hello", "Polina"));
        repository.safeOrUpdate(new Message(2L, "Hello2", "Polina"));
        repository.safeOrUpdate(new Message(3L, "Hello", "Polina"));
    }

    @Override
    public List<Message> getAll() {
        return repository.getAll();
    }

    @Override
    public Message get(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean create(Message entity) {
        return repository.safeOrUpdate(entity);
    }

    @Override
    public boolean update(Message entity) {
        return repository.safeOrUpdate(entity);
    }

    @Override
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}

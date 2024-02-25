package org.example.repository;

import org.example.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MessageRepository implements Repository<Message>{

    private final List<Message> messageList = new ArrayList<>();
    @Override
    public Message findById(Long id) {
        Message result = null;
        for (Message message : messageList) {
            Long currentIndex = message.getIndex();
            if (id.equals(currentIndex)) {
                result = message;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean safeOrUpdate(Message entity) {
        Message fingMessage = findById(entity.getIndex());
        if (Objects.nonNull(fingMessage)) {
            fingMessage.setMessage(entity.getMessage());
            fingMessage.setAuthor(entity.getAuthor());
            return true;
        } else {
            return messageList.add(entity);
        }
    }

    @Override
    public boolean delete(Long id) {
        Message findMessage = findById(id);
        if (Objects.nonNull(findMessage)) {
            return messageList.remove(findMessage);
        } else {
            return false;
        }
    }

    @Override
    public List<Message> getAll() {
        return messageList;
    }
}

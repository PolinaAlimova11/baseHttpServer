package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Message {

    private Long index;
    private String message;
    private String author;

//    @Override
//    public String toString() {
//        return "Message{" +
//                "index=" + index +
//                ", message='" + message + '\'' +
//                ", author='" + author + '\'' +
//                '}';
//    }
}

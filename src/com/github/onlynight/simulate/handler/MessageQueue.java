package com.github.onlynight.simulate.handler;

public class MessageQueue {

    private Message head;
    private Message current;

    public void enqueueMessage(Message msg) {
        if (head == null && current == null) {
            head = msg;
            current = msg;
        } else {
            current.next = msg;
            current = msg;
        }
    }

    public Message dequeueMessage() {
        if (head != null) {
            Message temp = head;
            head = head.next;
            return temp;
        }
        return null;
    }

}

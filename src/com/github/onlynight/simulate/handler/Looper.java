package com.github.onlynight.simulate.handler;

public class Looper {

    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<>();
    private MessageQueue queue;

    public Looper() {
        queue = new MessageQueue();
    }

    public static void prepare() {
        sThreadLocal.set(new Looper());
    }

    public static Looper myLooper() {
        return sThreadLocal.get();
    }

    public static void loop() {
        Message msg = myLooper().queue.dequeueMessage();
        for (; ; ) {
            if (msg != null) {
                msg.target.handleMessage(msg);
                msg = msg.next;
            }
        }
    }

    public MessageQueue getQueue() {
        return queue;
    }
}

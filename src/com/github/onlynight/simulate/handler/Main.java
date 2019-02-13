package com.github.onlynight.simulate.handler;

public class Main {

    private Handler handler;

    public Main() {
        Looper.prepare();

        handler = new Handler() {
            @Override
            public void handleMessage(Message message) {
                System.out.println("msg_id: " + message.what + " ====> thread_name: " + Thread.currentThread().getName());
            }
        };

        Message msg = new Message();
        msg.what = 1;
        handler.sendMessage(msg);

        new Thread(() -> {
            Message msg1 = new Message();
            msg1.what = 2;
            handler.sendMessage(msg1);
        }).start();

        Looper.loop();
    }

    public static void main(String[] args) {
        new Main();
    }
}

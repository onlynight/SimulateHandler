package com.github.onlynight.simulate.handler;

public abstract class Handler {

    private Looper looper;

    public Handler() {
        looper = Looper.myLooper();
    }

    public abstract void handleMessage(Message message);

    public void dispatchMessage(Message msg){
        handleMessage(msg);
    }

    public void sendMessage(Message msg) {
        msg.target = this;
        looper.getQueue().enqueueMessage(msg);
    }

}

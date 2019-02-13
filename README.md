SimulateHandler
===============

This is an demo that simulate android Handler how to switch thread.


### The key is {ThreadLocal}

For more information, please check the source code.

```java
public class Looper {

    // ThreadLocal will save the thread share var, each thread has its own var.
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
                msg.target.dispatchMessage(msg);
                msg = msg.next;
            }
        }
    }

    public MessageQueue getQueue() {
        return queue;
    }
}
```
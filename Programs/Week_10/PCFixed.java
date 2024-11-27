class Q {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet) {
            try {
                System.out.println("\nConsumer waiting");
                wait();  // Consumer waits if value is not set
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught in get()");
                Thread.currentThread().interrupt();  // Re-interrupt the thread
            }
        }
        System.out.println("Got: " + n);
        valueSet = false;  // Mark the value as consumed
        System.out.println("\nIntimate Producer");
        notify();  // Notify producer to put new value
        return n;
    }

    synchronized void put(int n) {
        while (valueSet) {
            try {
                System.out.println("\nProducer waiting");
                wait();  // Producer waits if value has already been set
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught in put()");
                Thread.currentThread().interrupt();  // Re-interrupt the thread
            }
        }
        this.n = n;
        valueSet = true;  // Mark the value as produced
        System.out.println("Put: " + n);
        System.out.println("\nIntimate Consumer");
        notify();  // Notify consumer that value is available
    }
}

class Producer implements Runnable {
    Q q;
    private static final int MAX_ITEMS = 15;

    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;
        while (i < MAX_ITEMS) {  // Produce only up to MAX_ITEMS
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {
    Q q;
    private static final int MAX_ITEMS = 15;

    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        int i = 0;
        while (i < MAX_ITEMS) {  // Consume only up to MAX_ITEMS
            int r = q.get();
            System.out.println("Consumed: " + r);
            i++;
        }
    }
}

class PCFixed {
    public static void main(String args[]) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
        System.out.println("Press Control-C to stop.");
    }
}
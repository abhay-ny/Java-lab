public class main {

    // Thread to display "BMS College of Engineering" every 10 seconds
    static class DisplayBMS implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("BMS College of Engineering");
                    Thread.sleep(10000);  // Sleep for 10 seconds
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    // Thread to display "CSE" every 2 seconds
    static class DisplayCSE implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("CSE");
                    Thread.sleep(2000);  // Sleep for 2 seconds
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        // Create threads for both tasks
        Thread thread1 = new Thread(new DisplayBMS());
        Thread thread2 = new Thread(new DisplayCSE());

        // Start the threads
        thread1.start();
        thread2.start();
    }
}

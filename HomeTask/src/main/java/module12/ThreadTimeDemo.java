package module12;

public class ThreadTimeDemo {
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
                int timeCounter = 0;
                while(!Thread.interrupted()){
                    System.out.println("Time passed after start program - " + timeCounter);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    timeCounter+=5;
                }

        });
        Thread thread2 = new Thread(() -> {
            while(!Thread.interrupted()){
                try {
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("5 seconds have passed");
            }
        });
        thread2.start();
        thread1.start();

    }
}

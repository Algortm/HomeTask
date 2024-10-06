package module12;

class FizzBuzz {
    private int count = 1;
    private int n;
    private final Object monitor = new Object();
    private boolean finished = false;
    public FizzBuzz(int count) {
        this.n = count;
    }

    public void fizz() throws InterruptedException {
        while (count <= n) {
            synchronized (monitor) {
                if ((count % 3 == 0 )&& (count % 5 != 0)) {
                    System.out.println("fizz");
                    count++;
                } else {
                    monitor.notifyAll();
                    monitor.wait();
                }
            }
        }
    }

    public void buzz() throws InterruptedException {
        while (count <= n) {
            synchronized (monitor) {
                if ((count % 5 == 0) &&( count % 3 != 0)) {
                    System.out.println("buzz");
                    count++;
                } else {
                    monitor.notifyAll();
                    monitor.wait();
                }
            }
        }
    }

    public void fizzbuzz() throws InterruptedException {
        while (count <= n) {
            synchronized (monitor) {
                if ((count % 3 == 0 )&&( count % 5 == 0)) {
                    System.out.println("fizzbuzz");
                    count++;
                } else {
                    monitor.notifyAll();
                    monitor.wait();
                }
            }
        }
    }

    public void number() throws InterruptedException {
        while (count <= n) {
            synchronized (monitor) {

                if ((count % 3 != 0) && (count % 5 != 0)) {
                    System.out.println(count);
                    count++;
                } else {
                    monitor.notifyAll();
                    monitor.wait();
                }
            }
        }
    }
}

package demo.base;

/**
 * 测试死锁
 * 上面这段程序会发生死锁。造成死锁的原因：
 * [-128，127]之间的数字会被缓存，而Integer.valueOf()会返回缓存的对象。
 * 因此代码中200次for循环实际上总共只创建了两个对象，当线程A持有Integer.valueOf(1)时，如果线程B持有Integer.valueOf(2)，则就会出现死锁，属于动态锁顺序死锁
 */
public class SynAddRunnable implements Runnable {

    int a, b;

    public SynAddRunnable(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (Integer.valueOf(a)) {
            synchronized (Integer.valueOf(b)) {
                System.out.println(a + b);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SynAddRunnable(1, 2)).start();
            new Thread(new SynAddRunnable(2, 1)).start();
        }
    }
}

public class SummingThread  extends Thread{

    private Sum sum;
    private int l, r;
    private int[] a;

    public SummingThread(int[] a, int l, int r, Sum sum) {
        this.a = a;
        this.l = l;
        this.r = r;
        this.sum = sum;
    }

    public void run() {
        for (int i = l; i < r; i++) {
            sum.increment(a[i]);
        }
    }
}

public class Sum {

    private static int sum = 0;
    public Sum(){}

    public synchronized void increment(int x) {
        sum += x;
        System.out.println(sum);
    }

    public int getSum () {
        return sum;
    }

}

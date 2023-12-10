public class MinElement {

    private int infinity = 2147483647;
    private static int minElement;

    public MinElement() {minElement = infinity;}

    public void compare(int x) {
        if (x < minElement) {
            minElement = x;
        }
        //System.out.print(x);
        //System.out.print(" M");
        //System.out.println(minElement);
    }
    public int getMin(){return minElement;}
}

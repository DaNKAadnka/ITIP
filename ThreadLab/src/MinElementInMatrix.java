import java.util.ArrayList;
import java.util.List;

public class MinElementInMatrix {
    public static void main (String[] args) {

        MinElement minElement = new MinElement();
        int[][] matrix = new int[][] {{31, 9, 19}, {13, 18, 5}, {20, 20}, {}, {10}};

        int cnt = 0;
        List<MinElementThread> threads = new ArrayList<>();
        for (int[] row : matrix) {
            MinElementThread threadi = new MinElementThread(matrix, cnt++, minElement);
            threadi.start();
            threads.add(threadi);
        }

        for (MinElementThread thread : threads) {
            try{
                thread.join();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println(minElement.getMin());
    }
}

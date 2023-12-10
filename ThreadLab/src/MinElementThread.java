public class MinElementThread extends Thread {

    private MinElement minElement;
    private int row;
    private int[][] matrix;

    public MinElementThread (int[][] matrix, int row, MinElement minElement) {
        this.matrix = matrix;
        this.minElement = minElement;
        this.row = row;
    }

    public void run () {
        for (int x : matrix[row]) {
            minElement.compare(x);
        }
    }
}

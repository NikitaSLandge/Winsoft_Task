import java.util.ArrayList;
import java.util.List;

public class Maximum_Sum {

    public static void main(String[] args) {
        int[] X = {3, 6, 7, 8, 10, 12, 15, 18, 100};
        int[] Y = {1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50};

        Result result = findMaximumSumPath(X, Y);
        System.out.println("Maximum sum: " + result.sum);
        System.out.println("Maximum sum path: " + result.path);
    }

    public static Result findMaximumSumPath(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;

        int i = 0, j = 0;
        int sumX = 0, sumY = 0, maxSum = 0;
        List<Integer> path = new ArrayList<>();

        while (i < m && j < n) {
            if (X[i] < Y[j]) {
                sumX += X[i];
                path.add(X[i++]);
            } else if (X[i] > Y[j]) {
                sumY += Y[j];
                path.add(Y[j++]);
            } else {
                maxSum += Math.max(sumX, sumY) + X[i];
                path.add(X[i]); // Add the common element to the path
                sumX = 0;
                sumY = 0;
                i++;
                j++;
            }
        }

        while (i < m) {
            sumX += X[i];
            path.add(X[i++]);
        }

        while (j < n) {
            sumY += Y[j];
            path.add(Y[j++]);
        }

        maxSum += Math.max(sumX, sumY);

        return new Result(maxSum, path);
    }

    static class Result {
        int sum;
        List<Integer> path;

        public Result(int sum, List<Integer> path) {
            this.sum = sum;
            this.path = path;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "sum=" + sum +
                    ", path=" + path +
                    '}';
        }
    }
}

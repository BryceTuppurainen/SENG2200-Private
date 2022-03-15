public class Median {
    public static int median(int x, int y, int z) {
        int median = 0;
        if (x >= y && x <= z) {
            median = x;
        } else if (x >= z && x <= y) {
            median = x;
        } else if (y >= x && y < z) {
            median = z;
        } else if (y >= z && y <= x) {
            median = y;
        } else {
            median = z;
        }
        return median;
    }

    public static int correctMedian(int x, int y, int z) {

        if (x <= y && y <= z) {
            return y;
        }

        if (y <= x && x <= z) {
            return x;
        }

        return z;
    }
}

public class TestGenerator {
    public static void main(String[] args) {
        for (int x = -10; x <= 10; x++) {
            for (int y = -10; y <= 10; y++) {
                for (int z = -10; z <= 10; z++) {
                    System.out.println(x + " " + y + " " + z);
                }
            }
        }
    }
}
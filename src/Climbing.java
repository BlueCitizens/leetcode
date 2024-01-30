import java.util.HashMap;
import java.util.Map;

public class Climbing {
    private final Map<Integer, Integer> tempMap = new HashMap<>();

    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (!tempMap.containsKey(n)) {
            tempMap.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        }
        return tempMap.get(n);

    }

    public int climbStairs2(int n) {
        int n1 = 1;
        int n2 = 2;
        int n0 = 0;
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        for (int i = 3; i <= n; i++) {
            n0 = n1 + n2;
            n1 = n2;
            n2 = n0;
        }
        return n0;
    }


    public static void main(String[] args) {

    }
}

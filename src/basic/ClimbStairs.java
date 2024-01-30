package basic;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: BlueCitizen
 * @description 爬楼梯 https://blog.csdn.net/Vriesianman/article/details/106729888
 *
 * @date: 2024/1/7 15:18
 */
public class ClimbStairs {

    static Map<Integer, Integer> temp = new HashMap<>();

    public static int recursion(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        /*else {
            return recursion(n - 1) + recursion(n - 2);
        }*/
        if (!temp.containsKey(n)) {
            temp.put(n, recursion(n - 1) + recursion(n - 2));
        }
        return temp.get(n);
    }

    public static void main(String[] args) {

        System.out.println(recursion(10));
    }
}

import java.util.Arrays;

public class Candy {

    public static int giveCandy(int[] ratings) {
        int length = ratings.length;
        int[] candy = new int[length];
        Arrays.fill(candy, 1);
        for (int idx = 0; idx < candy.length - 1; idx++) {
            if (ratings[idx + 1] > ratings[idx]) {
                candy[idx + 1] = candy[idx] + 1;
            } else if (ratings[idx + 1] == ratings[idx]) {
                candy[idx] = candy[idx + 1];
            }
        }
        for (int idx = candy.length - 1; idx > 0; idx--) {
            if (ratings[idx - 1] > ratings[idx]) {
                candy[idx - 1] = Math.max(candy[idx - 1], candy[idx] + 1);
            } else if (ratings[idx - 1] == ratings[idx]) {
                candy[idx - 1] = candy[idx];
            }
        }
        int accuCandy = 0;
        for (int j : candy) {
            accuCandy = accuCandy + j;
        }
        return accuCandy;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 4};
        System.out.println(giveCandy(nums));
    }
}

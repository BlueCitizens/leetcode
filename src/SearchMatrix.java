public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int upper = 0, lower = matrix.length - 1;
        while (upper < lower) {
            int med = ( lower - upper + 1) / 2 + upper;
            if (matrix[med][0] < target) {
                upper = med;
            } else {
                lower = med - 1;
            }
        }

        if (target < matrix[0][0]) {
            return false;
        } else {
            int l = 0, r = matrix[0].length - 1;
            while (l <= r) {
                int med = (l + r) / 2;
                if (matrix[0][med] > target) {
                    r = med - 1;
                } else if (matrix[0][med] == target) {
                    return true;
                } else {
                    l = med;
                }
            }
            if (matrix[0][l] != target) {
                return false;
            } else {
                return true;
            }

        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        System.out.println(searchMatrix(matrix,13));
    }
}

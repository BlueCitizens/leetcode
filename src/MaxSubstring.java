public class MaxSubstring {
    public static int longestCommonSubsequence(String text1, String text2) {
        int t1 = 0, t2 = 0;

        for (int i = t1; i < text1.length(); i++) {
            String current = String.valueOf(text1.charAt(i));
            if (text2.contains(current)) {
                t1++;
                for (int j = t2; j < text2.length(); j++) {
                    if (String.valueOf(text2.charAt(j)).equals(current)) {
                        t2 = j + 1;
                        break;
                    }
                }
            } else {
                break;
            }

        }
        return 1;
    }

    public static void main(String[] args) {

    }
}

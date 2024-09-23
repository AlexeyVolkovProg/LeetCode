package TwoPointers;

/**
 * https://leetcode.com/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150
 * Привести все английские символы к нижнему регистру и проверить на полиндром строку
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        testForSolution();
    }

    public static boolean validPalindrom(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        boolean result = true;
        while (l < r) {
            if (!Character.isLetterOrDigit(chars[l])){
                l++;
            } else if(!Character.isLetterOrDigit(chars[r])){
                r--;
            } else {
                if (!(Character.isLetterOrDigit(chars[l]) && Character.isLetterOrDigit(chars[r]) && chars[l] == chars[r])) {
                    result = false;
                    break;
                }
                l++;
                r--;
            }
        }
        return result;
    }

    public static void testForSolution(){
        System.out.println(validPalindrom("1b1"));
    }
}

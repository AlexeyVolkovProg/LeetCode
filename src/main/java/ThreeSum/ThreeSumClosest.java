package ThreeSum;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/description/
 * Задача заключается в нахождении тройки чисел в массиве, сумма которых ближайшая к target
 * //TODO ИДЕЯ: опять же заключается в использовании трех указателей
 * //TODO Сложность: O(n^2)
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        testSolution();
    }

    public static Integer solution(int[] array, int target) {
        int answer = array[0] + array[1] + array[2];
        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            int l = i; // указатель для первого элемента тройки
            int r1 = i + 1; // указатель для второго тройки
            int r2 = array.length - 1; // указатель для третьего элемента тройки

            if (l > 0 && (array[l - 1] == array[l])) {
                continue; // нет смысла запускать цикл, ибо подобные тройки мы уже отследили
            }

            while (r1 < r2) {
                int sum = array[l] + array[r1] + array[r2];
                if (Math.abs(sum - target)
                        <= Math.abs(answer - target)) {
                    answer = sum;
                }
                if (sum > target) {
                    r2--;
                    while (r1 < r2 && array[r2 + 1] == array[r2]) {
                        r2--;
                    }
                } else if (sum < target) {
                    r1++;
                    while (r1 < r2 && array[r1 - 1] == array[r1]) {
                        r1++;
                    }
                } else if (sum == target){
                    return sum;
                }
            }
        }
        return answer;
    }
    public static void testSolution() {
        System.out.println(solution(new int[]{0,1,2}, 3));
    }
}

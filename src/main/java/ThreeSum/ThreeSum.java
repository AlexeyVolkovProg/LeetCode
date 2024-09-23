package ThreeSum;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * Сложность: medium
 * Найти все оригинальные тройки в массиве, которые в сумме дают 0
 * //TODO ИДЕЯ: Используй указатели на отсортированном массиве, всего будет три указателя
 * //TODO Сложность: O(n^2)
 */
public class ThreeSum {
    public static void main(String[] args) {
        testForSolution();
    }


    public static List<List<Integer>> solution(int[] array) {
        Arrays.sort(array); // сортировка за O(nlog(n)) двух позиционная быстрая сортировка

        List<List<Integer>> solutionList = new LinkedList<>();
        for (int i = 0; i < array.length - 2; i++) {
            int l = i; // указатель для поиска начала тройки
            int r1 = i + 1; // указатель для поиска первого элемента оставшейся двойки
            int r2 = array.length - 1; // указатель для поиска второго элемента оставшейся двойки

            if (array[l] > 0) {
                break; // так как массив по возрастанию и все три элемента положительные
                // , а нам нужна сумма ноль
            }

            if (l > 0 && array[l] == array[l - 1]) {
                continue;
                // нет смысла отдельно запускать так как на предыдущем шаге эти тройки уже отследили
            }

            while (r1 < r2) {
                if ((array[l] + array[r1] + array[r2]) == 0) {
                    solutionList.add(List.of(array[l], array[r1], array[r2]));
                    r1++;
                    r2--;
                    while ((r1 < r2) && array[r1 - 1] == array[r1]) { // далее делаем сдвиги с проверками на то, чтобы тройка не повторилась
                        r1++;
                    }
                    while ((r1 < r2) && array[r2 + 1] == array[r2]) {
                        r2--;
                    }
                } else if ((array[l] + array[r1] + array[r2]) > 0){
                    r2--; // уменьшаем сумму ближе к нулю
                } else if ((array[l] + array[r1] + array[r2]) < 0){
                    r1++; // увеличиваем сумму ближе к нулю
                }
            }
        }
        return solutionList;

    }

    public static void testForSolution(){
        System.out.println(solution(new int[]{-2,0,1,1,2}));
    }



}

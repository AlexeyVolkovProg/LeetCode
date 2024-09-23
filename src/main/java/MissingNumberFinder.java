import java.util.Arrays;


/**
 * Волков Алексей, решение тестового задания в компанию ИНДЕВЛАБС
 */
public class MissingNumberFinder {

    public static int findMissingNumber(int[] numbers) {
        // Если массив пустой, то вернем 0 как минимальное возможное пропущенное число
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        // Сортируем массив для упрощения поиска пропущенного числа
        Arrays.sort(numbers);

        // Находим минимальное значение в массиве
        int min = numbers[0];

        // Проходим по массиву и находим пропущенное число
        for (int i = 0; i < numbers.length; i++) {
            // Если текущее число не равно минимальному плюс индекс, то это пропущенное число
            if (numbers[i] != min + i) {
                return min + i;
            }
        }

        // Если не найдено пропущенное число внутри массива, то оно находится в конце
        return numbers[numbers.length - 1] + 1;
    }

    // Тесты
    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[]{5, 0, 1, 3, 2})); //  4
        System.out.println(findMissingNumber(new int[]{7, 9, 10, 11, 12})); //  8
        System.out.println(findMissingNumber(new int[]{1, 2, 3})); //  0
        System.out.println(findMissingNumber(new int[]{0, 1, 2, 3})); //  4
        System.out.println(findMissingNumber(new int[]{})); //  0
        System.out.println(findMissingNumber(new int[]{0})); //  1
    }
}

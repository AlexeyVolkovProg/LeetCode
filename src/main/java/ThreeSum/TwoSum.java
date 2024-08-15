package ThreeSum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 * Задача заключается в нахождении индексов двух чисел, которые в сумме дают target
 * Гарантируется что решением является единственная пара
 * //TODO ИДЕЯ: Использовать HashMap, ибо массив нельзя сортировать так как нам нужны индексы
 * //TODO СЛОЖНОСТЬ: O(N)
 */
public class TwoSum {

    public static void main(String args[]){
        testForSolution();
    }

    public static List<Integer> solution(int[] array, int target){
        Map<Integer, Integer> mapIndex = new HashMap<>(); // создаем мапу, где ключи это значения массива, а значения это их индексы в array
        for(int i = 0; i < array.length; i++){
            mapIndex.put(array[i], i);
        }

        for (int i = 0; i < array.length; i++){
            if (mapIndex.containsKey(target - array[i]) && i != mapIndex.get((target - array[i]))){
                return List.of(i, mapIndex.get(target - array[i]));
            }
        }
        return null; // по задаче гарантируется что такая пара всегда есть

    }

    public static void testForSolution(){
        System.out.println(solution(new int[]{3, 3}, 6));
    }

}

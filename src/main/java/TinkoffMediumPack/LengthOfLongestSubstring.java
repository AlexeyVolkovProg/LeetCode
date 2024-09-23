package TinkoffMediumPack;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-interview-150
 * Задача: найти максимальную подстроку, в которой все символы оригинальные
 * Идея: используем плавающее окно Sliding Window,
 * которое за счет HashMap будет хранить кол-во вхождений различных букв в окно
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        testForSolution();
    }


    /**
     * Решение с применением HashMap для отслеживания состояния подстроки
     * Можно еще при помощи Set
     */
    public static int lengthOfLongestSubstring(String s) {
        // создадим мапу для плавающего окна, в которую будем записывать символы и их кол-во в подстроке
        HashMap<Character, Integer> charMap = new HashMap<>();
        char[] characters = s.toCharArray();
        // создадим два указателя для границ плавающего окна
        int l = 0;
        int r = 0;
        int lengthWindow = 0;
        int maxSubstring = 0;
        while (l < characters.length && r < characters.length && l <= r) {
            if (!charMap.containsKey(characters[r])){ // если найден новый элемент, то добавим его
                charMap.put(characters[r], 1);
                if (r - l + 1 == charMap.size()){
                    maxSubstring = Math.max(r - l + 1, maxSubstring);
                }
                r+=1;
            }else{ // если нашли элемент, который уже был, убираем элемент слева
                if (charMap.get(characters[l]) > 1){
                    charMap.put(characters[l], charMap.get(characters[l]) - 1);
                } else{
                    charMap.remove(characters[l]);
                }
                l+=1;
            }
        }
        return maxSubstring;
    }


    public static void testForSolution(){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));

    }
}

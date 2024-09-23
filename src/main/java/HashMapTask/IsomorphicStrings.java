package HashMapTask;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150
 * Можно ли получить первую строку, заменой идентичных символов из второй.
 * Например, egg = add если a -> e и g -> d
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
        testFunc();
    }

    public static boolean isomorphicStrings(String s, String t) {
        // по ходу движения будет составляться паттерн замены букв, который и будет проверяться
        // проверять будем паттерн в обоих направлениях
        // для примера egg = add если a -> e и g -> d, то и a <- e, g <- d
        HashMap<Character, Character> patternMap1 = new HashMap<>();
        HashMap<Character, Character> patternMap2 = new HashMap<>();
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (!patternMap1.containsKey(array1[i])) { // задаем паттерн конкретной букве в обоих направлениях
                patternMap1.put(array1[i], array2[i]);
            }

            if (!patternMap2.containsKey(array2[i])) {
                patternMap2.put(array2[i], array1[i]);
            }

            if (!(patternMap1.containsKey(array1[i]) && patternMap2.containsKey(array2[i])
                    && array1[i] == patternMap2.get(array2[i]) && array2[i] == patternMap1.get(array1[i]))) {
                // если выявили отклонение паттерна
                return false;
            }
        }
        return true;
    }

    public static void testFunc() {
        System.out.println(isomorphicStrings("egg", "add"));
        System.out.println(isomorphicStrings("foo", "bar"));
        System.out.println(isomorphicStrings("badc", "baba"));
    }


}

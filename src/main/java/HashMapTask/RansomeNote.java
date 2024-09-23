package HashMapTask;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/ransom-note/description/?envType=study-plan-v2&envId=top-interview-150
 * На вход дают две строки, выяснить, может ли первая быть сконструирована из элементов второй
 * Идея: создадим мапу для второй строки и подсчитаем кол-во возможных букв с их использованиями
 * А далее доставая данные из мапы пройдемся по первой строке и увидим, хватит ли их для строки
 */
public class RansomeNote {

    public static void main(String[] args) {
        testFunc();
    }

    public static boolean ransomeNote(String ransome, String magazine){
        HashMap<Character, Integer> magazineMap = new HashMap<>(); // создадим мапу для всех букв magazine и их кол-ва
        for (char currentChar : magazine.toCharArray()){
            if (magazineMap.containsKey(currentChar)){
                magazineMap.put(currentChar, magazineMap.get(currentChar) + 1);
            }else{
                magazineMap.put(currentChar, 1);
            }
        }
        for (char currentChar: ransome.toCharArray()){
            if (magazineMap.containsKey(currentChar)){
                if (magazineMap.get(currentChar) > 0){
                    magazineMap.put(currentChar, magazineMap.get(currentChar) - 1);
                } else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    public static void testFunc(){
        System.out.println(ransomeNote("a", "b"));
        System.out.println(ransomeNote("aa", "ab"));
        System.out.println(ransomeNote("aa", "aab"));
    }
}

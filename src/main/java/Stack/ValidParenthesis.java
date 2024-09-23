package Stack;


/**
 * https://leetcode.com/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-interview-150
 * Стоит вспомнить что такие конструкции ([)] не являются валидными, так как неправильный порядок закрытия скобок
 * Идея: использовать стек, и снимать с него элементы если встречаются () [] {}
 * И тогда в конце при успехе все конструкции закроются и стек останется пустым
 */

import java.util.Stack;


public class ValidParenthesis {
    public static void main(String[] args) {
        testFunc();
    }

    public static boolean validParenthesis(String s){
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char currentChar : chars){
            if (stack.empty()){
                stack.push(currentChar);
            } else{
                if ((stack.peek() == '(' && currentChar == ')')
                        || (stack.peek() == '[' && currentChar == ']')
                        || (stack.peek() == '{' && currentChar == '}')){
                    stack.pop();
                }else{
                    stack.push(currentChar);
                }
            }

        }

        return stack.empty();

    }

    public static void testFunc(){
        System.out.println(validParenthesis("()[]{}"));
        System.out.println(validParenthesis("([])"));
        System.out.println(validParenthesis("{)"));
    }
}

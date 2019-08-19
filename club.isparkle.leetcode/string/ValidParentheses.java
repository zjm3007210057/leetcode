package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * Input: "()"
 * Output: true
 *
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 * Input: "{[]}"
 * Output: true
 *
 * Created by zjm on 2019/7/30 21:37
 */
public class ValidParentheses {

    //很简单的题，根据题意直接使用栈，如果是左括号就加入栈中，如果是右括号则从栈顶弹出元素来比较，最后注意栈要为空
    public boolean isValid(String s) {
        Map<Character, Character> left = new HashMap();
        left.put('(', ')');
        left.put('[', ']');
        left.put('{', '}');
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()) {
            if(left.containsKey(c)) {
                stack.push(c);
            }else {
                if(stack.size() < 1) {
                    return false;
                }
                if(left.get(stack.pop()) != c) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}

package string;

import java.util.*;

/**
 * 17. Letter Combinations of a Phone Number
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * 1()     2(abc)  3(def)
 * 4(ghi)  5(jkl)  6(mno)
 * 7(pqrs) 8(tuv)  9(wxyz)
 * *(+)   0(space) #(shift)
 * <p>
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * Created by zjm on 2019/9/3 20:06
 */
public class LetterCombinationsOfAPhoneNumber {

    //按数字对应的字符进行全排列
    public List<String> letterCombinations(String digits) {
        if(digits.length() < 1) {
            return new ArrayList();
        }
        List<String> res = new ArrayList();
        Stack<String> s1 = new Stack();
        Stack<String> s2 = new Stack();
        Map<Character, String[]> map = new HashMap();
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"e", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});
        for(String i : map.get(digits.charAt(0))) {
            s1.push(i);
        }
        if(digits.length() > 1) {
            for(int i = 1; i < digits.length(); i++) {
                String[] tmp = map.get(digits.charAt(i));
                while(!s1.isEmpty()) {
                    String t = s1.pop();
                    for(String s : tmp) {
                        s2.push(t + s);
                    }
                }
                while(!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }
        }
        while(!s1.isEmpty()) {
            res.add(s1.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        Map<Character, char[]> map = new HashMap();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        List<String> list = new ArrayList<String>();
        list.add("b");
        list.add('f' + "");
        list.set(0, list.get(0) + 'v');
        System.out.println(list.get(0));
    }
}

package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * Created by zjm on 2019/9/4 20:38
 */
public class GenerateParentheses {

    //使用递归，左括号n个，右括号n个，
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        dfs(res, "", n, n);
        return res;
    }

    private void dfs(List<String> res, String s, int left, int right) {
        if(left > right) {
            return;
        }
        if(left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if(left > 0) {
            dfs(res, s + "(", left - 1, right);
        }
        if(right > 0) {
            dfs(res, s + ")", left, right - 1);
        }
    }

}

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
        //递归出口，找到了一个正确结果
        if(left == 0 && right == 0) {
            res.add(s);
            return;
        }
        //第一次递归，左子树
        if(left > 0) {
            dfs(res, s + "(", left - 1, right);
        }
        //第二次递归，右子树
        if(right > 0) {
            dfs(res, s + ")", left, right - 1);
        }
    }

    //使用递归，左括号n个，右括号n个，
    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList();
        char[] path = new char[n << 1];
        process(path, 0, 0, n, res);
        return res;
    }

    //path存储路径，表示index之前的位置括号已经选好了
    // leftMinusRight表示左括号减去右括号的数量，leftRest表示还剩于的左括号数目
    private void process(char[] path, int index, int leftMinusRight, int leftRest, List<String> res) {
        if(index == path.length) {
            res.add(String.valueOf(path));
        }else {
            if(leftRest > 0) {//左括号还有
                path[index] = '(';
                process(path, index + 1, leftMinusRight + 1, leftRest - 1, res);
            }
            if(leftMinusRight > 0) {
                path[index] = ')';
                process(path, index + 1, leftMinusRight - 1, leftRest, res);
            }
        }
    }
}

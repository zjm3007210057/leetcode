package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 93. Restore IP Addresses
 * <p>
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * Example:
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * <p>
 * Created by zjm on 2019/9/12 22:33
 */
public class RestoreIPAddresses {

    //在输入字符串中加入三个点，将字符串分为四段，每一段必须合法，求所有可能的情况
    //使用动态规划，每组排除首字母是0的超过两位的数字，
    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4 || s.length() > 12) {
            return Collections.EMPTY_LIST;
        }
        List<String> res = new ArrayList();
        dfs(s, 0, new String(), res);
        return res;
    }

    private void dfs(String s, int start, String item, List<String> res) {
        if(start == 3 && isValid(s)) {
            res.add(item + s);
            return;
        }
        for(int i = 0; i < 3 && i < s.length() - 1; i++) {
            String sub = s.substring(0, i+1);
            if(isValid(sub)) {
                dfs(s.substring(i+1, s.length()), start+1, item+sub+".", res);
            }
        }
    }

    private boolean isValid(String s) {
        if(s.charAt(0) == '0') {
            return s.equals("0");
        }
        int n = Integer.valueOf(s);
        if(n <= 255 && n > 0) {
            return true;
        }
        return false;
    }

    public List<String> restoreIpAddressesFaster(String s) {
        List<String> res = new ArrayList<String>();
        helper(s, 0, "", res);
        return res;
    }

    public void helper(String s, int n, String out, List<String> res) {
        if (n == 4) {
            if (s.isEmpty()) {
                res.add(out);
            }
            return;
        }
        for (int k = 1; k < 4; ++k) {
            if (s.length() < k) break;
            int val = Integer.parseInt(s.substring(0, k));
            //010转成整数变成10，长度和原来的字符串长度不相等
            if (val > 255 || k != String.valueOf(val).length()) continue;
            helper(s.substring(k), n + 1, out + s.substring(0, k) + (n == 3 ? "" : "."), res);
        }
    }

}

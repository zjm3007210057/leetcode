package dynamic;

/**
 * 10
 * Created by zjm on 2020/5/15 20:23
 */
public class RegularExpressionMatching {

    //dp[i][j]表示src前i个字符和dst前j个字符是否匹配
    //dp[0][0]=true, dp[i][0]=false, dp[0][j] = dp[
    public boolean isMatching(String src, String dst) {
        if(null == src || null == dst) {
            return false;
        }
        boolean[][] dp = new boolean[src.length() + 1][dst.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i <= dst.length(); i++) {
            if(dst.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-2];
            }
        }

        for(int i = 1; i <= src.length(); i++) {
            for(int j = 1; j <= dst.length(); j++) {
                if(dst.charAt(j-1) == '.' || dst.charAt(j-1) == src.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else if(dst.charAt(j-1) == '*') {
                    if(dst.charAt(j-2) == src.charAt(i-1) || dst.charAt(j-2) == '.') {
                        dp[i][j] = dp[i][j-2] || dp[i-1][j];
                    }else {
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }
        return dp[src.length()][dst.length()];
    }
}

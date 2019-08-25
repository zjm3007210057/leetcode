package string;

import java.util.HashSet;
import java.util.Set;

/**
 * 929. Unique Email Addresses
 *
 * Every email consists of a local name and a domain name, separated by the @ sign.
 *
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 *
 * If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
 *
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)
 *
 * It is possible to use both of these rules at the same time.
 *
 * Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?
 *
 * Example 1:
 * Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 *
 * Note:
 * 1 <= emails[i].length <= 100
 * 1 <= emails.length <= 100
 * Each emails[i] contains exactly one '@' character.
 * All local and domain names are non-empty.
 * Local names do not start with a '+' character
 *
 * @date 2019/8/25 上午10:16
 */
public class UniqueEmailAddresses {

    //从头开始遍历emails里面的每一个字符串的每一个字符进行判断，去掉对应的'.'和'+'变成新的字符串，最后使用set来判断不同字符串的个数
    public int numUniqueEmails(String[] emails) {
        String[] arr = new String[emails.length];
        int index = 0;
        for(String s : emails) {
            StringBuilder sb = new StringBuilder();
            boolean plus = false;
            boolean at = false;
            for(char c : s.toCharArray()) {
                if(c == '+' && !at) {
                    plus = true;
                }else if(c == '@') {
                    at = true;
                    sb.append(c);
                }else if(plus && !at) {
                    continue;
                }else if(at) {
                    sb.append(c);
                }else if(!at && c != '.') {
                    sb.append(c);
                }
            }
            arr[index++] = sb.toString();
        }
        Set<String> set = new HashSet();
        for(String s : arr) {
            set.add(s);
        }
        return set.size();
    }

    //使用字符串自有的分割方法和替代字符方法，注意点号是特殊字符，需要做转义
    public int numUniqueEmails1(String[] emails) {
        String[] arr = new String[emails.length];
        int index = 0;
        for(String s : emails) {
            String[] tmp = s.split("@");
            String s1 = null;
            if(tmp[0].contains("+")) {
                s1 = tmp[0].substring(0, tmp[0].indexOf('+')).replaceAll("\\.", "");
            }else {
                s1 = tmp[0].replaceAll("\\.", "");
            }
            arr[index++] = s1 + "@" + tmp[1];
        }
        Set<String> set = new HashSet();
        for(String s : arr) {
            set.add(s);
        }
        return set.size();
    }

}

package string;

/**
 * 1108. Defanging an IP Address
 * <p>
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * A defanged IP address replaces every period "." with "[.]".
 * <p>
 * Example 1:
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 *
 * Example 2:
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 * <p>
 * Constraints:
 * The given address is a valid IPv4 address
 * <p>
 * Created by zjm on 2019/8/28 20:07
 */
public class DefangingAnIPAddress {

    //一次循环字符数组，直接将点号.换成[.]
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for(char c : address.toCharArray()) {
            if(c != '.') {
                sb.append(c);
            }else {
                sb.append("[.]");
            }
        }
        return sb.toString();
    }

    //使用字符串自有的替代字符方法
    public String defangIPaddr2(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}

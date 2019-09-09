package string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 71. Simplify Path
 * <p>
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 * <p>
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double
 * period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix
 * <p>
 * Note that the returned canonical path must always begin with a slash /, and there must be only
 * a single slash / between two directory names. The last directory name (if it exists) must not
 * end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
 * <p>
 * Example 1:
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 *
 * Example 2:
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 *
 * Example 3:
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 *
 * Example 4:
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 *
 * Example 5:
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 *
 * Example 6:
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
 * <p>
 * Created by zjm on 2019/9/9 21:59
 */
public class SimplifyPath {

    //重复连续出现的'/'，只按1个处理，即跳过重复连续出现的'/'；
    //如果路径名是"."，则不处理；
    //如果路径名是".."，且list不为空，则删除最后的字符串
    //如果路径名为其他字符串，加入list
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder("/");
        String[] arr = path.split("/");
        LinkedList<String> list = new LinkedList();
        for(String s : arr) {
            if(s.equals("..")) {
                if(list.size() > 0) {
                    list.removeLast();
                }
            }else if(s.trim().length() > 0 && !s.equals(".")) {
                list.add(s);
            }
        }
        for(String s : list) {
            sb.append(s).append("/");
        }
        String res = sb.toString();
        if(res.length() > 1) {
            res = res.substring(0, res.length() - 1);
        }
        return res;
    }

    //使用栈代替LinkedList
    public String simplifyPath2(String path) {
        Stack<String> s = new Stack();
        String[] p = path.split("/");
        for (String t : p) {
            if(!s.isEmpty() && t.equals("..")) {
                s.pop();
            }else if(!t.equals(".") && !t.equals("") && !t.equals("..")) {
                s.push(t);
            }
        }
        List<String> list = new ArrayList(s);
        return "/" + String.join("/", list);
    }

}

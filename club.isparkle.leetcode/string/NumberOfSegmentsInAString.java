package string;

/**
 * 434. Number of Segments in a String
 * <p>
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * <p>
 * Please note that the string does not contain any non-printable characters.
 * <p>
 * Example:
 * <p>
 * Input: "Hello, my name is John"
 * Output: 5
 * <p>
 * Created by zjm on 2019/8/8 22:10
 */
public class NumberOfSegmentsInAString {

    //直接使用String的字符分割函数，然后判断每一段不等于""即可
    public int countSegments(String s) {
        String[] arr = s.split(" ");
        int res = 0;
        for(int i = 0; i < arr.length; i++) {
            if(!arr[i].trim().equals("")) {
                res++;
            }
        }
        return res;
    }
}

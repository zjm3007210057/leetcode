package string;

/**
 * 551. Student Attendance Record I
 * <p>
 * You are given a string representing an attendance record for a student.
 * The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 *
 * A student could be rewarded if his attendance record doesn't contain more
 * than one 'A' (absent) or more than two continuous 'L' (late).
 * <p>
 * You need to return whether the student could be rewarded according to his attendance record.
 * <p>
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 * <p>
 * Created by zjm on 2019/8/13 22:28
 */
public class StudentAttendanceRecordI {

    //直接根据题意可以写出算法
    public boolean checkRecord(String s) {
        int An = 0;//字符A出现的次数
        int Ln = 0;//字符L连续出现的次数
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'A') {
                An++;
            }
            while(i < s.length() && s.charAt(i) == 'L') {
                i++;
                Ln++;
            }
            if(An > 1 || Ln > 2) {
                return false;
            }
            //进入了while循环内部且没有返回false，表面此时s.charAt(i) != 'L'，因为for循环后面会对i进行加一，因此此时需要将i减一，
            //保证下一个字符进入循环
            if(Ln > 0) {
                i--;
            }
            //将Ln的值复原
            Ln = 0;
        }
        return true;
    }
}

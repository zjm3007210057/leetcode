package tools;

/**
 * Created by zjm on 2021/6/3 14:35
 */
public class BitOperation {

    //位运算实现加法
    public static int add(int a, int b) {
        int sum = a;
        while(b != 0) {
            sum = a ^ b; // 异或，结果为无进位加法结果
            b = (a & b) << 1;//进位信息：与运算然后左移一位
            a = sum;
        }
        return sum;
    }

    //位运算实现减法
    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    //位运算实现取负操作，按位取反加1
    public static int negNum(int n) {
        return add(~n, 1);
    }

    //位运算实现乘法
    public static int multi(int a, int b) {
        int res = 0;
        while(b != 0) {
            if((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public static int divide(int divided, int divisor) {
        if(divisor == Integer.MIN_VALUE) {
            return divided == Integer.MIN_VALUE ? 1 : 0;
        }
        //除数不是系统最小值
        if(divided == Integer.MIN_VALUE) {
            if(divisor == -1) {
                return Integer.MAX_VALUE;
            }
            int res = div(add(divided, 1), divisor);
            return add(res, div(minus(divided, multi(res, divisor)), divisor));
        }
        //a不是系统最小，b也不是系统最小
        return div(divided, divisor);
    }

    public static int div(int a, int b) {
        int x = a < 0 ? negNum(a) : a;
        int y = b < 0 ? negNum(b) : b;
        int res = 0;
        for(int i = 31; i >= 0; i = minus(i, 1)) {
            if((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return a < 0 ^ b < 0 ? negNum(res) : res;
    }
}

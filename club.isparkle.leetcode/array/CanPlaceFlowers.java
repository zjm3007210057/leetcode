package array;

/**
 * 605. Can Place Flowers
 *
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However,
 * flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n,
 * return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 *
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 *
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * Note:
 * 1.The input array won't violate no-adjacent-flowers rule.
 * 2.The input array size is in the range of [1, 20000].
 * 3.n is a non-negative integer which won't exceed the input array size.
 *
 * Created by zjm on 2019/5/19. 0 0 0 0 0 0 0 1
 */
public class CanPlaceFlowers {

    //find the number of place which can be filled with 1, then compare with n
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed == null || flowerbed.length < 1) {
            return false;
        }
        if(n > (flowerbed.length + 1) / 2) {
            return false;
        }
        int oneNum = 0;
        int zeroNum = 0;
        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0) {
                boolean leftOne = false;
                if(i > 0 && flowerbed[i - 1] == 1) {
                    leftOne = true;
                }
                zeroNum++;
                i++;
                while(i < flowerbed.length && flowerbed[i] == 0) {
                    zeroNum++;
                    i++;
                }
                boolean rightOne = false;
                if(i < flowerbed.length && flowerbed[i] == 1) {
                    rightOne = true;
                }
                if(leftOne && rightOne) {
                    oneNum += (zeroNum - 1) / 2;
                }else if(leftOne || rightOne) {
                    oneNum += zeroNum / 2;
                }else {
                    oneNum += (zeroNum + 1) / 2;
                }
                i--;
            }else {
                zeroNum = 0;
            }
        }
        return oneNum - n >= 0;
    }

    //find 0 place, and replace it with 1 if its pre and next are also 0, then n minus 1, if n <= 0, return true
    public boolean canPlaceFlowersBetter(int[] flowerbed, int n) {
        if(flowerbed.length < 1) {
            return false;
        }
        if(flowerbed.length == 1) {
            return (flowerbed[0] == 0 && n < 2) || n < 1;
        }
        for(int i = 0; i < flowerbed.length - 1; i++) {
            if(n == 0) return true;
            if(flowerbed[i] == 0) {
                if(i == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }else if(i > 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0){
                    flowerbed[i] = 1;
                    n--;
                }else if(i == flowerbed.length - 2 && flowerbed[i + 1] ==0) {
                    n--;
                }
            }
        }
        return n <= 0;
    }

    public boolean canPlaceFlowersSimple(int[] flowerbed, int n) {
        int pre = 0;
        int next = 0;
        for(int i = 0; i < flowerbed.length; i++) {
            if(n <= 0) return true;
            if(flowerbed[i] == 0) {
                pre = (i == 0 ? 0 : flowerbed[i - 1]);
                next = (i == flowerbed.length - 1 ? 0 : flowerbed[i + 1]);
                if(pre + next == 0) {
                    --n;
                    flowerbed[i] = 1;
                }
            }
        }
        return n <= 0;
    }
}

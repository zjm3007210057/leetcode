package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 914. X of a Kind in a Deck of Cards
 *
 * In a deck of cards, each card has an integer written on it.
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 *
 * Example 1:
 * Input: [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
 *
 * Example 2:
 * Input: [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition.
 *
 * Example 3:
 * Input: [1]
 * Output: false
 * Explanation: No possible partition.
 *
 * Example 4:
 * Input: [1,1]
 * Output: true
 * Explanation: Possible partition [1,1]
 *
 * Example 5:
 * Input: [1,1,2,2,2,2]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[2,2]
 *
 * Note:
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 *
 * Created by zjm on 2019/5/23.
 */
public class XOfAKindInADeckOfCards {

    //statistic every element occur numbers, then use GCD algorithm
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < deck.length; i++) {
            map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
        }
        for(int n : map.values()) {
            if(gcd(n, map.get(deck[0])) == 1) {
                return false;
            }
        }
        return true;
    }

    public int gcd(int m, int n){
        if(n == 0){
            return m;
        }else{
            return gcd(n,m%n);
        }
    }
}

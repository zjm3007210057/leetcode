package array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 950. Reveal Cards In Increasing Order
 *
 * In a deck of cards, every card has a unique integer.  You can order the deck in any order you want.
 * Initially, all the cards start face down (unrevealed) in one deck.
 * Now, you do the following steps repeatedly, until all cards are revealed:
 *
 * Take the top card of the deck, reveal it, and take it out of the deck.
 * If there are still cards in the deck, put the next top card of the deck at the bottom of the deck.
 * If there are still unrevealed cards, go back to step 1.  Otherwise, stop.
 * Return an ordering of the deck that would reveal the cards in increasing order.
 * The first entry in the answer is considered to be the top of the deck.
 *
 * Example 1:
 * Input: [17,13,11,2,3,5,7]
 * Output: [2,13,3,11,5,17,7]
 * Explanation:
 * We get the deck in the order [17,13,11,2,3,5,7] (this order doesn't matter), and reorder it.
 * After reordering, the deck starts as [2,13,3,11,5,17,7], where 2 is the top of the deck.
 * We reveal 2, and move 13 to the bottom.  The deck is now [3,11,5,17,7,13].
 * We reveal 3, and move 11 to the bottom.  The deck is now [5,17,7,13,11].
 * We reveal 5, and move 17 to the bottom.  The deck is now [7,13,11,17].
 * We reveal 7, and move 13 to the bottom.  The deck is now [11,17,13].
 * We reveal 11, and move 17 to the bottom.  The deck is now [13,17].
 * We reveal 13, and move 17 to the bottom.  The deck is now [17].
 * We reveal 17.
 * Since all the cards revealed are in increasing order, the answer is correct.
 *
 * Note:
 * 1 <= A.length <= 1000
 * 1 <= A[i] <= 10^6
 * A[i] != A[j] for all i != j
 *
 * Created by zjm on 2019/7/17 20:55 PM
 */
public class RevealCardsInIncreasingOrder {

    /**
     * input - [2,3,5,7,11,13,17] (just sort the input that you get)
     * The last number that you wanna get is the last number in the array - (17)
     * The penultimate number is 13. So put 13 on top of 17 (13,17) and bring the last number to top (17,13).
     * Now while you perform the action with (17,13), you will place 17 in the bottom and reveal 13 first - so it becomes (17), now reveal 17.
     * The number that you want before 13 is 11. Place 11 on top now (11,17,13) and bring the last number to the top (13,11,17).
     * Now when you perform the action with (13,11,17), you will place 13 in the bottom and reveal 11 - so it becomes (17,13),
     * now you will place 17 in the bottom and reveal 13 - it becomes (17), and then you will reveal 17.
     * current is 7 -> (7,13,11,17) -> (17,7,13,11) (add 7 to the queue, remove 17 from the queue and add back 17 to the queue)
     * current is 5 -> (5,17,7,13,11) -> (11,5,17,7,13) (add 5 to the queue, remove 11 from the queue and add back 11 to the queue)
     * current is 3 -> (3,11,5,17,7,13) -> (13,3,11,5,17,7) (add current to the queue, remove from the queue, add the removed number back to the queue)
     * current is 2 -> (2,13,3,11,5,17,7) -> Stop here since you don't have anymore numbers.
     */
    public int[] deckRevealedIncreasing(int[] deck) {
        int[] res = new int[deck.length];
        Arrays.sort(deck);
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = deck.length - 1; i >= 1; i--) {
            queue.addFirst(deck[i]);
            queue.addFirst(queue.pollLast());
        }
        queue.addFirst(deck[0]);
        for(int i = 0; i < deck.length; i++) {
            res[i] = queue.pollFirst();
        }
        return res;
    }
}

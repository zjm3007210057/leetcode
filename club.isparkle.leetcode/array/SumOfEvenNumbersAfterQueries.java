package array;

/**
 * 985. Sum of Even Numbers After Queries
 *
 * We have an array A of integers, and an array queries of queries.
 * For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then, the answer to the i-th query is the sum of the even values of A.
 * (Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)
 * Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.
 *
 * Example 1:
 * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * Output: [8,6,2,4]
 * Explanation:
 * At the beginning, the array is [1,2,3,4].
 * After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
 * After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
 * After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
 * After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 *
 * Note:
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * 1 <= queries.length <= 10000
 * -10000 <= queries[i][0] <= 10000
 * 0 <= queries[i][1] < A.length
 *
 * Created by zjm on 2019/5/25.
 */
public class SumOfEvenNumbersAfterQueries {

    //simple but costly method
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[A.length];
        for(int i = 0; i < queries.length; i++) {
            A[queries[i][1]] += queries[i][0];
            res[i] = sumA(A);
        }
        return res;
    }

    public int sumA(int[] A) {
        int res = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0) res += A[i];
        }
        return res;
    }

    public int[] sumEvenAfterQueriesBetter(int[] A, int[][] queries) {
        if(A.length < 1 || queries.length < 1 || queries[0].length < 2) {
            return new int[]{};
        }
        int[] res = new int[A.length];
        int tmp = sumA(A);
        for(int i = 0; i < queries.length; i++) {
            if(isEven(A[queries[i][1]], queries[i][0]) && !isEven(queries[i][0], 0)) {
                res[i] = i == 0 ? tmp + A[queries[i][1]] + queries[i][0] : res[i-1] + A[queries[i][1]] + queries[i][0];
                A[queries[i][1]] += queries[i][0];
            }else if(isEven(A[queries[i][1]], queries[i][0])) {
                res[i] = i == 0 ? tmp + queries[i][0] : res[i-1] + queries[i][0];
                A[queries[i][1]] += queries[i][0];
            }else if(!isEven(A[queries[i][1]], queries[i][0]) && !isEven(queries[i][0], 0)) {
                res[i] = i == 0 ? tmp - A[queries[i][1]] : res[i-1] - A[queries[i][1]];
                A[queries[i][1]] += queries[i][0];
            }else {
                res[i] = i == 0 ? tmp : res[i-1];
                A[queries[i][1]] += queries[i][0];
            }
        }
        return res;
    }

    public boolean isEven(int a, int b) {
        if(Math.abs(a + b) % 2 == 0) {
            return true;
        }
        return false;
    }

    public int[] sumEvenAfterQueriesBetterSimple(int[] A, int[][] queries) {
        if(A.length < 1 || queries.length < 1 || queries[0].length < 2) {
            return new int[]{};
        }
        int[] res = new int[A.length];
        int tmp = sumA(A);
        int index = 0;
        for(int[] arr : queries) {
            if(isEven(A[arr[1]], 0)) tmp -= A[arr[1]];
            if(isEven(arr[0], A[arr[1]])) tmp += arr[0] + A[arr[1]];
            A[arr[1]] += arr[0];
            res[index++] = tmp;
            if(index == A.length) break;
        }
        return res;
    }

}

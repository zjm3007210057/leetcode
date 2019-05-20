package array;

/**
 * 661. Image Smoother
 *
 * Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray
 * scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself.
 * If a cell has less than 8 surrounding cells, then use as many as you can.
 *
 * Example 1:
 * Input:
 * [[1,1,1],
 *  [1,0,1],
 *  [1,1,1]]
 * Output:
 * [[0, 0, 0],
 *  [0, 0, 0],
 *  [0, 0, 0]]
 *
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 *
 * Note:
 * 1.The value in the given matrix is in the range of [0, 255].
 * 2.The length and width of the given matrix are in the range of [1, 150].
 *
 * Created by zjm on 2019/5/20.
 */
public class ImageSmoother {

    //just list every probably
    public int[][] imageSmoother(int[][] M) {
        if(M.length == 0) {
			return M;
		}
		int[][] res = new int[M.length][M[0].length];
		for(int i = 0; i < M.length; i++) {
			for(int j = 0; j < M[0].length; j++) {
				if(i == 0) {
					if(j == 0 && i < M.length - 1 && j < M[0].length - 1) {
						res[i][j] = (M[i][j] + M[i+1][j] + M[i][j+1] + M[i+1][j+1]) / 4;
					}else if(j == 0 && i < M.length - 1) {
						res[i][j] = (M[i][j] + M[i+1][j]) / 2;
					}else if(j == 0 && j < M[0].length - 1) {
						res[i][j] = (M[i][j] + M[i][j+1]) / 2;
					}else if(j == 0){
						res[i][j] = M[i][j];
					}else if(j < M[0].length - 1 && i < M.length - 1) {
						res[i][j] = (M[i][j] + M[i+1][j] + M[i][j+1] + M[i+1][j+1] + M[i][j-1] + M[i+1][j-1]) / 6;
					}else if(j < M[0].length - 1 && i == M.length - 1){
						res[i][j] = (M[i][j] + M[i][j-1] + M[i][j+1]) / 3;
					}else if(j == M[0].length - 1 && i < M.length - 1) {
						res[i][j] = (M[i][j] + M[i+1][j] + M[i][j-1] + M[i+1][j-1]) / 4;
					}else if(j == M[0].length - 1 && i == M.length - 1) {
						res[i][j] = (M[i][j] + M[i][j-1]) / 2;
					}
				}else if(i < M.length - 1) {
					if(j == 0 && j < M[0].length - 1) {
						res[i][j] = (M[i][j] + M[i-1][j] + M[i+1][j] + M[i][j+1] + M[i-1][j+1] + M[i+1][j+1]) / 6;
					}else if(j == 0) {
						res[i][j] = (M[i][j] + M[i-1][j] + M[i+1][j]) / 3;
					}else if(j < M[0].length - 1) {
						res[i][j] = (M[i][j] + M[i-1][j] + M[i+1][j] + M[i][j+1] + M[i-1][j+1] + M[i+1][j+1] + M[i-1][j-1] + M[i][j-1] + M[i+1][j-1]) / 9;
					}else if(j == M[0].length - 1) {
						res[i][j] = (M[i][j] + M[i-1][j] + M[i+1][j] + M[i][j-1] + M[i-1][j-1] + M[i+1][j-1]) / 6;
					}
				}else {
					if(j == 0 && j < M[0].length - 1) {
						res[i][j] = (M[i][j] + M[i-1][j] + M[i][j+1] + M[i-1][j+1]) / 4;
					}else if(j == 0) {
						res[i][j] = (M[i][j] + M[i-1][j]) / 2;
					}else if(j < M[0].length - 1) {
						res[i][j] = (M[i][j] + M[i-1][j] + M[i][j+1] + M[i][j-1] + M[i-1][j-1] + M[i-1][j+1]) / 6;
					}else if(j == M[0].length - 1) {
						res[i][j] = (M[i][j] + M[i-1][j] + M[i][j-1] + M[i-1][j-1]) / 4;
					}
				}
			}
		}
		return res;
    }

    public int[][] imageSmootherSimple(int[][] M) {
        if(M.length == 0) {
            return M;
        }
        int[][] res = new int[M.length][M[0].length];
        for(int i = 0; i < M.length; i++) {
            for(int j = 0; j < M[0].length; j++) {
                int sum = 0;
                int count = 0;
                for(int m = i - 1; m < i + 2; m++) {
                    for(int n = j - 1; n < j + 2; n++) {
                        if(m >= 0 && m < M.length && n >= 0 && n < M[0].length) {
                            sum += M[m][n];
                            count++;
                        }
                    }
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}

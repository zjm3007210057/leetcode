package array;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * <p>
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * <p>
 * Return the following binary tree:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * Created by zjm on 2019/6/11 22:05
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    //just like ConstructBinaryTreeFromPreorderAndInorderTraversal
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] in, int[] post, int instart, int inend, int pstart, int pend) {
        if (instart > inend) {
            return null;
        }
        if (instart == inend) {
            return new TreeNode(in[instart]);
        }

        int rootIndex = instart;
        for(int i = instart; i <= inend; i++) {
            if(in[i] == post[pend]) {
                rootIndex = i;
            }
        }
        TreeNode root = new TreeNode(post[pend]);
        int leftSize = rootIndex - instart;
        root.left = buildTree(in, post, instart, rootIndex - 1, pstart, pstart + leftSize - 1);
        root.right = buildTree(in, post, rootIndex + 1, inend, pstart + leftSize, pend - 1);
        return root;
    }
}

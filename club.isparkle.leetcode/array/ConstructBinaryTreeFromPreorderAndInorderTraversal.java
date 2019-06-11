package array;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Created by zjm on 2019/6/11 17:39 PM
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    //use iteration, the first element in preorder is root, find the root in inorder and split inorder into two
    //pieces with rootIndex
    //preorder: root, left, right
    //inorder: left, root, right
    //postorder: left, right, root
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode help(int[] pre, int start, int end, int[] in, int begin, int last) {
        if(start > end || begin > last) {
            return null;
        }
        if(begin == last) {
            return new TreeNode(in[last]);
        }
        int rootIndex = 0;
        for(int i = begin; i <= last; i++) {
            if(in[i] == pre[start]) {
                rootIndex = i;
                break;
            }
        }
        int len = rootIndex - begin;
        TreeNode root = new TreeNode(pre[start]);
        root.left = help(pre, start+1, start+len, in, begin, rootIndex-1);
        root.right = help(pre, start+len+1, end, in, rootIndex+1, last);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, preorder.length-1);
    }

    public TreeNode build(int[] pre, int[] in, int start,
                          int begin, int end) {
        if (end < begin) {
            return null;
        }
        if(end == begin) {
            return new TreeNode(in[end]);
        }
        TreeNode node = new TreeNode(pre[start]);

        // the rootIndex of current node in inorder
        int rootIndex = 0;
        for(int i = begin; i <= end; i++) {
            if(in[i] == pre[start]) {
                rootIndex = i;
                break;
            }
        }
        int lenL = rootIndex - begin;
        int lenR = end - begin - lenL;

        if (lenL > 0) {
            node.left = build(pre, in, start + 1, begin, rootIndex - 1);
        }
        if (lenR > 0) {
            node.right = build(pre, in, start + lenL + 1, rootIndex + 1, end);
        }

        return node;
    }

}

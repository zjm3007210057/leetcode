package string;

/**
 * 606. Construct String from Binary Tree
 * <p>
 * You need to construct a string consists of parenthesis and integers
 * from a binary tree with the preorder traversing way.
 * <p>
 * The null node needs to be represented by empty parenthesis pair "()".
 * And you need to omit all the empty parenthesis pairs that don't affect the one-to-one
 * mapping relationship between the string and the original binary tree.
 * <p>
 * Example 1:
 * Input: Binary tree: [1,2,3,4]
 * 1
 * /   \
 * 2     3
 * /
 * 4
 * <p>
 * Output: "1(2(4))(3)"
 * <p>
 * Explanation: Originallay it needs to be "1(2(4)())(3()())",
 * but you need to omit all the unnecessary empty parenthesis pairs.
 * And it will be "1(2(4))(3)".
 * Example 2:
 * Input: Binary tree: [1,2,3,null,4]
 * 1
 * /   \
 * 2     3
 * \
 * 4
 * <p>
 * Output: "1(2()(4))(3)"
 * <p>
 * Explanation: Almost the same as the first example,
 * except we can't omit the first parenthesis pair to break the one-to-one
 * mapping relationship between the input and the output
 * <p>
 * Created by zjm on 2019/8/15 20:21
 */
public class ConstructStringFromBinaryTree {

    // 用递归的方法前序遍历，在遍历节点前加入(，遍历节点后加入)即可。
    // 如果左右子节点为空，则不需要其子节点的()。如果只有右子节点，
    // 则左子节点需要用()代替，以区分只有左子节点而无右子节点的情况
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        scan(t, sb);
        return sb.toString();
    }

    private void scan(TreeNode t, StringBuilder sb) {
        // sb.append(scan(t.right, sb));
        if(t == null) {
            return;
        }
        sb.append(t.val + "");
        if(t.left != null) {
            sb.append("(");
            scan(t.left, sb);
            sb.append(")");
        }
        if(t.right != null) {
            if(t.left == null) {
                sb.append("()");
            }
            sb.append("(");
            scan(t.right, sb);
            sb.append(")");
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}



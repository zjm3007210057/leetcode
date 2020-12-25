package tree;

/**
 * 树的遍历
 * Created by zjm on 2020/8/12 08:26
 */
public class Traverse {

    public static void preTraverse(Tree<Integer> head) {
        if(head == null) {
            return;
        }
        System.out.println(head.getValue());
        preTraverse(head.getLeft());
        preTraverse(head.getRight());
    }

    public static void inTraverse(Tree<Integer> head) {
        if(head == null) {
            return;
        }
        preTraverse(head.getLeft());
        System.out.println(head.getValue());
        preTraverse(head.getRight());
    }

    public static void postTraverse(Tree<Integer> head) {
        if(head == null) {
            return;
        }
        preTraverse(head.getLeft());
        preTraverse(head.getRight());
        System.out.println(head.getValue());
    }

    public static void main(String[] args) {
        Tree<Integer> head = new Tree<Integer>(1);
        head.setLeft(new Tree<Integer>(2));
        head.setRight(new Tree<Integer>(3));
        head.getLeft().setLeft(new Tree<Integer>(4));
        head.getLeft().setRight(new Tree<Integer>(5));
        head.getRight().setLeft(new Tree<Integer>(6));
        head.getRight().setRight(new Tree<Integer>(7));
        preTraverse(head);
        System.out.println("=========");
        inTraverse(head);
        System.out.println("=========");
        postTraverse(head);
    }
}

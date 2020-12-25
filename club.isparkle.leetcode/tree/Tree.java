package tree;

/**
 * Created by zjm on 2020/8/12 08:27
 */
public class Tree<T> {

    private T value;

    private Tree<T> left;

    private Tree<T> right;

    public Tree(T value) {
        this.value = value;
    }

    /**
     * @return Gets the value of left and returns left
     */
    public Tree<T> getLeft() {
        return left;
    }

    /**
     * Sets the left
     * You can use getLeft() to get the value of left
     */
    public void setLeft(Tree<T> left) {
        this.left = left;
    }

    /**
     * @return Gets the value of right and returns right
     */
    public Tree<T> getRight() {
        return right;
    }

    /**
     * Sets the right
     * You can use getRight() to get the value of right
     */
    public void setRight(Tree<T> right) {
        this.right = right;
    }

    /**
     * @return Gets the value of vlaue and returns vlaue
     */
    public T getValue() {
        return value;
    }

    /**
     * Sets the vlaue
     * You can use getVlaue() to get the value of vlaue
     */
    public void setValue(T value) {
        this.value = value;
    }
}

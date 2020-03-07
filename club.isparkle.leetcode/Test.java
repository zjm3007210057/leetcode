/**
 * Created by zjm on 2020/1/13 21:15
 */
public class Test {

    static class Father {
        public int money = 1;

        public Father() {
            money = 2;
            print();
        }

        public void print() {
            System.out.println("I am father, I have $" + money);
        }
    }

    static class Son extends Father {
        public int money = 3;

        public Son() {
            money = 4;
            print();
        }

        public void print() {
            System.out.println("I am son, I have $" + money);
        }
     }

    public static void main(String[] args) {
        Father son = new Son();
        System.out.println("this guy has $" + son.money);
    }
}

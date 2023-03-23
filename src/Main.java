import bts.BTS;

public class Main {
    public static void main(String[] args) {
        BTS bts = new BTS();
        bts.insert(20);
        bts.insert(2);
        bts.insert(50);
        bts.insert(220);
        bts.insert(70);
        bts.insert(1);
        bts.insert(90);
        System.out.println("Inorder");
        bts.inorder();
        System.out.println();
        System.out.println("Postorder");
        bts.postOrder();
        System.out.println();
        System.out.println("Preorder");
        bts.preOrder();
        System.out.println();
        System.out.println("Breadth-first");
        bts.breadthFirst();
        bts.deleteKey(220);
        System.out.println();
        System.out.println("New");
        bts.breadthFirst();
        System.out.println();
        System.out.println(bts.search(10)?"Exist":"Does not exist");
    }
}

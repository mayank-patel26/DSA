package ADS.BinomialHeap;
import java.util.ArrayList;
import java.util.HashMap;

public class BinomialHeap {

    public static void main(String[] args){
        BinomialHeap b = new BinomialHeap();
        Node tree1 = b.createTree(1);
        Node tree2 = b.createTree(2);
        System.out.println("Tree 1: ");
        b.print(tree1,"");
        System.out.println("Tree 2: ");
        b.print(tree2,"");
        System.out.println("Merged tree: ");
        b.print(b.merge(tree1, tree2),"");
    }

    private Node merge(Node tree1, Node tree2) {
        Node root = new Node(-1);
        HashMap<Integer, Node> map = new HashMap<>();
        for(Node i: tree1.children){
            map.put(i.order,i);
        }
        for(Node j: tree2.children){
            if(map.containsKey(j.order)){
                if(j.val<map.get(j.order).val){
                    j.children.add(0,map.get(j.order));
                    map.put(j.order,j);
                }
                else{
                    Node temp = map.get(j.order);
                    temp.children.add(0,j);
                    map.put(j.order,temp);
                }
            }
        }
        for(Integer i:map.keySet()){
            root.children.add(map.get(i));
        }
        return root;
    }

    private void print(Node parent, String tab) {
        if(parent==null){
            return;
        }
        System.out.println(tab+"["+parent.val+"]");
        for(Node i:parent.children){
            print(i,tab+"\t");
        }
    }

    private Node createTree(int o) {
        if(o==1) {

            Node root = new Node(-1);
            root.children.add(new Node(13, 0));
            root.children.add(new Node(7, 1));
            root.children.add(new Node(15, 2));
            root.children.get(1).children.add(new Node(25));
            Node temp = root.children.get(2);
            temp.children.add(new Node(28));
            temp.children.add(new Node(33));
            temp.children.get(0).children.add(new Node(41));
            return root;
        }

            if(o==2) {
                Node root1 = new Node(-1);
                root1.children.add(new Node(44, 0));
                root1.children.add(new Node(10, 1));
                root1.children.add(new Node(8, 2));
                root1.children.get(1).children.add(new Node(40));
                Node temp1 = root1.children.get(2);
                temp1.children.add(new Node(30));
                temp1.children.add(new Node(23));
                temp1.children.get(0).children.add(new Node(48));
                return root1;
            }
        return null;
    }

}

class Node{
    ArrayList<Node> children;
    int val;
    int order;
    Node(int val){
        children = new ArrayList<>();
        this.val=val;
    }
    Node(int val, int order){
        children = new ArrayList<>();
        this.val=val;
        this.order=order;
    }
}

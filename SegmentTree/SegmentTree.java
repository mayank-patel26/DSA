package ADS.SegmentTree;

import java.util.ArrayList;

public class SegmentTree {
    static Node root;
    static ArrayList<Integer> values;

    static Node construct(Node parent, int low, int high){
        if(parent==null){
            Node newNode = new Node(low,high);
            root = newNode;
            construct(root, low, high);
        }
        else{
            if(low<high){
                Node newNode = new Node(low,(low+high)/2);
                parent.left = newNode;
                construct(parent.left,low,(low+high)/2);
                Node newNode1 = new Node(((low+high)/2)+1,high);
                parent.right = newNode1;
                construct(parent.right,((low+high)/2)+1,high);
                parent.value = parent.left.value+parent.right.value;
            }
            if(low==high){
                parent.value=values.get(parent.low);
            }
        }
        return root;
    }

    static int findSum(Node parent, int low, int high){
        if(low<=parent.low&&high>=parent.high){
            return parent.value;
        }
        if(high<parent.low || low>parent.high){
            return 0;
        }
        return findSum(parent.left,low,high)+findSum(parent.right,low,high);
    }

    static Integer update(Node parent, int index, int value){
        if(index<=parent.low && index>=parent.high){
            int diff = value - parent.value;
            parent.value = value;
            return diff;
        }
        if(index<parent.low || index>parent.high){
            return null;
        }
        Integer dif_right=update(parent.right,index,value);
        Integer dif_left=update(parent.left,index,value);
        Integer difference = (dif_left==null)?dif_right:dif_left;
        parent.value += difference;
        return difference;
    }

    static void print(Node parent){
        if(parent==null){
            return;
        }print(parent.left);
        System.out.println(parent.low+"-"+parent.high+", "+parent.value);
        print(parent.right);
    }

    public static void main(String[] args){
        values = new ArrayList<Integer>();
        values.add(1);
        values.add(3);
        values.add(5);
        values.add(7);
        values.add(9);
        values.add(11);
        construct(root, 0, values.size()-1);
        System.out.println("\nInorder Traversal: ");
        print(root);
        System.out.println("\nSum of interval [2-3]: "+findSum(root,2,3));
        System.out.println("\nUpdate index 4 to 10: "+update(root,4,10));
        System.out.println("Inorder Traversal: ");
        print(root);
    }
}

class Node{
    int low;
    int high;
    int value;
    Node left;
    Node right;
    Node(int low, int high){
        this.low = low;
        this.high = high;
    }
    Node(int low, int high, int value){
        this.low = low;
        this.high = high;
        this.value = value;
    }

}

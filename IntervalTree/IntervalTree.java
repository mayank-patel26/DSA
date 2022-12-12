package ADS.IntervalTree;

public class IntervalTree {
    static Node root;

    static Node insertNode(Node parent, int low, int high){
        if(parent==null){
            Node newNode = new Node(low, high, high);
            root=newNode;
            return root;
        }
        else{
            if (low < parent.low) {
                if (parent.left == null) {
                    Node newNode = new Node(low, high);
                    parent.left = newNode;
                }
                insertNode(parent.left, low, high);
            }
            if (low > parent.low) {
                if (parent.right == null) {
                    Node newNode = new Node(low, high);
                    parent.right = newNode;
                }
                insertNode(parent.right, low, high);
            }
        }
        updateMaxEnd(root);
        return root;
    }

    static int findMaxEP(Node parent){
        if(parent == null){
            return 0;
        }else{
            int maxLeft, maxRight;
            int max = parent.high;
            if(parent.left!=null){
                maxLeft = findMaxEP(parent.left);
                max = Math.max(max,maxLeft);
            }
            if(parent.right!=null){
                maxRight = findMaxEP(parent.right);
                max = Math.max(max,maxRight);
            }
            return max;
        }
    }

    static void updateMaxEnd(Node parent){
        if(parent==null){
            return;
        }
        updateMaxEnd(parent.left);
        parent.maxEnd = findMaxEP(parent);
        updateMaxEnd(parent.right);
    }

    static void print(Node parent){
        if(parent==null){
            return;
        }print(parent.left);
        System.out.println(parent.low+"-"+parent.high+", "+parent.maxEnd);
        print(parent.right);
    }

//    static void print(Node parent, String tab){
//        if(parent==null){
//            return;
//        }
//        System.out.println(tab+"["+parent.low+","+parent.high+","+ parent.maxEnd+"]");
//        print(parent.left,"\t");
//        print(parent.right,"\t");
//    }

    static void findIntersect(Node parent, int low, int high){
        if(parent==null){
            System.out.println("NOT FOUND");
            return;
        }
        if(low<=parent.high && high>=parent.low){
            System.out.println("FOUND: "+parent.low+"-"+parent.high);
        }else if(parent.left == null) {
            findIntersect(parent.right, low, high);
        }else if(parent.left.maxEnd<low) {
            findIntersect(parent.right, low, high);
        }else{
            findIntersect(parent.left,low,high);
        }
    }

    public static void main(String[] args){
        root = insertNode(root,17,19);
        root = insertNode(root, 5,8);
        root = insertNode(root, 21,24);
        root = insertNode(root, 4,8);
        root = insertNode(root, 15,18);
        root = insertNode(root, 7,10);
        root = insertNode(root, 16,22);
        findIntersect(root, 23,24);
        print(root);
        System.out.println(root.low+"-"+root.high);
    }
}

class Node{
    int low;
    int high;
    int maxEnd;

    Node left;
    Node right;

    public Node(int low, int high){
        this.low = low;
        this.high = high;
    }

    public Node(int low, int high, int maxEnd){
        this.low = low;
        this.high = high;
        this.maxEnd = maxEnd;
    }
}

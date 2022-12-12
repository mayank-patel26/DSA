package ADS.RBTree;

public class RBTree {
    static Node root, grandparent, findToInsert;
    public static void main(String[] args){
        RBTree b= new RBTree();
        root = b.insert(root, 2);
        root = b.insert(root, 1);
        root = b.insert(root, 4);
        root = b.insert(root, 5);
        root = b.insert(root, 9);
        root = b.insert(root, 3);
        root = b.insert(root, 6);
        root = b.insert(root, 7);
        b.print(root,"");
    }

    private Node insert(Node parent, int val) {
        if(parent==null){
            Node newNode = new Node(val, true);
            root = newNode;
            root.isRed = false;
            addNull(root);
            return root;
        }
        if(parent.left == null && parent.right == null){
            return root;
        }
        else{
            if(val<parent.val){
                if(parent.left.val==0){
                    boolean parentIsRed = parent.isRed;
                    Node newNode = new Node(val, true);
                    parent.left = newNode;
                    addNull(parent.left);
                if(parentIsRed){
                    balanceLeft(grandparent, parent, parent.left);
                }
                }
                grandparent = parent;
                insert(parent.left, val);
            }
            if(val>parent.val){
                if(parent.right.val==0){
                    boolean parentIsRed = parent.isRed;
                    Node newNode = new Node(val, true);
                    parent.right = newNode;
                    addNull(parent.right);
                if(parentIsRed){
                    balanceRight(grandparent, parent, parent.right);
                }
                }
                grandparent = parent;
                insert(parent.right, val);
            }
        }
        return root;
    }

    private Node balanceLeft(Node grandparent, Node parent, Node left) {
        if(parent==null){
            return null;
        }else{
            Node uncle = grandparent.right;
            if(!uncle.isRed){
                findToInsert = findNode(root, grandparent);
                if(grandparent.right.val==0 && parent.right.val==0) {
                    findToInsert.left = (LLRotation(grandparent, parent, left));
                }else{
                    findToInsert.left =  (RLRotation(grandparent, parent, left));
                }
                if(findToInsert==root){
                    root=findToInsert;
                }
                return findToInsert;
            }else{
                return (flipColors(grandparent, parent, left));
            }
        }
    }

    private Node balanceRight(Node grandparent, Node parent, Node right) {
        if(parent==null){
            return null;
        }else{Node uncle=null;
            if(grandparent.left.val==0){
                uncle = grandparent.left;
            }else{
                uncle = grandparent.right;
            }
            if(!uncle.isRed){
                findToInsert = findNode(root, grandparent);
                if(grandparent.left.val==0 && parent.left.val==0){
                    findToInsert.right =  (RRRotation(grandparent, parent, right));
                }else{
                    findToInsert.right =  (LRRotation(grandparent, parent, right));
                }
                if(findToInsert==root){
                    root=findToInsert;
                }
                return findToInsert;
            }else{
                return (flipColors(grandparent, parent, right));
            }
        }
    }
    private Node flipColors(Node grandparent, Node parent, Node child) {
        parent.isRed = false;
        if(grandparent.left.val==0){
            grandparent.right.isRed = false;
        }else if(grandparent.right.val==0){
            grandparent.left.isRed = false;
        }else{
            grandparent.right.isRed = false;
            grandparent.left.isRed = false;
        }
        if(grandparent==root){
            grandparent.isRed = false;
        }else{
            grandparent.isRed = true;
        }
        return grandparent;
    }

    private Node LLRotation(Node grandparent, Node parent, Node left) {
        boolean addBlackNull = false;
        Node semiRoot = null;
        semiRoot = parent;
        semiRoot.left = left;
        semiRoot.left.isRed = true;
        if(grandparent.right.val==0){
            addBlackNull=true;
        }
        semiRoot.right = grandparent;
        semiRoot.right.isRed = true;
        if(addBlackNull){
            addNull(semiRoot.right);
        }
        semiRoot.isRed = false;
        return semiRoot;
    }

    private Node RRRotation(Node grandparent, Node parent, Node right) {
        boolean addBlackNull = false;
        Node semiRoot = null;
        semiRoot = parent;
        semiRoot.right = right;
        semiRoot.right.isRed = true;
        if(grandparent.left.val==0){
            addBlackNull=true;
        }
        semiRoot.left = grandparent;
        semiRoot.left.isRed = true;
        if(addBlackNull){
            addNull(semiRoot.left);
        }
        semiRoot.isRed = false;
        return semiRoot;
    }

    private Node RLRotation(Node grandparent, Node parent, Node left) {
        addNull(left);
        Node temp = left;
        addNull(parent);
        Node temp1 = parent;
        grandparent.right = temp;
        parent=grandparent.right;
        parent.right=temp1;
        left=temp1;
        return RRRotation(grandparent, parent, left);
    }

    private Node LRRotation(Node grandparent, Node parent, Node right) {
        addNull(right);
        Node temp = right;
        addNull(parent);
        Node temp1 = parent;
        grandparent.left = temp;
        parent=grandparent.left;
        grandparent.left.left=temp1;
        right = parent.left;
        System.out.println("DEBUG");
        return LLRotation(grandparent, parent, right);
    }
    private Node findNode(Node parent, Node toFind) {
        if(parent==null){
            return null;
        }
        if(toFind.val < parent.left.val){
            return findNode(parent.left, toFind);
        }
        if(parent.val == toFind.val){
            return parent;
        }
        if(toFind.val > parent.right.val){
            return findNode(parent.right, toFind);
        }
        return parent;
    }


    private void addNull(Node node) {
        Node newNodeLeft = new Node(0, false);
        Node newNodeRight = new Node(0, false);
        node.left = newNodeLeft;
        node.right = newNodeRight;
    }


    void print(Node parent, String tab){
        if(parent==null){
            return;
        }
        System.out.println(tab+"["+parent.val+","+parent.isRed+"]");
        print(parent.left,tab+"\t");
        print(parent.right,tab+"\t");
    }
}

class Node{
    Node left;
    Node right;
    int val;
    boolean isRed;
    Node(int val, boolean isRed){
        this.val = val;
        this.isRed = isRed;
    }
}

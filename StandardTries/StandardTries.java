package ADS.StandardTries;

import java.util.ArrayList;

public class StandardTries {
    static Node root;
    static String toDelete;
    static void print(Node x, String tab)
    {
        if(x==null)
            return;
        System.out.println(tab+"["+x.val+"]");
        for(Node y:x.children)
            print(y,tab+"  ");
    }

    static void add(Node parent, String s){
        if(s.length()==0){
            return;
        }
        for(Node i: parent.children){
            if(i.val==s.charAt(0)){
                add(i,s.substring(1));
                return;
            }
        }
        Node newNode = new Node(s.charAt(0));
        parent.children.add(newNode);
        add(newNode,s.substring(1));
    }

    static boolean search(Node parent, String s){
        if(s.length()==0){
            return true;
        }
        for(Node i:parent.children){
            if(i.val==s.charAt(0)){
                return search(i,s.substring(1));
            }
        }
        return false;
    }

    static boolean delete(Node parent, String s){//[/],pet| [p], et
        if(s.length()==0){
            return true;
        }
        for(int i=0;i<parent.children.size();i++){//[c],[p]|[e]|[t]
            Node child = parent.children.get(i);//[t]
            if(child.val==s.charAt(0)){
                boolean check = delete(child, s.substring(1));
                if(check==true){
                    parent.children.remove(child);
                    if(parent.children.size()!=0){
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        root = new Node();
        add(root,"cat/");
        add(root,"pet/");
        add(root,"pen/");
        print(root,"");
        System.out.println(search(root,"cat/"));
        System.out.println(search(root,"mat/"));
        toDelete = "pet";
        delete(root,"pet");
        print(root,"");
    }
}

class Node{
    char val;
    ArrayList<Node> children;
    Node(){
        children = new ArrayList<>();
        val='/';
    }
    Node(char x){
        children = new ArrayList<>();
        val=x;
    }
}

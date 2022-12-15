import java.util.*;

public class Permutations{

    static void findPermutations(String str, int left, int right){
        if(left==right){
            System.out.println(str);
        }else{
            for(int i=left; i<=right;i++){
                str = swap(str, left, i);
                findPermutations(str, left+1, right);
                str = swap(str, left, i);
            }
        }
    }

    static String swap(String str, int left, int right){
        char charArray[] = str.toCharArray();
        char temp = charArray[left];
        charArray[left] = charArray[right];
        charArray[right] = temp;
        
        return String.valueOf(charArray);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();

        findPermutations(str, 0, str.length()-1);

        sc.close();
    }
}
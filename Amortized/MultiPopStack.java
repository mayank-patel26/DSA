package ADS.Amortized;
import java.util.Arrays;
public class MultiPopStack {
    int top;
    int balance;
    int[] stack;
    int sumAgg, sumAcc, sumPot;
    static MultiPopStack m;
    MultiPopStack(int n){
        stack = new int[n];
        top=0;
    }

    void push(int val){
        if(top>m.stack.length){
            System.out.println("Stack is full");
        }
        stack[top++] = val;
        sumAgg += 1;
        sumAcc += balance+1;
        sumPot += 1+top-(top-1);
        System.out.print("|\t\t Push "+val+"  \t\t|\t\t\t\t1\t\t\t\t|\t\t\t  "+balance+"+1="+(++balance)+" \t\t\t|\t\t\t 1+"+top+"-"+(top-1)+"="+(1+top-(top-1))+" \t\t\t|\t\t"+Arrays.toString(m.stack)+"\t\t|\n");
    }

    boolean pop(int n){
        if(n>top){
            System.out.println("Stack doesn't contain enough elements");
            return false;
        }
        int init = top;
        for(int i=0;i<n;i++){
            stack[--top] = 0;
        }
        sumAgg += n;
        sumAcc += balance-n;
        sumPot += n+top-init;
        System.out.print("|\t\t Pop "+n+"   \t\t|\t\t\t\t"+n+"\t\t\t\t|\t\t\t  "+balance+"-"+n+"="+(balance-n)+" \t\t\t|\t\t\t "+n+"+"+top+"-"+init+"="+(n+top-init)+" \t\t\t|\t\t"+Arrays.toString(m.stack)+"\t\t|\n");
        balance-=n;
        return true;
    }

    static void printTable(){
        System.out.print("|\t\tOperation\t\t|\t\t\tAggregate\t\t\t|\t\t\tAccounting\t\t\t|\t\t\tPotential\t\t\t|\t\t\t\t\tStack\t\t\t\t\t|\n");
        System.out.print("|\t\t\t\t\t\t|\t\t\t cost(i) \t\t\t|\t\t  balance-cost(i)  \t\t|\t\tcost(i)+P(i)-P(i-1)\t\t|\t\t"+Arrays.toString(m.stack)+"\t\t|\n");
    }

    public static void main(String[] args){
        m = new MultiPopStack(10);
        printTable();
        m.push(5);
        m.push(6);
        m.push(9);
        m.push(8);
        m.pop(2);
        m.push(4);
        m.push(7);
        m.pop(4);
        System.out.print("|\t\t  SUM\t\t\t|\t\t\t\t"+ m.sumAgg+" \t\t\t\t|\t\t\t    "+m.sumAcc+" \t\t\t\t|\t\t\t   "+m.sumPot+" \t\t\t\t|\t\t\t\t\t\t\t\t\t\t\t|\n");
        System.out.print("|\t Amortized Cost\t\t|\t\t\t\t"+ 1+" \t\t\t\t|\t\t\t    "+ m.balance+" \t\t\t\t|\t\t\t   "+m.sumPot/m.sumAgg+" \t\t\t\t|\t\t\t\t\t\t\t\t\t\t\t|\n");
    }
}

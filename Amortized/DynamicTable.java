package ADS.Amortized;

import java.util.Arrays;

public class DynamicTable {
    int[] table;
    int top;
    int balance, potential;
    int sumAgg, sumAcc, sumPot;

    static DynamicTable t;
    DynamicTable(int n){
        table = new int[n];
        top = 0;
    }

    static void printTable(){
        System.out.print("|\t\tOperation\t\t|\t\t\tAggregate\t\t\t|\t\t\tAccounting\t\t\t|\t\t\tPotential\t\t\t|\t\t\t\t\tStack\t\t\t\t\t\n");
        System.out.print("|\t\t\t\t\t\t|\t\t\t cost(i) \t\t\t|\t\t  balance+3-cost(i)\t\t|\t\tcost(i)+P(i)-P(i-1)\t\t|\t\t"+ Arrays.toString(t.table)+"\t\t\n");
    }

    void insert(int val){
        int tempPot;
        if(top>=table.length){
            int[] temp = new int[top*2];
            for(int i=0;i<top;i++){
                temp[i] = table[i];
            }
            temp[top++] = val;
            table = temp;
            tempPot = 2*top - table.length;
            System.out.print("|\t\t Insert "+val+"  \t\t|\t\t\t\t"+(top)+"\t\t\t\t|\t\t\t  "+balance+"+3-"+top+"="+(balance+3-top)+" \t\t\t|\t\t\t "+top+"+"+tempPot+"-"+potential+"="+(top+tempPot-potential)+"\t\t\t|\t\t"+Arrays.toString(t.table)+"\t\t\n");
            balance = balance+3-top;
            sumPot += (top+tempPot-potential);
            potential = tempPot;
            sumAgg+=top;
        }else{
            table[top++] = val;
            tempPot = 2*top - table.length;
            System.out.print("|\t\t Insert "+val+"  \t\t|\t\t\t\t1\t\t\t\t|\t\t\t  "+balance+"+3-"+1+"="+(balance+2)+" \t\t\t|\t\t\t 1+"+tempPot+"-"+potential+"="+(1+tempPot-potential)+"\t\t\t|\t\t"+Arrays.toString(t.table)+"\t\t\n");
            balance += 2;
            sumPot += (1+tempPot-potential);
            potential = tempPot;
            sumAgg+=1;
        }
        sumAcc+=balance;
    }


    public static void main(String[] args){
        t = new DynamicTable(1);
        printTable();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(5);
        t.insert(6);
        t.insert(7);
        System.out.print("|\t\t\t Sum   \t\t|\t\t\t\t"+t.sumAgg+"\t\t\t\t|\t\t\t\t "+t.sumAcc+" \t\t\t|\t\t\t\t "+t.sumPot+" \t\t\t|\t\t"+Arrays.toString(t.table)+"\t\t\n");
        System.out.print("|\t Amortized Cost \t|\t\t\t\t"+t.sumAgg/(t.top)+"\t\t\t\t|\t\t\t\t "+t.sumAcc/(t.top)+" \t\t\t\t|\t\t\t\t "+t.sumPot/(t.top)+" \t\t\t\t|\t\t"+Arrays.toString(t.table)+"\t\t\n");

    }

}

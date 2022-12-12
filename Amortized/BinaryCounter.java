package ADS.Amortized;

import java.util.Arrays;

public class BinaryCounter {
    static BinaryCounter c;
    int[] table;
    int balance, potential;
    int sumAgg,sumAcc, sumPot;
    BinaryCounter(){
        table = new int[4];
    }

    void add(){
        int index = table.length-1;
        int flip = 0;
        while(table[index]!=0){
            flip++;
            balance--;
            table[index]=0;
            index--;
        }
        table[index]=1;
        int tempPot=0;
        for(int i:table){
            if(i==1){
                tempPot++;
            }
        }
        flip++;
        balance++;
        sumAgg += flip;
        sumAcc += balance;
        System.out.print("|\t\t  Add 1  \t\t|\t\t\t   "+flip+"    \t\t\t|\t\t\t    "+balance+"    \t\t\t|\t\t\t\t"+flip+"+"+tempPot+"-"+potential+"="+(flip+tempPot-potential)+"\t\t\t|\t\t"+Arrays.toString(c.table)+"\t\t|\n");
        sumPot += flip+tempPot-potential;
        potential = tempPot;
    }

    static void printTable(){
        System.out.print("|\t\tOperation\t\t|\t\t\tAggregate\t\t\t|\t\t\tAccounting\t\t\t|\t\t\tPotential\t\t\t|\t\t\tStack\t\t\t|\n");
    }

    public static void main(String[] args){
        c = new BinaryCounter();
        printTable();
        int n=7;
        for(int i=0;i<n;i++){
            c.add();
        }
        System.out.print("|\t\t  SUM\t\t\t|\t\t\t\t"+ c.sumAgg+" \t\t\t\t|\t\t\t    "+c.sumAcc+" \t\t\t\t|\t\t\t   \t  "+c.sumPot+"\t\t\t|\t\t\t\t\t\t\t|\n");
        System.out.print("|\t Amortized Cost\t\t|\t\t\t\t"+ c.sumAgg/n+" \t\t\t\t|\t\t\t    "+ c.sumAcc/7+" \t\t\t\t|\t\t\t  \t  "+c.sumPot/7+"\t\t\t\t|\t\t\t\t\t\t\t|\n");

    }
}

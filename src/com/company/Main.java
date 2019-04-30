package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner m=new Scanner(System.in);
        System.out.println("Enter number of process");
        int i=m.nextInt();
        System.out.println("Enter Quantum ");
        int q=m.nextInt();
        int [][]p1=new int[i][4];
        int [][]p2=new int[i][4];
        int [][]p3=new int[i][4];
        int [][]p4=new int[i][4];
        int [][]p5=new int[i][4];
        int [][]p6=new int[i][4];
        for(int j=0;j<i;j++){
            for(int k=0;k<4;k++) {
                p1[j][k] = m.nextInt();
                p2[j][k] = p1[j][k];
                p3[j][k] = p1[j][k];
                p4[j][k] = p1[j][k];
                p5[j][k] = p1[j][k];
                p6[j][k] = p1[j][k];
            }
        }

        FirstComeFirstServed x1=new FirstComeFirstServed();
        ShortestJobFirst x2=new ShortestJobFirst();
        ShortestJobRemaining x3 =new ShortestJobRemaining();
        Priority x4=new Priority();
        PriorityPrimitive x5=new PriorityPrimitive();
        RoundRobin x6 =new RoundRobin();
        x1.FirstComeFirstServed(p1,i);
        x2.ShortestJobFirst(p2,i);
        x3.ShortestJobRemainingFirst(p3,i);
        x4.Priority(p4,i);
        x5.PriorityPrimitive(p5,i);
        x6.RoundRobin(p6,i,q);

}}

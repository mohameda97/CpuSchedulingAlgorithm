package com.company;

import java.util.Scanner;
public class Main {
    public static float []avgwait=new float[6];
    public static float []avgtOn=new float[6];

    public static void main(String[] args) {
        // write your code here
        Scanner m=new Scanner(System.in);
        System.out.println("Enter number of process");
        int i=m.nextInt();
        System.out.println("Enter Quantum ");
        int q=m.nextInt();
        System.out.println("Enter in row number of process , arrival time ,burst time , priority ");

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
      float   min=Integer.MAX_VALUE;
      int s=0;
      float  min1=Integer.MAX_VALUE;
      int s1=0;
        for (int k=0;k<6;k++){
            if(avgwait[k]<min){
                min=avgwait[k];
                s=k;

            }
        }
        for (int k=0;k<6;k++){
            if(avgtOn[k]<min1){
                min1=avgtOn[k];
                s1=k;

            }
        }
        System.out.print("min avg wating time is ");
        if (s==0){
            System.out.println("First Come First Served");
        }else if (s==1){
            System.out.println("Shortest Job First");
        }
        else if (s==2){
            System.out.println("Shortest Job Remaining");
        }else if (s==3){
            System.out.println("Priority");
        }else if (s==4){
            System.out.println("Priority Remaining");
        }else if (s==5){
            System.out.println("Round Robin");
        }
        System.out.print("min avg Ton is ");
        if (s1==0){
            System.out.println("First Come First Served");
        }else if (s1==1){
            System.out.println("Shortest Job First");
        }
        else if (s1==2){
            System.out.println("Shortest Job Remaining");
        }else if (s1==3){
            System.out.println("Priority");
        }else if (s1==4){
            System.out.println("Priority Remaining");
        }else if (s1==5){
            System.out.println("Round Robin");
        }

}}

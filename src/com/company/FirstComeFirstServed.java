package com.company;

public class FirstComeFirstServed {
    public static void FirstComeFirstServed(int p[][],int i){

        int []w=new int[i];
        int []tOn=new int[i];
        int watingTime=0;
        int turnOnTime=0;
        float averageWatingTime;
        float averageTurnOnTime;
        p=AscendingOrderArrivalTime(p,i);
        int m=0;

        for(int j =0;j<i;j++){
            
            w[p[j][0]-1]=m-p[j][1];
            m=m+p[j][2];
            tOn[p[j][0]-1]=m-p[j][1];
            if (j<i-1){
                if (m<p[j+1][1]){
                    m=p[j+1][1];
                }
            }

        }
        for (int j=0;j<i;j++) {

            watingTime = watingTime + w[j];
            turnOnTime=turnOnTime+tOn[j];
        }
        averageWatingTime=(float)watingTime/i;
        averageTurnOnTime=(float)turnOnTime/i;
        System.out.println("Waiting Time for each process FCFS");
        for ( int j=0;j<i;j++){
            System.out.print("p"+(j+1)+"="+w[j]+"  ");
        }
        System.out.println();
        System.out.println("average waiting time First Come First Served   = " +averageWatingTime);
        System.out.println();
        System.out.println("Turn On Time for each process  FCFS");
        for ( int j=0;j<i;j++){
            System.out.print("p"+(j+1)+"="+tOn[j]+"  ");
        }
        System.out.println();
        System.out.println("average Turn On Time FCFS  = " +averageTurnOnTime);
    }

    public static int [][]AscendingOrderArrivalTime(int p[][], int i){
        int []temp=new int[4];

        for(int j=0;j<i;j++){
            for(int k=j+1;k<i;k++){
                if (p[j][1]>p[k][1]){
                    for (int x=0;x<4;x++) {
                        temp[x] = p[j][x];
                        p[j][x]=p[k][x];
                        p[k][x]=temp[x];
                    }

                }
            }
        }
        return p;
    }
}

package com.company;

public class ShortestJobFirst {
    public static void ShortestJobFirst(int p[][],int i){

        int []w=new int[i];
        int []tOn=new int[i];

        p=AscendingOrderBurstTime(p,i);
        int watingTime=0;
        int turnOnTime=0;
        float averageWatingTime;
        float averageTurnOnTime;
        int m=0; //current time
        for(int j =0;j<i;j++){
            w[p[j][0]-1]=m;
            m=m+p[j][2];
            tOn[p[j][0]-1]=m;
        }
        for (int j=0;j<i;j++) {

            watingTime = watingTime + w[j];
            turnOnTime=turnOnTime+tOn[j];
        }
        averageWatingTime=(float)watingTime/i;
        averageTurnOnTime=(float)turnOnTime/i;
        System.out.println("Waiting Time for each process Shortest Job First");
        for ( int j=0;j<i;j++){
            System.out.print("p"+(j+1)+"="+w[j]+"  ");
        }
        System.out.println();
        System.out.println("average waiting Shortest Job First    = " +averageWatingTime);
        System.out.println();
        System.out.println("Turn On Time for each process Shortest Job First");
        for ( int j=0;j<i;j++){
            System.out.print("p"+(j+1)+"="+tOn[j]+"  ");
        }
        System.out.println();
        System.out.println("average Turn On Time Shortest Job First  = " +averageTurnOnTime);
        System.out.println();
        Main.avgwait[1]=averageWatingTime;
        Main.avgtOn[1]=averageTurnOnTime;


    }



    public static int [][]AscendingOrderBurstTime(int p[][], int i){
        int temp=0;

        for(int j=0;j<i;j++){
            for(int k=j+1;k<i;k++){
                if (p[j][2]>p[k][2]||(p[j][2]==p[k][2]&&p[j][1]>p[k][1])){
                    for (int x=0;x<4;x++) {
                        temp = p[j][x];
                        p[j][x]=p[k][x];
                        p[k][x]=temp;
                    }

                }
            }
        }
        return p;
    }

}

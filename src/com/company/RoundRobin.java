package com.company;

public class RoundRobin {
    public static void RoundRobin(int p[][],int i,int q){
        int c=0;
        int c1=0;
        int j =0;
        int z=0;
        int []w=new int[i];
        int []x=new int[i];
        int []tOn=new int[i];
        int watingTime=0;
        int turnOnTime=0;
        float averageWatingTime;
        float averageTurnOnTime;
        p=AscendingOrderArrivalTime(p,i);
        z=p[0][1];
        for ( j=0;j<i;j++){
            x[p[j][0]-1]=p[j][1];
        }
        while (c<i){
            j=0;
            c1=0;
            for (j=0;j<i;j++){
                if (z>=p[j][1]&&p[j][2]>0){
                    if (p[j][2]>q){
                        p[j][2]=p[j][2]-q;
                        w[p[j][0]-1]=w[p[j][0]-1]+z-x[p[j][0]-1];
                        z=z+q;
                        x[p[j][0]-1]=z;
                    }
                    else if (p[j][2]<=q){
                        w[p[j][0]-1]=w[p[j][0]-1]+z-x[p[j][0]-1];
                        z=z+p[j][2];
                        x[p[j][0]-1]=z;
                        tOn[p[j][0]-1]=z-p[j][1];
                        p[j][2]=0;
                        c=c+1;


                    }

                }
               else if (j<i-1&&z>=p[j][1]){
                    for (int k=0;k<j+1;k++){
                        if (p[k][2]==0){
                            c1=c1+1;
                        }
                    }
                    if (c1==j+1&&z<p[j+1][1]){
                        z=p[j+1][1];
                    }
                }
            }

        }

        for ( j=0;j<i;j++) {

            watingTime = watingTime + w[j];
            turnOnTime=turnOnTime+tOn[j];
        }
        averageWatingTime=(float)watingTime/i;
        averageTurnOnTime=(float)turnOnTime/i;
        System.out.println("Waiting Time for each process Round Robin");
        for (  j=0;j<i;j++){
            System.out.print("p"+(j+1)+"="+w[j]+"  ");
        }
        System.out.println();
        System.out.println("average waiting Round Robin    = " +averageWatingTime);
        System.out.println();
        System.out.println("Turn On Time for each process Round Robin");
        for (  j=0;j<i;j++){
            System.out.print("p"+(j+1)+"="+tOn[j]+"  ");
        }
        System.out.println();
        System.out.println("average Turn On Time Round Robin  = " +averageTurnOnTime);
        System.out.println();
        Main.avgwait[5]=averageWatingTime;
        Main.avgtOn[5]=averageTurnOnTime;

    }
    public static int [][]AscendingOrderArrivalTime(int p[][], int i){
        int temp=0;

        for(int j=0;j<i;j++){
            for(int k=j+1;k<i;k++){
                if (p[j][1]>p[k][1]||(p[j][1]==p[k][1]&&p[j][0]>p[k][0])){
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

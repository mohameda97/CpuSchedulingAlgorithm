package com.company;

public class ShortestJobRemaining {
    public static void ShortestJobRemainingFirst(int e[][],int i){
        int []x=new int[i];
        int []w=new int[i];
        int []tOn=new int[i];
        int z=0;
        int c=0;
        int c2=0;
        boolean c1=true;
        int x1=0;
        int j=0;
        int s=0;
        int x2=0;
        int c3=0;
        int min;
        int watingTimeShortestRemainingTime=0;
        int turnOnTime=0;
        float averageWatingTimeShortestRemainingTime;
        float averageTurnOnTime;
        for ( j=0;j<i;j++){
            x[e[j][0]-1]=e[j][1];
        }
        e=AscendingOrderArrivalTime(e,i);
        for( j=0;j<i-1;j++) {
            s=0;
            c1=true;
            while(c1){
                min=Integer.MAX_VALUE;
                c3=0;
                for (int q=0;q<j+1;q++){
                    if(e[q][2]<min&&e[q][2]!=0){
                        min=e[q][2];
                        s=q;

                    }
                }
                c2=e[j+1][1]-z;
                x1=e[s][2]+z;

                if (x1<=e[j+1][1]&&e[s][2]!=0){
                    x2=e[s][2];
                    e[s][2]=0;
                    w[(e[s][0]-1)]=z-x[(e[s][0]-1)]+w[(e[s][0]-1)];
                    z=x2+z;
                    x[(e[s][0]-1)]=z;
                    tOn[e[s][0]-1]=z-e[s][1];


                }
                else if (x1>e[j+1][1]&&e[s][2]!=0){

                    e[s][2]=e[s][2]-c2;
                    w[(e[s][0]-1)]=z-x[(e[s][0]-1)]+w[(e[s][0]-1)];
                    z=z+c2;
                    x[(e[s][0]-1)]=z;

                }


                for (int q=0;q<j+1;q++){

                    if (e[q][2]==0){
                        c3++;
                    }
                }
                if (c3==j+1||z==e[j+1][1]){
                    z=e[j+1][1];
                    c1=false;
                }

            }
        }

        e=AscendingOrderBurstTime(e,i);


        for ( j=0;j<i;j++){
            if (e[j][2]!=0){
                c=(e[j][0]-1);
                w[c]=z-x[c]+w[c];
                z=e[j][2]+z;
                tOn[c]=z-e[j][1];

            }
        }
        for ( j=0;j<i;j++) {

            watingTimeShortestRemainingTime = watingTimeShortestRemainingTime + w[j];
            turnOnTime=turnOnTime+tOn[j];
        }
        averageWatingTimeShortestRemainingTime=(float)watingTimeShortestRemainingTime/i;
        averageTurnOnTime=(float)turnOnTime/i;
  System.out.println("Waiting Time for each process");
        for ( j=0;j<i;j++){
            System.out.print("p"+(j+1)+"="+w[j]+"  ");
        }
        System.out.println();
        System.out.println("average waiting time Shortest Job Remaining First   = " +averageWatingTimeShortestRemainingTime);
        System.out.println();
        System.out.println("Turn On Time for each process ");
        for ( j=0;j<i;j++){
            System.out.print("p"+(j+1)+"="+tOn[j]+"  ");
        }
        System.out.println();
        System.out.println("average Turn On Time   = " +averageTurnOnTime);
    }
    public static int [][]AscendingOrderArrivalTime(int p[][], int i){
        int []temp=new int[4];
        for(int j=0;j<i;j++){
            for(int k=j+1;k<i;k++){
                if (p[j][1]>p[k][1]||(p[j][1]==p[k][1]&&p[j][1]>p[k][1])){
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
    public static int [][]AscendingOrderBurstTime(int p[][], int i){
        int []temp=new int[4];

        for(int j=0;j<i;j++){
            for(int k=j+1;k<i;k++){
                if (p[j][2]>p[k][2]||(p[j][2]==p[k][2]&&p[j][1]>p[k][1])){
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

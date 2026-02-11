import java.util.Random;
import java.util.HashMap;
import java.util.Map;




public class Shuffle {

    static Random rand = new Random();

    // 1. slowshuffle (improved bad method)

    public static int [] slowshuffle(int N){

        int[] shuffled =new int[N];
        boolean[] isNotPresent =new boolean[N +1];


        // initially all values are not present
        for(int i=1;i<=N;i++){
            isNotPresent[i]=true;
        }

        int i=0;
        while(i<N-1){
            int r= rand.nextInt(N)+1; //[1...N]

            if (isNotPresent[r]){
                shuffled[i] =r;
                isNotPresent[r]=false;
                i++;

            }

        }

        //find the last remaining number

        for (int r=1;r<= N;r++){
            if(isNotPresent[r]){
                shuffled[N-1]=r;
                break;

            }
        } return shuffled;

    }// 2. unbiased shuffle(correct method

    public static int[]unbiasedshuffle(int N ){
        int[] shuffled =new int[N];

        for (int i=0;i<N;i++){
            shuffled[i]= i+1;

        }

        for(int i =0;i<N;i++){
            int r =i + rand.nextInt(N -i);
            int temp= shuffled[i];
            shuffled[i]=shuffled[r];
            shuffled[r]=temp;

        }
        return shuffled;
    }  // (simple test)

    public static void main(String[] args){

        int[] a= slowshuffle(10);
        int[] b =unbiasedshuffle(10);

        System.out.println("Slow shuffle: ");
        for(int x: a)System.out.print(x +" ");

        System.out.println("\n\nUnbiased shuffle: ");
        for(int x: b)System.out.print(x+ " ");
    }


}

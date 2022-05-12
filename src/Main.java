import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.SplittableRandom;

public class Main {


    public static void main(String[] Args){
        String psw="Deep Learning 2022";
        PswCracker cracker = new PswCracker(64, psw, 5);
        ArrayList<String[]> popsData;
        NumberFormat formatter = new DecimalFormat("#0.0000");

        long timeTakes=0;
        for(int i =0;i<3;i++) {
            long startTime = System.nanoTime();
            popsData= cracker.crackThePSW();
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            timeTakes+=((totalTime) / 1000000d);
            //System.out.println("Generation    "+"Best Chromosome    "+"Generation's Fitness Mean");
            for(int j =0;j<popsData.size();j++){
                System.out.println("Generation: "+j+"  Fitness Mean: "+popsData.get(j)[0]+"  Best Chromosome: "+popsData.get(j)[1]);
            }
            System.out.println("Execution time is " + formatter.format((totalTime)/1000000d) + " mili seconds");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
        }
        System.out.println("Execution time is " + formatter.format((timeTakes) / 3) + " micro seconds");
        /*
        SplittableRandom rnd= new SplittableRandom();

         int genePoolStart=32;
         int genePollEnd=127;
        //these 2 used for ascii table

        char[] turkishLetters={'Ç','ç','Ö','ö','Ü','ü','İ','ı','Ğ','ğ','Ş','ş'};
        int upperbound=genePollEnd+turkishLetters.length;
        for (int i =0;i<10000;i++){
            int rndChar=rnd.nextInt(genePoolStart,genePollEnd+turkishLetters.length);
            if(rndChar>=genePollEnd)
                System.out.println(rndChar-genePollEnd);
        }
        */



    }
}

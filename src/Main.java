import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.SplittableRandom;

public class Main {


    public static void main(String[] Args){
        String psw="Deep Learning 2022";
        ArrayList<String[]> popsData;
        NumberFormat formatter = new DecimalFormat("#0.0000");

        long timeTakes=0;
        for(int i =0;i<4;i++) {
            PswCracker cracker = new PswCracker(128, psw, 10);

            long startTime = System.nanoTime();
            popsData= cracker.crackThePSW();
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            //System.out.println("Generation    "+"Best Chromosome    "+"Generation's Fitness Mean");
            if(i>0) {
                timeTakes+=((totalTime) / 1000000d);
                for (int j = 0; j < popsData.size(); j++) {
                    System.out.println("Generation: " + j + "  Fitness Mean: " + popsData.get(j)[0] + "  Best Chromosome: " + popsData.get(j)[1]);
                }

                System.out.println("Execution time is " + formatter.format((totalTime) / 1000000d) + " mili seconds");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
            }
        }
        System.out.println("Mean execution time is " + formatter.format((timeTakes) / 3) + " micro seconds");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        psw="DeepLearning";
        timeTakes=0;
        for(int i =0;i<4;i++) {
            PswCracker cracker = new PswCracker(128, psw, 10);

            long startTime = System.nanoTime();
            popsData= cracker.crackThePSW();
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            
            if(i>0) {
                timeTakes+=((totalTime) / 1000000d);
                for (int j = 0; j < popsData.size(); j++) {
                    System.out.println("Generation: " + j + "  Fitness Mean: " + popsData.get(j)[0] + "  Best Chromosome: " + popsData.get(j)[1]);
                }

                System.out.println("Execution time is " + formatter.format((totalTime) / 1000000d) + " mili seconds");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
            }        }
        System.out.println("Mean execution time is " + formatter.format((timeTakes) / 3) + " micro seconds");


    }
}

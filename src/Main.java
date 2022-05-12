import java.util.SplittableRandom;

public class Main {


    public static void main(String[] Args){
        String psw="Deep Learning 20222";
        //PswCracker cracker=new PswCracker();
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
    }
}

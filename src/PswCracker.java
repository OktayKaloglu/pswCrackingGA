import java.util.List;
import java.util.SplittableRandom;

public class PswCracker {
    private SplittableRandom rnd;
    private int genePoolStart=32;
    private int genePollEnd=127;
    //these 2 used for ascii table
    private char[] turkishLetters={'Ç','ç','Ö','ö','Ü','ü','İ','ı','Ğ','ğ','Ş','ş'};

    private int mutationChance;
    private int mutationUpperBound;

    private int popSize;
    private String psw;
    private int pswLen;
    public PswCracker(int popSize, String psw,int chance) {
        this.popSize = popSize;
        this.psw = psw;
        this.mutationChance =chance;
        this.rnd=new SplittableRandom();
        this.mutationUpperBound=(100-chance)/2+chance;
        this.pswLen=psw.length();
    }
    // fill the pop with 2 parent
    public void fillPop(String parent1,String paren2){
        LinkedList population=new LinkedList();
        for(int i =0;i<popSize;i++){

        }
    }
    private String[] makeChild(String parent1,String parent2){
        char gene;
        String chromosome="";
        int fitness=0;
        for(int i = 0 ;i<pswLen;i++) {

            int chance = rnd.nextInt(0, 100);

            if (chance < mutationChance) {
                //mutation happens
                int upperbound=genePollEnd+turkishLetters.length;
                int rndChar=rnd.nextInt(genePoolStart,upperbound);
                if (rndChar<genePollEnd){
                    gene= (char)rndChar;//get directly from the ascii table
                }else{
                    gene= turkishLetters[rndChar-genePollEnd];//get turkish letters
                }
            } else if (mutationChance <= chance && chance < mutationUpperBound) {
                //take genes from the first parent
                gene= parent1.charAt(i);
            } else {
                //take genes from the second parent
                gene= parent2.charAt(i);
            }
            chromosome+=gene;
            if (psw.contains(Character.toString(gene))){
                fitness++;
            }
        }
        return new String[]{chromosome, Integer.toString(fitness)};
    }

}

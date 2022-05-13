import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class PswCracker {
    private SplittableRandom rnd;
    private int genePoolStart=32;
    private int genePollEnd=127;
    //these indexes used for ascii table chars
    private char[] turkishLetters={'Ç','ç','Ö','ö','Ü','ü','İ','ı','Ğ','ğ','Ş','ş'};

    private int mutationChance;
    private int mutationUpperBound;

    private int popSize;
    private String psw;
    private int pswLen;
    ArrayList<String[]> popsData ;

    public PswCracker(int popSize, String psw,int chance) {
        this.popSize = popSize;
        this.psw = psw;
        this.mutationChance =chance;
        this.rnd=new SplittableRandom();
        this.mutationUpperBound=(100-chance)/2+chance;
        this.pswLen=psw.length();
        //arr[0] population's fitness mean
        //arr[1] population's fines chromosome
        this.popsData=new ArrayList<String[]>();

    }
    public ArrayList<String[]> crackThePSW(){
        LinkedList population=new LinkedList();
        int popsFitnessMean=0;
        for(int i =0;i<popSize;i++){
            int fitness=0;
            char gene;
            String chromosome="";
            for(int j =0;j<pswLen;j++){
                int upperbound=genePollEnd+turkishLetters.length;
                int rndChar=rnd.nextInt(genePoolStart,upperbound);
                if (rndChar<genePollEnd){
                    gene= (char)rndChar;//get directly from the ascii table
                }else{
                    gene= turkishLetters[rndChar-genePollEnd];//get turkish letters
                }
                chromosome+=gene;
                if (psw.charAt(j)==gene){
                    fitness++;
                }
            }

            population.add (chromosome,fitness);
            popsFitnessMean+=fitness;
        }
        String[] elits=population.popElits();
        popsFitnessMean=popsFitnessMean/popSize;
        popsData.add(new String[]{Integer.toString(popsFitnessMean),elits[0]});
        fillPop(elits[0],elits[1],popsFitnessMean);
        return popsData;
    }
    // fill the pop with 2 parent
    public void fillPop(String parent1,String parent2,int fitness){

        while (fitness!=pswLen) {
            LinkedList population = new LinkedList();
            fitness = 0;
            int popsFitnessMean = 0;
            for (int i = 0; i < popSize; i++) {
                String[] data = makeChild(parent1, parent2);
                fitness = Integer.parseInt(data[1]);
                population.add(data[0], fitness);
                popsFitnessMean += fitness;

            }
            String[] elits = population.popElits();
            popsData.add(new String[]{Integer.toString(popsFitnessMean/popSize), elits[0]});
            parent1 = elits[0];
            parent2 = elits[1];
            fitness=population.getFitness();
        }
    }
    private String[] makeChild(String parent1,String parent2){
        char gene;
        String chromosome="";
        int fitness=0;
        for(int i = 0 ;i<pswLen;i++) {

            int chance = rnd.nextInt(0, 100);

            if (chance < mutationChance) {
                //mutation happens and randomly creates an char from ascii or turkish letters
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
            if (psw.charAt(i)==gene){
                fitness++;
            }
        }

        return new String[]{chromosome, Integer.toString(fitness)};
    }


}

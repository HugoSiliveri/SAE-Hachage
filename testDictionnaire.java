import java.util.Random;

public class testDictionnaire {

    public static void main(String[] args) {
        Dictionnaire d, d1, d2, d3, d4;
        String p1, p2;
        String livre = "LeRougeEtLeNoir.txt";

        System.out.println("Livre = "+livre);
        System.out.println("m = 10");
        d = new Dictionnaire(livre, 10);
        

        /*final long startTime = System.currentTimeMillis();
        d = new Dictionnaire("randomWords", (double)0.01);
        System.out.println(d.getCardinal());
        final long endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime));*/
        d1 = new Dictionnaire("randomWordsPetit", 1);
        d2 = new Dictionnaire("randomWordsPetit", 2);
        d3 = new Dictionnaire("randomWordsPetit", 4);
        d4 = new Dictionnaire("randomWordsPetit", 8);
        Dictionnaire[] dictionnaires = {d1, d2, d3, d4};
        int nbRecherches =10000;
        for(int k=0;k<dictionnaires.length;k++){
            final long startTime = System.currentTimeMillis();
            for(int i=0;i<nbRecherches;i++) {
                Random random = new Random();
                int tailleMot = random.nextInt(15) + 2; //2 <= tailleMot <= 16
                char[] mot = new char[tailleMot];
                for (int j = 0; j < mot.length; j++) {
                mot[j] = (char) ('a' + random.nextInt(26));
                }
                String motS = new String(mot);
                
                dictionnaires[k].contient(motS);//on ne récupère même pas le résultat de la recherche!
                }
                System.out.println("maxSize : " + dictionnaires[k].getMaxSize());
                System.out.println("card/nblistes : " + (dictionnaires[k].getCardinal())/(dictionnaires[k].getNbListes()));
                
            final long endTime = System.currentTimeMillis();

            System.out.println("Total execution time: " + (endTime - startTime));
        }
    }
}

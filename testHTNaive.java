import java.math.BigInteger;

public class testHTNaive {

    public static BigInteger[] intToBigInteger(int[] t){
        int longueur_t = t.length;
        BigInteger[] tBigInt = new BigInteger[longueur_t];
        for(int i=0; i<longueur_t; i++){
            tBigInt[i] = BigInteger.valueOf(t[i]);
        }
        return tBigInt;
    }
    
    public static void main(String[] args){
        HTNaive t1, t2, t3;
        ListeBigI l1;

        int[] tabInt = {2010,473,4932,9219,2301,39201,21,84,382,4932};
        l1 = new ListeBigI(intToBigInteger(tabInt));
        t1 = new HTNaive(6);
        t2 = new HTNaive(l1,6);
        t3 = new HTNaive(l1,6);
        
        
        System.out.println(t1.toString());
        
        t1.ajoutListe(l1);
        System.out.println("t1"+t1.toString());
        System.out.println("t2"+t2.toString());
        System.out.println("t3"+t3.toString());

        System.out.print(t1.getTimeH()+" "); System.out.println(t1.getTimeContient());
        System.out.print(t2.getTimeH()+" "); System.out.println(t2.getTimeContient());
        System.out.print(t3.getTimeH()+" "); System.out.println(t3.getTimeContient());
        //System.out.println("Liste de tous les elements : "+(t1.getElements()).toString());
        //System.out.println("Nombre de Liste du tableau : "+t1.getNbListes());
        //System.err.println("Cardinal du tableau : "+t1.getCardinal());
        //System.out.println("Taille de la chaine la plus grande du tableau : "+t1.getMaxSize());
        //float ratio = (float)(t1.getCardinal()) / (t1.getNbListes());
        //System.err.println("Ration : "+ratio);
        //System.out.println(t1.toStringV2());
    }
}

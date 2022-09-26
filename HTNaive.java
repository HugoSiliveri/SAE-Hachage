
import java.math.BigInteger;
import java.util.List;

public class HTNaive {

    private ListeBigI[] t;
    private long totalTimeh;
    private long totalTimeContient;

    public HTNaive(int m){
        this.t = new ListeBigI[m];
        this.totalTimeh = 0;
        this.totalTimeContient=0;
        for (int i=0; i<m;i++){
            this.t[i] = new ListeBigI(); 
        } 
    }

    public HTNaive(ListeBigI l, int m){
        HTNaive HT_naive1 = new HTNaive(m);
        this.t = HT_naive1.t;
        this.ajoutListe(l);
    }

    public HTNaive(ListeBigI l, double f){
        HTNaive temp = new HTNaive(l, 1000);
        Double fD = Double.valueOf(f);
        int cardinal = temp.getCardinal();
        HTNaive HT_naive1 = new HTNaive(l,(int)(cardinal*fD.floatValue()));
        this.t = HT_naive1.t;
        
    }


    public ListeBigI getListe(int i){
        return this.t[i];
    }

    public int h(BigInteger u){
        return (u.remainder(BigInteger.valueOf(this.t.length))).intValue();
    }

    public boolean contient(BigInteger u){
        long tempDebut = System.currentTimeMillis();
        int emplacement = h(u);
        long tempFin = System.currentTimeMillis();
        this.totalTimeh += (tempFin - tempDebut);
        return this.t[emplacement].contient(u);
    }

    public boolean ajout(BigInteger u){
        long tempDebut = System.currentTimeMillis();
        boolean ajoute = this.contient(u);
        long tempFin = System.currentTimeMillis();
        this.totalTimeContient += (tempFin - tempDebut);
        if(ajoute){
            return false;
        } else{
            this.t[this.h(u)].ajoutTete(u);
            return true;
        }
    }

    public void ajoutListe(ListeBigI L){
        int l_longueur = L.longueur();
        int i=0;
        ListeBigI L_copy = new ListeBigI(L);
        while(i<l_longueur){
            BigInteger nbr = L_copy.supprTete();
            this.ajout(nbr);
            i++;
        }
    }

    public ListeBigI getElements(){
        ListeBigI new_liste = new ListeBigI();
        int longueur_t = this.t.length;
        for(int i=0;i<longueur_t;i++){
            ListeBigI l_copy = new ListeBigI(this.t[i]);
            int longueur_l = l_copy.longueur();
            for(int j=0;j<longueur_l;j++){
                BigInteger nbr = l_copy.supprTete();
                new_liste.ajoutTete(nbr);
            }
        }
        return new_liste;
    }

    public String toString(){
        String tableau =  "";
        int longueur_t = this.t.length;
        for(int i=0;i<longueur_t;i++){
            ListeBigI l_copy = new ListeBigI(this.t[i]);
            int longueur_l = l_copy.longueur();
            tableau += "tab["+i+"] : (";
            for(int j=0;j<longueur_l;j++){
                tableau += (l_copy.supprTete())+"";
                if(j!=longueur_l-1){
                    tableau+=", ";
                }
            }
            tableau += ")\n";
        }
        return tableau;
    }

    public int getNbListes(){
        return this.t.length;
    }

    public int getCardinal(){
        int cardinal = 0;
        int longueur_t = this.t.length;
        for(int i=0;i<longueur_t;i++){
            ListeBigI l_copy = new ListeBigI(this.t[i]);
            int longueur_l = l_copy.longueur();
            for(int j=0;j<longueur_l;j++){
                l_copy.supprTete();
                cardinal++;
            }
        }
        return cardinal;
    }

    public int getMaxSize(){
        int max = 0;
        int compteur = 0;
        int longueur_t = this.t.length;
        for(int i=0;i<longueur_t;i++){
            ListeBigI l_copy = new ListeBigI(this.t[i]);
            int longueur_l = l_copy.longueur();
            for(int j=0;j<longueur_l;j++){
                l_copy.supprTete();
                compteur++;
            }
            if (max<compteur) max=compteur;
            compteur=0;
        }
        return max;
    }

    public String toStringV2(){
        String tableau =  "";
        int longueur_t = this.t.length;
        for(int i=0;i<longueur_t;i++){
            
            ListeBigI l_copy = new ListeBigI(this.t[i]);
            int longueur_l = l_copy.longueur();
            if(longueur_l!=0){
                tableau += "tab["+i+"] : (";
                for(int j=0;j<longueur_l;j++){
                    tableau += (l_copy.supprTete())+"";
                    if(j!=longueur_l-1){
                        tableau+=", ";
                    }
                }
                tableau += ")\n";
            }
        }
        return tableau;
    }

    public long getTimeH(){
        return this.totalTimeh;
    }

    public long getTimeContient(){
        return this.totalTimeContient;
    } 
}
        

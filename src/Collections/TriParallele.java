package Collections;

import java.util.Arrays;

/**
 * classe java.util.Arrays (tableaux)
 * diff entres sort() et parallelSort()
 * sort() s'applique sur toutes sortes d'element
 * tri parallele divise le tableau et alloue chaque morceau a trier a un Thread
 *
 */

public class TriParallele {

    public static int MAX_SEQUENTIEL = 100000000;

    public static void main(String[] args){
        //on remplit un tableau
        int[] tableauSequentiel =  new int[MAX_SEQUENTIEL];
        for(int i=0;i<MAX_SEQUENTIEL;i++){
            tableauSequentiel[i] = (int) (Math.random()*100);
        }

        int[] tableauParallele =  new int[MAX_SEQUENTIEL];
        for(int i=0;i<MAX_SEQUENTIEL;i++){
            tableauParallele[i] = (int) (Math.random()*100);
        }
        System.out.print("avant tri : ");
        for(int i=0;i<100;i++){
            System.out.print(tableauSequentiel[i]+" ");
            System.out.println(" ");
            System.out.print(tableauParallele[i]+" ");
        }
        //on trie le tableau et on voit combien de temps ca a pris
        long t0 = System.currentTimeMillis();
        //interessant pour une petite taille de tableau seulement
        Arrays.sort(tableauSequentiel);
        long t1 = System.currentTimeMillis();
        long duréeTriSequentiel = t1 - t0;
        long t2 = System.currentTimeMillis();
        //le tri parallele ici est plus couteux pour une quantité de donnée
        //trop faible
        Arrays.parallelSort(tableauParallele);
        long t3 = System.currentTimeMillis();
        long duréeTriParallele = t3 - t2;

        System.out.println("apres tri : ");
        for(int i=0;i<100;i++){
            System.out.print(tableauSequentiel[i]+" ");
            System.out.println(" ");
            System.out.print(tableauParallele[i]+" ");
        }
        System.out.println(" ");
        System.out.println("Pour "+MAX_SEQUENTIEL+" valeurs, on a : ");
        System.out.println("durée du tri sequentiel : "+duréeTriSequentiel );
        System.out.println("durée du tri parallele : "+duréeTriParallele );
    }
}

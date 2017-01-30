/**
 * 
 */
package afficherdate;

import java.util.Scanner;

/**
 * @author samuel
 *
 */
public class AfficherDate {
	private static String nomJ ,nomM;
	private static int date,annee ,jour;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String nomJ = null,nomM = null;
		///int date = 0,annee = 0,jour = 0;
		Traitement traitement = new Traitement();

		nomJ = Traitement.saisirJourSemaine(nomJ);
		if(nomM != null || nomJ != null){
			date = Traitement.saisirDate(date);
			annee = Traitement.calculAnnee(date, annee);
			nomM = Traitement.calculMois(date, nomM);
			jour = Traitement.calculJour(date, jour);


			Traitement.afficheDate(nomJ, nomM, jour, annee);			
		}

	}

}

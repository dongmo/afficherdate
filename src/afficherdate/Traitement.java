package afficherdate;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Traitement {

	public static String nomJourSemaine(int numJ){
		String leJour = null;

		switch (numJ) {
		case 1: leJour = "Lundi"; break;
		case 2: leJour = "Mardi"; break;
		case 3: leJour = "Mercredi"; break;
		case 4: leJour = "Jeudi"; break;
		case 5: leJour = "Vendredi"; break;
		case 6: leJour = "Samedi"; break;
		case 7: leJour = "Dimance"; break;

		default:
			System.out.println("Le numéro que vous entrez n'est pas valid \n veillez réessayer. Merci.");
			break;
		}
		return leJour;
	}

	public static String nomMois(int numM){

		String leMois = null;

		switch (numM) {
		case 1: leMois = "Janvier"; break;
		case 2: leMois = "Fevrier"; break;
		case 3: leMois = "Mars"; break;
		case 4: leMois = "Avril"; break;
		case 5: leMois = "Mai"; break;
		case 6: leMois = "Juin"; break;
		case 7: leMois = "Juillet"; break;
		case 8: leMois = "Août"; break;
		case 9: leMois = "Septembre"; break;
		case 10: leMois = "Octobre"; break;
		case 11: leMois = "Novembre"; break;
		case 12: leMois = "Decembre"; break;
		default:
			System.out.println("Le numéro que vous entrez n'est pas valid \n veillez réessayer. Merci.");
			break;
		}
		return leMois;
	}

	public static String saisirJourSemaine(String nomJ) {
		String numJ = null;
		int jour = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		do{

			System.out.println("Donnez le numéro du jour dans la semaine (nombre compris entre 1 et 7) :");
			numJ = scanner.nextLine();
			if(StringUtils.isNumeric(numJ)){
				jour = Integer.parseInt(numJ);
			}
		}while((jour < 1 || jour > 7) || !StringUtils.isNumeric(numJ));
		nomJ = nomJourSemaine(jour);
		return nomJ;
	}


	public static int saisirDate(int laDate){
		String laDateStr;
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("Donnez une date valide (sous la forme AAAAMMJJ) :");
			laDateStr = scanner.nextLine();
		}while(!dateValid(laDateStr));
		laDate = convertirDate(laDateStr);
		return laDate;
	}

	public static int convertirDate(String laDate){
		return Integer.parseInt(laDate);
	}

	public static Boolean dateValid(String laDate){

		Boolean verif = Boolean.FALSE;
		List<String> date30 = new ArrayList<String>();
		date30.add("04"); date30.add("06");date30.add("09"); date30.add("11");
		List<String> date31 = new ArrayList<>();
		date31.add("01"); date31.add("03"); date31.add("05"); date31.add("07"); date31.add("08"); date31.add("10"); date31.add("12");

		if(laDate.length() == 8){
			String mois = laDate.substring(4, 6);
			String jour = laDate.substring(6, 8);
			String annee = laDate.substring(0,4);
			if(StringUtils.isNumeric(laDate)){
				if(convertirDate(mois)>=01 && convertirDate(mois)<=12){
					verif = Boolean.TRUE;
				}
				if(date30.contains(mois) && convertirDate(mois) >30 ){
						verif = Boolean.FALSE;
				}
				if(date31.contains(mois) && convertirDate(jour) >31){
						verif = Boolean.FALSE;
				}
				if(mois.equals("02") && isBissectile(annee) ){
					if(!jour.equals("29")){
						verif = Boolean.FALSE;
					}
				}else if(mois.equals("02") && !isBissectile(annee) ){
					if(!jour.equals("28")){
						verif = Boolean.FALSE;
					}
				}
			}
		}
		return verif;
	}
	public static Boolean isBissectile(String anneeStr){
		int annee;
		Boolean result = Boolean.FALSE;
		annee = Integer.parseInt(anneeStr);
		if(annee % 4 ==0 && annee % 100 != 0){
			result = Boolean.TRUE;
		}else if(annee % 400 == 0){
			result = Boolean.TRUE;
		}else {
			result = Boolean.FALSE;
		}

		return result;
	}

	public static int calculAnnee(int laDate,int annee){
		annee = laDate/10000;
		return annee;
	}

	public static String calculMois(int laDate,String nomM){
		String numM = null;
		int mois;
		mois = (laDate % 10000)/100;
		nomM = nomMois(mois);
		return nomM;
	}

	public static int calculJour(int laDate,int leJour){
		leJour = laDate % 100;
		return leJour;
	}

	public static void afficheDate(String nomJ,String nomM,int jour,int annee){
		System.out.printf("Nous sommes le %s %d %s %d ",nomJ,jour,nomM,annee);
	}
}

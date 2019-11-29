package utils;

public class UtilsDate {
	
	public static boolean estBissextile(int annee){
	      return (annee % 4 == 0 && annee % 100 != 0) || annee % 400 == 0;
	}
	
	public static boolean estValide(int jour, int mois, int annee) {
		switch (mois) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			if (jour > 31 || jour < 0) {
				return false;
			}
			else break;
		case 4: case 6: case 9: case 11:
			if (jour > 30 || jour < 0) {
				return false;
			}
			else break;
		case 2:
			if (jour > 29 || jour < 0) {
				return false;
			}
			else {
				if (jour == 29) {
					return estBissextile(annee);
				}
				else break;
			}
		default:
			return false;
		}
		return true;
	}
}

package net.virgapps.samples.arrays;

import java.util.Arrays;
import java.util.Random;

public class ArraysFactory {
	/**
	 * Créé un tableau d'entiers aléatoires
	 * @param size : taille du tableau
	 * @param max : valeur maximale des entiers
	 * @return un tableau d'entiers
	 */
    public static int[] creerTableauRandom(int size, int max) {
        int[] result = new int[size];
        
        Random random = new Random();
        for (int i = 0 ; i < size ; i++) {
            result[i] = random.nextInt(max - 1);
        }
        
        return result;
    }
    
    public static int maxLin(int[] tableau) {
        int maxCourant = Integer.MIN_VALUE;
        for (int i = 0 ; i < tableau.length ; i++) {
            if (tableau[i] > maxCourant) {
                maxCourant = tableau[i];
            }
        }
        return maxCourant;
    }
    
    public static int[] triSelection(int[] tableau) {
        int index = 0;
        while (index < tableau.length) {
            int indexMin = 0;
            int min = Integer.MAX_VALUE;
            for (int i = index ; i < tableau.length ; i++) {
                if (tableau[i] < min) {
                    min = tableau[i];
                    indexMin = i;
                }
            }
            tableau[indexMin] = tableau[index];
            tableau[index] = min;
            index++;
        }
        return tableau;
    }
    
    public static int[] triFusion(int[] tab) {
    	int[] result = {};
    	
    	// le tableau est scindée en deux parties jusqu'à qu'il ne soit constitué que d'un seul élément
    	if (tab.length > 1) {
    		int milieu = tab.length / 2;
    		// application récursive de la fonction chaque sous-tableau
    		int[] tab1 = triFusion(Arrays.copyOfRange(tab, 0, milieu));
    		int[] tab2 = triFusion(Arrays.copyOfRange(tab, milieu, tab.length));
    		result = fusionner(tab1, tab2);
    	}
    	else {
    		result = tab;
    	}
    	return result;
    }
    
    private static int[] fusionner(int[] tab1, int[] tab2) {
    	int[] result = new int[tab1.length + tab2.length];
    	int i = 0;
    	int j = 0;
    	int index = 0;
    	
    	while (i < tab1.length && j < tab2.length) {
    		if (tab1[i] < tab2[j]) {
    			result[index] = tab1[i];
    			i++;
    		}
    		else {
    			result[index] = tab2[j];
    			j++;
    		}
    		index++;
    	}
    	
    	for (; i < tab1.length; i++) {
    		result[index++] = tab1[i];
		}
		for (; j < tab2.length; j++) {
			result[index++] = tab2[j];
		}
    	
    	return result;
    }
    
    public static Integer majoritaire(int[] tab, int debut, int fin) {
    	if (debut == fin) {
    		return tab[debut];
    	}
		Integer x = majoritaire(tab, debut, (debut + fin - 1) / 2);
		Integer y = majoritaire(tab, (debut + fin + 1) / 2, fin);
		if (x == null && y == null) {
			return null;
		}
		else {
			if (x != null && y != null) {
				if (x == y) {
					return x;
				}
				else {
					int nbX = occurences(x, tab, debut, fin);
					int nbY = occurences(y, tab, debut, fin);
					if (nbX > nbY) {
						return x;
					}
					else {
						if (nbY > nbX) {
							return y;
						}
						else {
							return null;
						}
					}
				}
			}
			else {
				if (x != null) {
					if (occurences(x, tab, debut, fin) > (fin - debut + 1) / 2) {
						return x;
					}
					else {
						return null;
					}
				}
				else {
					if (occurences(y, tab, debut, fin) > (fin - debut + 1) / 2) {
						return y;
					}
					else {
						return null;
					}
				}
			}
		}
    }

    /**
     * Retourne le nombre d'occurences d'un entier dans un tableau
     * @param nb
     * @param tab
     * @return
     */
    public static int occurences(int nb, int[] tab, int debut, int fin) {
    	int occurence = 0;
    	if (tab != null && tab.length > 0) {
    		for (int i = debut; i < fin + 1; i++) {
    			if (tab[i] == nb) {
    				occurence++;
    			}
    		}
    	}
    	return occurence;
    }
}

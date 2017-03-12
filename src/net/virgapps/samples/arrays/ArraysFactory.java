package net.virgapps.samples.arrays;

import java.util.Arrays;
import java.util.Random;

public class ArraysFactory {
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
    	if (tab.length > 1) {
    		int milieu = tab.length / 2;
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
}

package net.virgapps.samples.arrays;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ArraysTest {
    private int[] tableau;
    
    @Before
    public void init() {
        tableau = ArraysFactory.creerTableauRandom(10, 100);
        System.out.println("Tableau aléatoire : " + Arrays.toString(tableau));
    }
    
    @Test
    public void testMaxLin() {
        int max = ArraysFactory.maxLin(tableau);
        Arrays.sort(tableau);
        assertTrue(max == tableau[tableau.length - 1]);
    }
    
    @Test
    public void testTriSelection() {
    	System.out.println("** Tri de type Selection **");
    	int[] tableauTrie = ArraysFactory.triSelection(tableau);
    	Arrays.sort(tableau);
    	System.out.println("Tableau trié      : " + Arrays.toString(tableauTrie));
    	assertTrue(Arrays.equals(tableauTrie, tableau));
    }
    
    @Test
    public void testTriFusion() {
    	System.out.println("** Tri de type Fusion **");
    	int[] tableauTrie = ArraysFactory.triFusion(tableau);
    	Arrays.sort(tableau);
    	System.out.println("Tableau trié      : " + Arrays.toString(tableauTrie));
    	assertTrue(Arrays.equals(tableauTrie, tableau));
    }
    
    @Test
    public void testMajoritaire() {
    	int[] tab = {1, 2, 2, 2, 2, 3, 4, 2};
    	assertTrue(2 == ArraysFactory.majoritaire(tab));
    }
}

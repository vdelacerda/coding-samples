import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class List2d {
    public static void main(String[] args) {
        Integer[][] tab2d = new Integer[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
        List<List<Integer>> list2d = new ArrayList<List<Integer>>();

        for (int i = 0; i < tab2d.length; i++) {
            List<Integer> list = Arrays.asList(tab2d[i]);
            list2d.add(list);
        }

        System.out.println("Affichage du tableau");
        for (int i = 0; i < tab2d.length; i++) {
            for (int j = 0; j < tab2d[i].length; j++) {
                System.out.print(" " + String.valueOf(tab2d[i][j]) + " |");
            }
            System.out.print("\n");
        }

        System.out.println("Affichage de la liste");
        list2d.forEach(sublist -> {
            sublist.forEach(item -> {
                System.out.print(" " + String.valueOf(item) + " |");
            });
            System.out.print("\n");
        });
    
    }
}
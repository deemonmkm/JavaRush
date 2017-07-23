import com.sun.javafx.binding.StringFormatter;

import java.util.*;

/**
 * Created by fr0ze on 11.07.2017.
 */
public class Test {

    public static int[] sortArray(int[] array) {
        ArrayList<Integer> odd = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0 && array[i]%2 != 0) odd.add(array[i]);
        }
        Collections.sort(odd);
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0 && array[i]%2 != 0) {
                array[i] = odd.get(0);
                odd.remove(0);
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Test test = new Test();

        System.out.println(sortArray(new int[]{ 5, 3, 2, 8, 1, 4 }));
        System.out.println(sortArray(new int[]{ 5, 3, 1, 8, 0 }));
        System.out.println(sortArray(new int[]{  }));
    }
}

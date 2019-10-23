package DZone;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorting {

    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Milan","london","San Francisco","Tokyo","New Delhi");
        System.out.println(cities); //[Milan, london, San Francisco, Tokyo, New Delhi]

        cities.sort(String::compareTo);
        System.out.println(cities); //[Milan, New Delhi, San Francisco, Tokyo, london]

        cities.sort(Comparator.naturalOrder());
        System.out.println(cities); //[Milan, New Delhi, San Francisco, Tokyo, london]

        List<Integer> numbers = Arrays.asList(6,2,1,4,9);
        System.out.println(numbers);

        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers); //[1, 2, 4, 6, 9]
    }
}

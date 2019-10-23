package DZone;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LambdaBasicExemple {

    public static void main(String[] args) {
        Map<String, List<String>> phoneNumbers = new HashMap<>();
        phoneNumbers.put("John", Arrays.asList("3434343434", "36767673443"));
        phoneNumbers.put("Soffiane", Arrays.asList("50505050505", "36767673443"));
        phoneNumbers.put("Sonia", Arrays.asList("010101010110", "32323232332"));


        Map<String, List<String>> filteredNumbers = phoneNumbers.entrySet().stream()
                .filter(x -> x.getKey().contains("Soffiane"))
                //collect prend le resultat du filter() et le convertit en autre chose
                //ici en Map
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

        filteredNumbers.forEach((key,value) -> {
            System.out.println("Name "+key+" : ");
            value.stream().forEach(System.out::println);
        });
    }
}

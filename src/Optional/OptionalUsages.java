package Optional;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The purpose of Optional is to express the potential absence of a value with a data-type
 * instead of having the implicit possibility to have an absent value just because null-reference exists in Java.
 * To overcome this problematic situation, developers invented many methods like annotations (Nullable, NotNull),
 * naming-conventions (e.g. prefixing a method with find instead of get) or just using code-comments to hint
 * that a method may intentionally return null and the invoker should care about this case.
 * A good example for this is the get-function of the map-interface of Java.
 * public V get(Object key);
 *
 * With Java 8 :
 * public Optional<V> get(Object key);
 */
public class OptionalUsages {

    static List<String> somethingStore = new ArrayList<>();

    public static void main(String... args){
        List<String> identifiers = new ArrayList<>();
        identifiers.add("VALUE1");
        identifiers.add("VALUE2");
        identifiers.add("VALUE5");
        identifiers.add("VALUE6");

        //le probleme ici est que l'on ne comprend pas l'intention du code
        //sans aller voir l'implemenation de findValue()
        //par ailleurs,il vaut mieux eviter d'avoir un null dans une collection
        //ce qui limite l'utilité d'avoir un Optional pour une collection
        List<IdEnum> mapped = identifiers.stream()
                .map(id -> findValue(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        //un peu plus clair, la methode isIdEnum fait le filter et le map
        //pour une Collection, eviter les Optional sauf si vous avez besoin d'une absence de valeur dans une liste
        List<IdEnum> mappedBis = identifiers.stream()
                .filter(s -> isIdEnum(s))
                .map(IdEnum::valueOf)
                .collect(Collectors.toList());

        //il vaut mieux gerer la valeur lors de l'appel de la fonction
        //exemple
        String somethingOrNull = "null";
        Optional.ofNullable(somethingOrNull).ifPresent(o -> addSomething(o));
        updateSomething();

        //un truc qu'on fait souvent : faire un isPresent() puis un get()
        //c'est la traduction du null-check mais on peut faire mieux
        Value value = null;
        Optional<Value> maybeValue = Optional.ofNullable(value);
        if (maybeValue.isPresent()) {
            doSomething(maybeValue.get());
        }
        //alternative au null check version Optional
        Optional<Value> maybeValueBis = Optional.ofNullable(value);
        maybeValue.ifPresent(v -> doSomething(v));
        //solution avec Java 9
        /*Optional.ofNullable(valueOrNull)
                .ifPresentOrElse(
                        this::doSomethingWithPresentValue,
                        this::doSomethingElse
                );*/

        //Optional permet d'obtenir une valeur par defaut avec la fonction OrElse()
        Optional<Integer> maybeNumber = Optional.of(5);
        int numberOr42 = maybeNumber.orElse(42);
        //ou encore ceci : mais dans ce cas, la fonction est TOUJOURS appelée
        //si la fonction met du temps, on va avoir des problemes de performance
        int numberOrDefault = maybeNumber.orElse(complexCalculation());
        //idem pour les mutateurs -> a eviter
        //pour ne pas appeler la fonction systematiquement, il faut appeler un lambda
        // avec ou sans reference de methode
        //dans ces cas, les fonctions ne sont appeleée que si maybeNumber est vide
        int numberOrDefault2 = maybeNumber.orElseGet(() -> complex());
        int numberOrDefault3 = maybeNumber.orElseGet(OptionalUsages::complex);
    }

    private static Integer complex() {
        return 0;
    }

    private static Integer complexCalculation() {
        return 0;
    }

    private static void doSomething(Value value) {
    }

    private static Optional<IdEnum> findValue(String id) {
        return EnumSet.allOf(IdEnum.class).stream()
                .filter(idEnum -> idEnum.name().equals(id))
                        .findFirst();
    }

    private static boolean isIdEnum(String id) {
        return Stream.of(IdEnum.values())
                .map(IdEnum::name)
                .anyMatch(name -> name.equals(id));
    }

    //peut on passer un Optional en parametre de methode ?
    //exemple de refactoring
    void addAndUpdate(String value) {
        if (value != null) {
            somethingStore.add(value);
        }
        updateSomething();
    }

    //On remplace le parametre par un Optional -> mauvaise pratique
    void addAndUpdate(Optional<String> maybeValue) {
        if (maybeValue.isPresent()) {
            somethingStore.add(maybeValue.get());
        }
        updateSomething();
    }

    //On va plutot gerer la valeur lors de l'appel de la fonction (voir le main)
    private static void addSomething(String value) {
        somethingStore.add(value);
    }


    private static void updateSomething() {
    }
}

/**
 * Conclusion :
 * Use Optional to communicate an intended possible absence of a value (e.g. the return value of a function).
 * Avoid having Optionals in collections or streams. Just fill them with the present values directly.
 * Avoid having Optionals as parameters of functions.
 * Avoid Optional::isPresent followed by Optional::get.
 * Avoid complex or state changing calculations in orElse. Use orElseGet for that.
 */

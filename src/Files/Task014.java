// Task014: Streams filter.

package Files;

import java.util.ArrayList;
import java.util.List;

public class Task014 {
    static List<String> places = new ArrayList<>();
    public static void main( String[] args ) {
        List<String> myPlaces = getPlaces();
        System.out.println("Places from India:");
        myPlaces.stream()
                .filter((p) -> p.startsWith("India"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }

    public static List<String> getPlaces(){
        places.add("Nepal, Kathmandu");
        places.add("Nepal, Pokhara");
        places.add("India, Delhi");
        places.add("USA, New York");
        places.add("Africa, Nigeria");
        return places;
    }
}


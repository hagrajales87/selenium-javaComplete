package javaSteams;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test1 {

    @Test void regular(){

        List<String> names = new ArrayList<String>();
        names.add("Hector");
        names.add("Grajales");
        names.add("Adam");
        names.add("Ram");
        int count = 0;
        for(int i = 0; i < names.size() ; i++){
            String actual = names.get(i);
            if(actual.startsWith("A")){
                count++;
            }
        }

        System.out.println(count);

    }

    @Test
    public void streamFilter(){
        List<String> names = new ArrayList<String>();
        names.add("Hector");
        names.add("Grajales");
        names.add("Adam");
        names.add("Rama");
        names.add("Asdrubal");

        Long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);
        //There is not life for internal operation if there no internal operation
        //terminal operation will execute only if inter op (filter) returns true
        //We can create stream'
        //how to use filter in Stream API
       long d = Stream.of("Hector","Grajales","Adam","ram","Asdrubal").filter(s ->
                {
                    return s.startsWith("A");
                    //return false;
                }).count();

        System.out.println(d);

        //print all the names that have a length grater than 4 of ArrayList
        names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

        names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
    }

    @Test
    public void streamMap(){
        /*
        //print names of length > 4 with uppercase
        Stream.of("Hector","Grajales","Adam","Rama","Asdrubal").filter( s -> s.endsWith("a")).
                map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
         */
        //print names which have first letter as a with uppercase and sorted
        List<String> names = Arrays.asList("Hector","Grajales","Adam","Rama","Asdrubal");

        names.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).
                forEach(s -> System.out.println(s));

        List<String> names1 = new ArrayList<String>();
        names1.add("Julie");
        names1.add("Milena");
        names1.add("Pilar");
        names1.add("Karen");
        names1.add("Jeniffer");

        Stream<String> newStream= Stream.concat(names.stream(), names1.stream());
        //newStream.sorted().forEach(s -> System.out.println(s));

        boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Adam"));
        Assert.assertTrue(flag);

    }

    @Test
    public void streamCollect(){
        //list
        //new list
        //new list

        List<String> ls =Stream.of("Hector","Grajales","Adam","Rama","Asdrubal","Angela").filter(s -> s.endsWith("a"))
                .map(String::toUpperCase).collect(Collectors.toList());

        ls.stream().forEach(System.out::println);

        System.out.println(ls.get(1));

        //
        List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
        //print unique number from this array
        //sort the array
        values.stream().distinct().forEach(System.out::println);
        List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));
    }

}

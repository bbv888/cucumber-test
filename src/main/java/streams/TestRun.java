package streams;

import java.util.*;

public class TestRun {
    public static void main(String[] args) {
        List <String> nameList=new ArrayList(Arrays.asList("Alex", "John", "Dan", "Hans"));
        Map<String, String> stringMap= new HashMap<>();
        stringMap.put("key1","value1");
        stringMap.put("key2","value2");
        System.out.println("nameList initialized");

        nameList.stream().forEach(e -> System.out.println(e.concat(" tada")));

        for(String a:nameList){
            System.out.println(a);
        }
    }

}

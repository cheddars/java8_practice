package kr.oddly.java8.chap01;

import static java.lang.Character.isDigit;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import kr.oddly.java8.model.Person;

import org.junit.Test;

/**
 * java.util.stream.Collectors.toList()
 * java.util.Arrays.asList() 
 * java.lang.Character.isDigit()
 * @author nezah
 */
public class CollectTest {
  @Test
  public void tryMinSearch(){
    // traditional
    List<Person> persons = asList(new Person("john", 25, "Programmer"),
                                  new Person("mike", 32, "cook"),
                                  new Person("sarah", 24, "fighter"));
    Person youngest = persons.get(0);
    for(Person p : persons){
      if(p.getAge() < youngest.getAge()){
        youngest = p;
      }
    }
    
    assertEquals(persons.get(2), youngest);
    
    // functional
    Person young = persons.stream()
                    .min(Comparator.comparing(p -> p.getAge()))
                    .get();
    assertEquals(persons.get(2), young);
  }
  
  @Test
  public void flatMapTest(){
    List<Integer> flatten = Stream.of(asList(1, 2), asList(3, 4))
                              .flatMap(n -> n.stream())
                              .collect(toList());
    assertEquals(asList(1, 2, 3, 4), flatten);
  }
  
  @Test
  public void testCollect() {
    List<String> l = Stream.of("a", "b", "c").collect(Collectors.toList());
    // collect 는 eager run
    assertEquals(Arrays.asList("a", "b", "c"), l);
  }

  @Test
  public void testMap(){
    // traditional transition
    List<String> l = new ArrayList<>();
    for(String s : asList("a", "b", "c")){
      String us = s.toUpperCase();
      l.add(us);
    }
    
    assertEquals(asList("A", "B", "C"), l);
    
    // same logic with map
    l = Stream.of("a", "b", "c")
          .map(s -> s.toUpperCase())
          .collect(toList());
    assertEquals(asList("A", "B", "C"), l);
  }
  
  @Test
  public void testFilter(){
    // traditional
    List<String> l1 = new ArrayList<>();
    for(String v : asList("a", "1a", "2b", "c")) {
      if(isDigit(v.charAt(0))){
        l1.add(v);
      }
    }
    assertEquals(asList("1a", "2b"), l1);
    
    // filter
    List<String> l = Stream.of("a", "1a", "2b", "c")
                        .filter(v -> isDigit(v.charAt(0)))
                        .collect(toList());
    assertEquals(asList("1a", "2b"), l);
    
  }
}

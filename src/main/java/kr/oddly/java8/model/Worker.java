package kr.oddly.java8.model;

import java.util.ArrayList;
import java.util.List;

public class Worker {
  private List<Person> persons;
  
  public Worker(List<Person> persons){
    this.persons = persons;
  }
  
  public void addPerson(Person p){
    if(persons == null){
      persons = new ArrayList<>();
    }
    persons.add(p);
  }
}

package kr.oddly.java8.model;

public class Person {
  private String name;
  private int age;
  private String job;
  
  public Person(String n, int a, String j){
    this.name = n;
    this.age = a;
    this.job = j;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public String getJob() {
    return job;
  }
  public void setJob(String job) {
    this.job = job;
  }
  
}

package kr.oddly.java8.chap01;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StreamTest {
  private List<String> l;
  
  @Before
  public void init(){
    l = new ArrayList<>();
    l.add("s");
    l.add("a");
    l.add("k");
    l.add("s");
  }
  
  @Test
  public void testStream() {
    long cnt = l.stream().filter(s -> "s".equals(s)).count();
    assertEquals(2L, cnt);
  }

  @Test
  public void lazyRunTest(){
    l.stream().filter(s -> {
      System.out.println("s : " + s);
      return "s".equals(s);
    });
  }
  
  @Test
  public void eagerRunTest(){
    l.stream().filter(s -> {
      System.out.println("s : " + s);
      return "s".equals(s);
    }).count();
    // return 이 없는 구문은 scala 처럼 마지막행을 return 처리하는 걸까?
  }
}

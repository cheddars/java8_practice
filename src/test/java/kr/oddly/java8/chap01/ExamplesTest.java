package kr.oddly.java8.chap01;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

public class ExamplesTest {

  
  class Examples{
    public int addUp(Stream<Integer> stream) {
      return stream.reduce(0, (acc, ele) -> acc + ele);
    }
  }
  
  class Artist{
    private Stream<Member> members;
    public Artist(int num){
      List<Member> l = new ArrayList<>();
      for(int i = 0; i < num; i++){
        l.add(new Member());
      }
      members = l.stream();
    }
    public Stream<Member> getMembers(){
      return members;
    }
  }
  
  class Member{
    
  }
  
  @Test
  public void ex01(){
    Examples e = new Examples();
    assertEquals(24, e.addUp(Arrays.asList(10, 2, 8, 4).stream()));
    assertEquals(-18, e.addUp(Arrays.asList(-10, 2, -8, -4, 2).stream()));
  }
  
  @Test
  public void beforeRefactoring(){
    int totalMembers = 0;
    List<Artist> artists = new ArrayList<>();
    artists.add(new Artist(3));
    artists.add(new Artist(2));
    artists.add(new Artist(5));
    
    for(Artist artist : artists){
      Stream<Member> members = artist.getMembers();
      totalMembers += members.count();
    }
    
    assertEquals(10, totalMembers);
  }
  
  @Test
  public void afterRefactoring(){
    List<Artist> artists = new ArrayList<>();
    artists.add(new Artist(3));
    artists.add(new Artist(2));
    artists.add(new Artist(5));
    
    int totalMembers = artists.stream()
      .map(i -> (int) i.getMembers().count())
      .reduce(0, (acc, ele) -> acc + ele);
    
    assertEquals(10, totalMembers);
  }
}

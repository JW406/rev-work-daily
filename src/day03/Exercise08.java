package day03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Player08 implements Comparable<Player08> {
  int ranking;
  String name;
  int age;

  public Player08(int ranking, String name, int age) {
    this.ranking = ranking;
    this.name = name;
    this.age = age;
  }

  @Override
  public int compareTo(Player08 o) {
    if (ranking == o.ranking) {
      return age - o.age;
    } else {
      return ranking - o.ranking;
    }
  }
}

public class Exercise08 {
  public static void main(String[] args) {
    List<Player08> list = new ArrayList<>();
    list.add(new Player08(2, "bar", 19));
    list.add(new Player08(1, "foo", 18));
    list.add(new Player08(1, "foo", 17));
    Collections.sort(list);
    for (Player08 p : list) {
      System.out.println(p.ranking + " " + p.name + " " + p.age);
    }
  }
}

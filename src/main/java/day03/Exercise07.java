package day03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Player implements Comparable<Player> {
  int ranking;
  String name;
  int age;

  public Player(int ranking, String name, int age) {
    this.ranking = ranking;
    this.name = name;
    this.age = age;
  }

  @Override
  public int compareTo(Player o) {
    return ranking - o.ranking;
  }
}

public class Exercise07 {
  public static void main(String[] args) {
    List<Player> list = new ArrayList<>();
    list.add(new Player(2, "bar", 19));
    list.add(new Player(1, "foo", 18));
    Collections.sort(list);
    for (Player p : list) {
      System.out.println(p.ranking + " " + p.name + " " + p.age);
    }
  }
}

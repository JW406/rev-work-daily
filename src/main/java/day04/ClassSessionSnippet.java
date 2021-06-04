package day04;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class TestJoin extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 3; i++) {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName() + "-" + i);
    }
  }
}

class TestJoin_v2 implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 3; i++) {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName() + "-" + i);
    }
  }
}

class Account {
  int balance;

  public Account(int balance) {
    this.balance = balance;
  }

  void withDraw(int amnt) {
    balance -= amnt;
  }
}

class AccHolder implements Runnable {
  Account acc;

  public AccHolder(Account acc) {
    this.acc = acc;
  }

  /* synchronized */ private void makeWithdrawal(int amnt) {
    if (acc.balance >= amnt) {
      System.out.println(Thread.currentThread().getName() + " tries to retrieve " + amnt);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      acc.withDraw(amnt);
      System.out.println(Thread.currentThread().getName() + " completes retrieving " + amnt);
    } else {
      System.out.println(Thread.currentThread().getName() + " cannot complete retrieving " + amnt
          + ", current balance: " + acc.balance);
    }
  }

  @Override
  public void run() {
    for (int i = 0; i < 3; i++) {
      makeWithdrawal(2000);
    }
  }
}

interface Shape {
  void draw();
}

class Foo {
  public void Bar() {
    System.out.println("drawing.....");
  }
}

public class ClassSessionSnippet {
  public static void main(String[] args) throws InterruptedException {
    // useThreadJoin();
    // useThreadJoin_v2();
    // TestBank();
    // nativeLogger();
    // testStream();
    // testStream02();
    // testStream03();

    Shape s = new Foo()::Bar;
    s.draw();
  }

  private static final Logger logger = Logger.getLogger(ClassSessionSnippet.class.getName());

  private static void nativeLogger() {
    logger.info("foo bar");
  }

  private static void testStream() {
    // Stream.iterate(0, (n) -> n + 1).limit(10).forEach((x) -> System.out.println(x));
    Stream.iterate(0, (n) -> n + 1).limit(10).forEach(System.out::println);
  }

  private static void testStream02() {
    List<String> memberNames = new ArrayList<>();
    memberNames.add("Alex");
    memberNames.add("Sams");
    memberNames.stream().filter((s) -> s.startsWith("A")).map(String::toUpperCase).forEach(System.out::println);
  }

  private static void testStream03() {
    List<Integer> list1 = Arrays.asList(1, 2, 3);
    List<Integer> list2 = Arrays.asList(4, 5, 6);
    List<Integer> list3 = Arrays.asList(7, 8, 9);
    List<List<Integer>> mat = Arrays.asList(list1, list2, list3);
    List<Integer> flat = mat.stream().flatMap((x) -> x.stream()).collect(Collectors.toList());
    System.out.println(flat);
  }

  private static void TestBank() {
    Account acc = new Account(6000);
    AccHolder holder = new AccHolder(acc);
    Thread t1 = new Thread(holder);
    Thread t2 = new Thread(holder);
    t1.setName("Cherry");
    t2.setName("Sam");
    t1.start();
    t2.start();
  }

  private static void printThreadStates() {
    State[] states = Thread.State.values();
    for (State state : states) {
      System.out.println(state);
    }
  }

  private static void useThreadJoin() throws InterruptedException {
    TestJoin t1 = new TestJoin();
    TestJoin t2 = new TestJoin();
    TestJoin t3 = new TestJoin();
    t1.setName("Thread1");
    t2.setName("Thread2");
    t3.setName("Thread3");
    t1.start();
    t1.join();
    t2.start();
    t3.start();
  }

  private static void useThreadJoin_v2() throws InterruptedException {
    Thread t1 = new Thread(new TestJoin_v2());
    Thread t2 = new Thread(new TestJoin_v2());
    Thread t3 = new Thread(new TestJoin_v2());
    t1.setName("Thread1");
    t2.setName("Thread2");
    t3.setName("Thread3");
    t1.start();
    t1.join();
    t2.start();
    t3.start();
  }
}

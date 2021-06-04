package day04;

import java.lang.Thread.State;
import java.util.logging.Logger;

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

public class ClassSessionSnippet {
  public static void main(String[] args) throws InterruptedException {
    // useThreadJoin();
    // useThreadJoin_v2();
    TestBank();
    // nativeLogger();
  }

  private static final Logger logger = Logger.getLogger(ClassSessionSnippet.class.getName());

  private static void nativeLogger() {
    logger.info("foo bar");
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

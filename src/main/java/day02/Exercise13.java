package day02;

interface Compute {
  int computer(int n, int m);
}

class Addition implements Compute {
  @Override
  public int computer(int n, int m) {
    return n + m;
  }
}

class Subtraction implements Compute {
  @Override
  public int computer(int n, int m) {
    return n - m;
  }
}

class Multiplication implements Compute {
  @Override
  public int computer(int n, int m) {
    return n * m;
  }
}

class Division implements Compute {
  @Override
  public int computer(int n, int m) {
    return n / m;
  }
}

class UseCompute {
  public void useCom(Compute com, int a, int b) {
    System.out.println("result: " + com.computer(a, b));
  }
}

public class Exercise13 {
  public static void main(String[] args) {
    UseCompute uc = new UseCompute();
    uc.useCom(new Addition(), 3, 2);
    uc.useCom(new Subtraction(), 3, 2);
    uc.useCom(new Multiplication(), 3, 2);
    uc.useCom(new Division(), 3, 2);
  }
}

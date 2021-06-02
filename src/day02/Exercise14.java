package day02;

interface A {
  double PI = 3.14;

  double area();
}

interface B {
  void setColor(String c);
}

interface C extends A, B {
  double volume();
}

class Cylinder implements C {
  private double radius = 0.0;
  private double height = 0.0;
  private String color = "<no color>";

  public Cylinder(double radius, double height, String color) {
    this.radius = radius;
    this.height = height;
    this.color = color;
  }

  @Override
  public double area() {
    return A.PI * radius * radius;
  }

  @Override
  public void setColor(String c) {
    this.color = c;
  }

  @Override
  public double volume() {
    return area() * height;
  }
}

public class Exercise14 {
}

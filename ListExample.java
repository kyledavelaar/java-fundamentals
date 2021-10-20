import java.util.*;

class Dog {
  public String name;
  Dog(String n) {
    name = n;
  }
}

public class ListExample {
  public static void main(String[] args) {
    List<Dog> d = new ArrayList<Dog>();
    Dog dog = new Dog("dai");
    d.add(dog);
    d.add(new Dog("clover"));
    d.add(new Dog("mags"));
    Iterator<Dog> iter = d.iterator();
    while(iter.hasNext()) {
      Dog d2 = iter.next();
      System.out.println(d2.name);
    }
    String secondName = d.get(1).name;
    System.out.println(secondName);
    d.remove(2);
    Object[] ao = d.toArray();
    for (Object o : ao) {
      Dog d2 = (Dog)o;
      System.out.println(d2.name);
    }
  }
}

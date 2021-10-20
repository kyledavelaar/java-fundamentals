import java.util.*;

class Dog {
  public String name;

  public Dog(String n) {
    name = n;
  }
  /*
    if use Maps must override both equals and hashCode or won't be able to lookup your stored Map values
  */
  public boolean equals(Object o) {
    if (o instanceof Dog && (((Dog)o).name == name)) {
      return true;
    } else {
      return false;
    }
  }

  public int hashCode() {
    return name.length();
  }
}

class Cat {}

enum Pets {DOG, CAT, HORSE}

public class MapExample {
  public static void main(String[] args) {
    Map<Object, Object> m = new HashMap<>();
    m.put("k1", new Dog("aiko"));
    m.put("k2", Pets.DOG);
    m.put(Pets.CAT, "CAT key");
    Dog d1 = new Dog("clover"); // keeping this reference
    m.put(d1, "dog key");
    m.put(new Cat(), "Cat key");
    System.out.println(m.get("k1")); // Dog@1c (Dog object, value will vary)
    String k2 = "k2";
    System.out.println(m.get(k2)); // DOG
    Pets p = Pets.CAT;
    System.out.println(m.get(p)); // CAT key
    System.out.println(m.get(d1)); // dog key
    System.out.println(m.get(new Cat())); // null
    System.out.println(m.size()); // 5

    d1.name = "magnolia";
    System.out.println(m.get(d1)); // null b/c old name was used to set hashCode and now hashCode has changed with the new name.  The HashMap still holds a reference to the old hashCode, not the new one.

    d1.name = "clover";
    System.out.println(m.get(new Dog("clover"))); // hashCode is now the same length (step 1) so it looks in correct bucket, also the name is the same so equals methods is successful (step 2) so it returns "dog key" correctly

    d1.name = "clovee";
    System.out.println(m.get(new Dog("clover"))); // hashCode step succeeds b/c string length the same but equals fails b/c their names are different.  Returns null
  }
}

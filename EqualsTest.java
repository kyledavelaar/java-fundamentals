public class EqualsTest {
  public static void main(String [] args) {
    Foo one = new Foo(8);
    Foo two = new Foo(8);
    if (one.equals(two)) {
      System.out.println("one equals two");
    }
  }
}


class Foo {
  private int fooValue;
  Foo(int val) {
    fooValue = val;
  }

  public int getFooValue() {
    return fooValue;
  }
  /*
    Methods like equals and toSting in the JavaApi have a contract that needs to be followed when overriding.  Here the method must remain 'public' and return a boolean.  Otherwise we'd be overloading it and not overriding it.
    Also we need to only accept Object types as the argument otherwise we'd be overloading it.  And b/c we aren't sure our Object type is actually a Foo, we need to make sure it is one first before trying to call a method that is only in Foo.  If we try to call that on Object, we'll get a compiler error saying that method is not in the Object class.
    Lastly, if two objects are considered equal they must also have the same hashcode.  If you want this last part to change you'd need to override hashCode as well.
  */
  public boolean equals(Object o) {
    if ((o instanceof Foo) && (((Foo)o).getFooValue() == this.fooValue)) {
      return true;
    } else {
      return false;
    }
  }
}

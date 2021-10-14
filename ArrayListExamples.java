import java.util.*;

public class ArrayListExamples {
  public static void main(String[] args) {
    // 'coding to an interface' is an OO principal used here
    // most often we polymorphically use List as the type when using ArrayList
    // this is true for all collection types and their interfaces
    List<String> myList = new ArrayList<String>();
    String s = "hi";
    myList.add(s);
    System.out.println(myList.size());
    myList.remove("hi");
    System.out.println(myList.size());

    List<Integer> myInts = new ArrayList<Integer>();
    myInts.add(43); // autoboxing allows us to add primitives without having to wrap them with wrapper classes like `myInts.add(new Integer(43))`

  }
}

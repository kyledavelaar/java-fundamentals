import java.util.*;

public class ArrayListExamples {
  public static void main(String[] args) {
    // 'coding to an interface' is an OO principal used here
    // most often we polymorphically use List as the type when using ArrayList
    // this is true for all collection types and their interfaces
    List<String> myList = new ArrayList<String>();
    // since Java7 you can shorten to this
    List<String> myList2 = new ArrayList<>();
    String s = "hi";
    myList.add(s);
    myList2.add("yo");
    myList2.add("sister");
    Collections.sort(myList2); // ArrayList doesn't have a sort method
    System.out.println(myList.size());
    myList.remove("hi");
    System.out.println(myList.size());

    List<Integer> myInts = new ArrayList<Integer>();
    myInts.add(43); // autoboxing allows us to add primitives without having to wrap them with wrapper classes like `myInts.add(new Integer(43))`


    // must sort before can use search methods from Collections class (binarySearch)
    // if sorted using a Comparator, it must be searched using that Comparator too
    // Comparators cannot be used when searching arrays of primitives

  }
}

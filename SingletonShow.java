import java.util.*;

public class SingletonShow {
  // private so no one can instantiate SingletonShow from the outside
  private static final SingletonShow INSTANCE = new SingletonShow();
  private Set<String> availableSeats;

  // a way for those outside to get the only instance
  // must be static b/c those outside won't be able to instantiate SingletonShows
  public static SingletonShow getInstance() {
    return INSTANCE;
  }

  private SingletonShow() {
    availableSeats = new HashSet<String>();
    availableSeats.add("1A");
    availableSeats.add("1B");
  }

  public boolean bookSeat(String seat) {
    return availableSeats.remove(seat);
  }

  public static void main(String[] args) {
    ticketAgentBooks("1A"); // true -> can book seat
    ticketAgentBooks("1A"); // false -> seat already booked
  }

  private static void ticketAgentBooks(String seat) {
    SingletonShow singletonShow = SingletonShow.getInstance();
    System.out.println(singletonShow.bookSeat(seat));
  }
}



/*
  Java 5 syntax for easier creation of singletons

  public enum SingletonShow {
    INSTANCE

    ...same code as before except no longer need getInstance() method

    private static void ticketAgentBooks(String seat) {
      SingletonShow singletonShow = SingletonShow.INSTANCE();
      System.out.println(singletonShow.bookSeat("1A"));
    }
  }
*/

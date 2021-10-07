import java.util.*;

public class Book {
  private String isbn;
  private String title;
  private String author;
  // getters/setters omitted
}

public interface BookDao {
  Collection<Book> findAllBooks();
  Book findBookByIsbn(Book book);
  void create(Book book);
  void delete(Book book);
  void update(Book book);
}

public class InMemoryBookDao implements BookDao {
  // implement in memory versions of interface methods
}

public class SQLBookDao implements BookDao {
  // implement sql versions of interface methods
}

public abstract class FactoryBase {
  public abstract BookDao createDao(String type);
}

public class FactoryImp extends FactoryBase {
  public BookDao createDao(String type) {
    if (type == "memory") {
      return new InMemoryBookDao();
    } else {
      return new SQLBookDao();
    }
    // factory can easily spit out different DAO implementations now
    // it also can change easily without affecting the main method
    // from the main method all we care about is get/update/delete/create
    // and those remain the same no matter what kind of dao we use
  }
}

public class Factory {
  public static void main(String[] args) {
    FactoryBase factory = new FactoryImp();
    BookDao dao = factory.createDao("sql");
    // use dao
  }
}

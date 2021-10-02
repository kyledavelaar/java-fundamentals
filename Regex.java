import java.util.regex.*;

public class Regex {
  public static void main(String[] args) {
    Pattern p = Pattern.compile(args[0]);
    Matcher m = p.matcher(args[1]);
    while(m.find()) {
      System.out.println(m.start() + " " + m.group());
    }
  }
}


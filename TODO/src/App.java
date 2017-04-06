import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gabor on 06/04/2017.
 */
public class App {

  public static void main(String[] args) {

    Path p = Paths.get("welcomeManual.txt");
    List<String> welcomeM = null;

    try {
      welcomeM = Files.readAllLines(p);
      if (args.length == 0) {
        System.out.println();
        for (String line : welcomeM) {
          System.out.println(line);
        }
        System.out.println();
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}


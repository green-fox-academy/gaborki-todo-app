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

    Path welcomeMessage = Paths.get("welcomeManual.txt");
    Path taskList = Paths.get("tasks.txt");
    List<String> welcomeM = null;
    List<String> tasks = null;

    try {
      welcomeM = Files.readAllLines(welcomeMessage);
      if (args.length == 0) {
        System.out.println();
        for (String line : welcomeM) {
          System.out.println(line);
        }
        System.out.println();
      } else if (args.length > 0 && args[0].length() < 3 && args[0].startsWith("-") && args[0].contains("l")) {
        tasks = Files.readAllLines(taskList);
        System.out.println();
        for (int i = 0; i < tasks.size(); i++){
          System.out.println((i + 1) + " - " + tasks.get(i));
        }
        System.out.println();
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }


  }
}


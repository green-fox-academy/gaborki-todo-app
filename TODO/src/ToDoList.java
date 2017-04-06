import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Gabor on 06/04/2017.
 */
public class ToDoList {

  Path welcomeMessage = Paths.get("welcomeManual.txt");
  Path taskList = Paths.get("tasks.txt");
  List<String> welcomeM;
  List<String> tasks;
  String args[];

  boolean isThereArgs(String[] args) {
    this.args = args;
    return (args.length > 0);
  }

  int howManyArgs(String[] args) {
    this.args = args;
    if (isThereArgs(this.args)) {
      return args.length;
    } else {
      return 0;
    }
  }

  void welcomeMessage() {
    try {
      welcomeM = Files.readAllLines(welcomeMessage);
      if (!isThereArgs(args)) {
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

  void listTask(){
    try {
      if (isThereArgs(args) && args[0].length() < 3 && args[0].contains("-l")) {
        tasks = Files.readAllLines(taskList);
        System.out.println();
        if(tasks.size() == 0){
          System.out.println("No todos for today!");
        }
        else {
          for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + " - " + tasks.get(i));
          }
          System.out.println();
        }
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  void emptyList(){


  }


  public ToDoList(String[] args) {
    this.args = args;
  }
}

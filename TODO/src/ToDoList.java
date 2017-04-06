import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Gabor on 06/04/2017.
 */
public class ToDoList {

  String args[];

  boolean isThereArgs(String[] args) {
    this.args = args;
    return (args.length > 0);
  }

  boolean areThereTwoArgs(String[] args) {
    this.args = args;
    return (args.length > 1);
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
    Path welcomeMessage = Paths.get("welcomeManual.txt");
    List<String> welcomeM;
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

  void listTask() {
    Path taskList = Paths.get("tasks.txt");
    List<String> tasks;
    try {
      if (isThereArgs(args) && args[0].length() < 3 && args[0].contains("-l")) {
        tasks = Files.readAllLines(taskList);
        System.out.println();
        if (tasks.size() == 0) {
          System.out.println("No todos for today!");
        } else {
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

  void addTaskToList() {
    Path tList = Paths.get("tasks.txt");
    List<String> list;
    try {
      if (args[0].contains("-a") && args[0].length() < 3) {
        if (areThereTwoArgs(args)) {
          list = Files.readAllLines(tList);
          list.add(args[1]);
          Files.write(tList, list);
        } else {
          System.out.println();
          System.out.println("Unable to add: No task provided");
          System.out.println();
        }
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  void removeTask() {
    Path tList = Paths.get("tasks.txt");
    List<String> list;
    try {
      int index;
      list = Files.readAllLines(tList);
      if (args[0].contains("-r") && args[0].length() < 3) {
        System.out.println();
        if (args[0].contains("-r") && args.length < 2) {
          System.out.println("Unable to remove: no index provided");
          System.out.println();
        } else if (list.size() < Integer.parseInt(args[1])) {
          System.out.println("Unable to remove: index is out of bound");
          System.out.println();
        } else if (areThereTwoArgs(args)) {
          index = Integer.parseInt(args[1]);
          list.remove(index - 1);
          Files.write(tList, list);
        }
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    } catch (Exception e) {
      System.out.println("Unable to remove: index is not a number ");
      System.out.println();
    }
  }

  void checkTask() {
    Path taskList = Paths.get("tasks.txt");
    List<String> tasks;
    try {
      tasks = Files.readAllLines(taskList);
      if (areThereTwoArgs(args) && args[0].length() < 3 && args[0].contains("-c")) {
        for (int i = 0; i < tasks.size(); i++) {
          if (!tasks.get(i).startsWith("[")) {
            tasks.set(i, "[ ] " + tasks.get(i));
          }
          if ((i + 1) == Integer.parseInt(args[1])) {
            tasks.set(i, tasks.get(i).substring(0, 1) + "x" + tasks.get(i).substring(2));
          }
        }
      }
      Files.write(taskList, tasks);
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  void argError() {
    if (args.length == 0 || !args[0].startsWith("-")) {
      System.out.println();
      System.out.println("Unsupported argument");
      System.out.println();
    }
  }

  public ToDoList(String[] args) {
    this.args = args;
  }
}

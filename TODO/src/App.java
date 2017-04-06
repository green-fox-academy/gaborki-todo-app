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
    ToDoList myList = new ToDoList(args);

    myList.welcomeMessage();
    myList.listTask();
    myList.addTaskToList();
    myList.removeTask();
    myList.argError();
    myList.checkTask();
  }
}


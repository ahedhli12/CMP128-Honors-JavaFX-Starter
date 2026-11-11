import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import javafx.application.Application;

// Keep this file: launch.json starts this class.
// JavaFX programs belong in this folder, without a package declaration.
public class HonorsLauncher {
    public static void main(String[] args) throws IOException {
        List<Class<? extends Application>> apps = new ArrayList<>();

        // Find compiled JavaFX applications matching the Java files in this folder.
        try (Stream<Path> files = Files.list(Path.of("."))) {
            files.filter(path -> path.toString().endsWith(".java"))
                 .sorted(Comparator.comparing(Path::toString))
                 .forEach(path -> {
                     String filename = path.getFileName().toString();
                     String className = filename.substring(0, filename.length() - 5);
                     try {
                         Class<?> candidate = Class.forName(
                             className, false, HonorsLauncher.class.getClassLoader());
                         if (Application.class.isAssignableFrom(candidate)
                                 && !Modifier.isAbstract(candidate.getModifiers())) {
                             apps.add(candidate.asSubclass(Application.class));
                         }
                     } catch (ClassNotFoundException exception) {
                         System.err.println("Not compiled yet: " + filename
                             + ". Save all files and wait for Java to build.");
                     }
                 });
        }

        if (apps.isEmpty()) {
            System.err.println("No JavaFX application was found. Keep your JavaFX .java files "
                + "in the main folder, save them, and resolve the Problems panel errors.");
            return;
        }

        int selected = 0;
        // One application starts immediately. Multiple applications get a terminal menu.
        if (apps.size() > 1) {
            System.out.println("Choose a JavaFX application:");
            for (int i = 0; i < apps.size(); i++) {
                System.out.println((i + 1) + ". " + apps.get(i).getSimpleName());
            }
            Scanner input = new Scanner(System.in);
            while (true) {
                System.out.print("Enter a number: ");
                if (!input.hasNextLine()) {
                    return;
                }
                try {
                    selected = Integer.parseInt(input.nextLine().trim()) - 1;
                    if (selected >= 0 && selected < apps.size()) {
                        break;
                    }
                } catch (NumberFormatException exception) {
                    // Ask again when the input is not a whole number.
                }
                System.out.println("Please enter a number from 1 to " + apps.size() + ".");
            }
        }

        Application.launch(apps.get(selected), args);
    }
}

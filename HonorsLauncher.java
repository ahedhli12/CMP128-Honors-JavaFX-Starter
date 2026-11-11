import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import javafx.application.Application;

/** Supplied setup helper. Students write their own Application class. */
public final class HonorsLauncher {
    private HonorsLauncher() { }

    public static void main(String[] args) throws Exception {
        List<Class<? extends Application>> apps = new ArrayList<>();
        // This beginner project keeps Java source files in the project root.
        try (Stream<Path> files = Files.list(Path.of("."))) {
            List<Path> sources = files
                .filter(p -> p.getFileName().toString().endsWith(".java"))
                .sorted(Comparator.comparing(p -> p.getFileName().toString()))
                .toList();
            for (Path source : sources) {
                String name = source.getFileName().toString().replaceFirst("\\.java$", "");
                if (name.equals("HonorsLauncher")) continue;
                try {
                    Class<?> type = Class.forName(name, false,
                        HonorsLauncher.class.getClassLoader());
                    if (Application.class.isAssignableFrom(type)
                            && !java.lang.reflect.Modifier.isAbstract(type.getModifiers())) {
                        apps.add(type.asSubclass(Application.class));
                    }
                } catch (ClassNotFoundException ex) {
                    System.out.println("Not found among compiled root classes: " + name);
                }
            }
        }
        if (apps.isEmpty()) {
            throw new IllegalStateException(
                "No compiled JavaFX Application found. Keep the .java file in the project root, "
                + "omit package declarations, extend Application, and fix compilation errors.");
        }
        int selected = 0;
        if (apps.size() > 1) {
            System.out.println("Choose the JavaFX application to run:");
            for (int i = 0; i < apps.size(); i++) {
                System.out.println((i + 1) + ": " + apps.get(i).getSimpleName());
            }
            Scanner input = new Scanner(System.in);
            while (true) {
                System.out.print("Enter a number from 1 to " + apps.size() + ": ");
                String answer = input.nextLine().trim();
                try {
                    selected = Integer.parseInt(answer) - 1;
                    if (selected >= 0 && selected < apps.size()) break;
                } catch (NumberFormatException ignored) {
                    // Ask again for a valid menu number.
                }
            }
        }
        System.out.println("Launching " + apps.get(selected).getSimpleName());
        Application.launch(apps.get(selected), args);
    }
}

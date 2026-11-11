package edu.ccm;

import java.lang.reflect.Modifier;
import javafx.application.Application;

/** Infrastructure only: launch an explicitly named application, not the active file. */
public final class HonorsLauncher {
    private HonorsLauncher() { }

    public static void main(String[] args) {
        if (args.length == 0 || args[0].isBlank()) {
            throw new IllegalArgumentException(
                "Enter an application class such as edu.ccm.JavaFXInstallTest.");
        }
        String className = args[0].trim();
        if (className.endsWith(".java") || className.contains("/") || className.contains("\\")) {
            throw new IllegalArgumentException(
                "Enter a package-and-class name, not a filename or path: " + className);
        }
        try {
            Class<?> candidate = Class.forName(className);
            if (!Application.class.isAssignableFrom(candidate)
                    || Modifier.isAbstract(candidate.getModifiers())) {
                throw new IllegalArgumentException(
                    className + " must be a concrete JavaFX Application class.");
            }
            System.out.println("Launching " + className);
            Application.launch(candidate.asSubclass(Application.class),
                java.util.Arrays.copyOfRange(args, 1, args.length));
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(
                "Cannot find " + className
                + ". Check its package, filename, source folder, and compilation errors.", e);
        }
    }
}

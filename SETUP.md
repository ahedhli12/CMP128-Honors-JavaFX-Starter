# JavaFX setup in VS Code

## 1. Open this project
Open the folder containing pom.xml, not only one Java file. Install Microsoft's Extension Pack for Java if permitted, or ask IT to enable it. Do not create another JavaFX project using the wizard.

## 2. Locate the installed JDK
Use a full JDK 21, as recommended in the project instructions. Ask IT for its installed path if necessary. A newer approved JDK may also compile release 21, but your professor should standardize the class environment.

Three paths have different purposes:
| Path | What it contains | Where it is used |
|---|---|---|
| JDK root, e.g. C:/Program Files/Java/jdk-21 | bin plus other JDK folders | JAVA_HOME |
| JDK bin/java.exe | Java executable | VS Code launch prompt |
| JavaFX SDK lib | javafx.controls.jar and other JavaFX libraries | Manual SDK module path only |

**This repository uses Maven. You do not need a separate JavaFX SDK path or module-path arguments for its normal launch.**

Open Command Palette → **Java: Configure Java Runtime** and select the installed JDK for this project. If needed, edit VS Code **User Settings JSON** (not Windows system environment variables) to add:
```json
"java.configuration.runtimes": [
  {
    "name": "JavaSE-21",
    "path": "C:/REPLACE-WITH-ACTUAL-JDK-ROOT",
    "default": true
  }
]
```
Use the real path. Do not paste this as a second separate JSON object into existing settings. User settings availability depends on VM policy.

The Java language server can have its own newer JDK requirement. If the Java extension itself cannot start, ask IT to configure its supported tooling JDK; changing a project runtime does not fix a missing tooling runtime.

## 3. Wait for Maven import
Allow VS Code to load pom.xml and its JavaFX dependencies. Internet access is needed for the first download unless they are already cached. JavaFX comes from Maven; do not mix in SDK 25/26/27 JARs.

## 4. Run the installation test
1. Press Ctrl+Shift+D.
2. Select **Run Honors JavaFX Application**.
3. Click the green arrow.
4. At the Java executable prompt, paste the full path to your installed JDK's **bin/java.exe**, without surrounding quotes.
5. At the application-class prompt, accept **edu.ccm.JavaFXInstallTest**.
6. Enter a name and click the button. A greeting and click count should appear.
7. Close the window before starting another run.

On macOS/Linux, provide the JDK's bin/java executable instead. Maven must resolve the platform-specific JavaFX dependencies for that computer.

The launcher is a plain Java main class that starts JavaFX. Keep HonorsLauncher.java unchanged. No active-file variable is used, so opening settings.json cannot turn it into the main class.

## 5. If JAVA_HOME prevents a Maven build
Use Terminal → **Run Task → Build and run honors GUI with Maven**.
The prompts ask for:
1. Full Maven executable path, such as the installed .../bin/mvn.cmd on Windows; use the actual executable supplied by IT.
2. The application class, initially edu.ccm.JavaFXInstallTest.
3. **JDK root folder**, not bin and not java.exe.

The task passes JAVA_HOME only to the Maven process it starts. It does not edit Windows system settings and does not require environment-variable administration rights by itself. VM policy must still permit running the installed executables.

The Maven extension does not guarantee that a terminal mvn command is available. If Maven is missing, IT must install/provide it. A ZIP containing JavaFX is not a JDK or Maven installation.

## 6. Add or rename your application
Create src/main/java/edu/ccm/GradeTracker.java, for example. Its first line is `package edu.ccm;`, its public class is GradeTracker, and it extends Application. Implement start(Stage stage).

Run the existing configuration and enter **edu.ccm.GradeTracker**. Do not enter GradeTracker.java or its disk path. Multiple Application classes can coexist because you explicitly choose one. Other helper classes can be used normally; they are not application entry points.

For another package, match its folders and package declaration, then enter its full package-and-class name.

## Troubleshooting
- **Main class settings or launch not found:** select the supplied configuration; do not use a current-file launch configuration.
- **JavaFX runtime components missing:** run HonorsLauncher through the supplied configuration, after Maven import. Remove old duplicate configurations from your own copy if they cause confusion.
- **JavaFX imports unresolved:** open the project root, wait for Maven import, check dependency access, then try Java: Clean Java Language Server Workspace.
- **Class not found:** check the package, public class name, filename, source folder, and compilation errors.
- **Not a JavaFX Application:** enter a class that extends javafx.application.Application.
- **Executable not found:** check the exact path and VM execution permissions.
- **Unsupported release/class version:** check the selected JDK; this starter targets release 21.
- **Window does not open in a VM:** confirm the VM has a working graphical desktop and displays application windows; preserve the exact error for IT.

## Validation limit
The files are supplied as a starter. The professor should run Phase 0 on the actual college VM before distributing it to all students.

References:
- https://code.visualstudio.com/docs/java/java-project
- https://code.visualstudio.com/docs/java/java-debugging
- https://openjfx.io/openjfx-docs/

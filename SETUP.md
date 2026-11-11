# Simple JavaFX setup for CMP 128

## 1. Open the folder
Open the repository folder in VS Code. Use Microsoft's Extension Pack for Java. If your VM already has it, do not reinstall it.

Use an installed full JDK and a compatible JavaFX SDK. JDK 21 with JavaFX SDK 21 is a straightforward baseline matching the original project's recommended JDK. Ask IT which JDK is installed; do not assume the newest SDK matches it.

## 2. Extract the JavaFX SDK
Download the SDK for your operating system and architecture from https://gluonhq.com/products/javafx/ and extract the ZIP.

Open its **lib** folder. It must contain javafx.controls.jar, javafx.graphics.jar, and javafx.base.jar. Copy this folder's full path.

**JavaFX lib** is used for the libraries. **JDK bin** contains java.exe and javac.exe. They are different folders.

## 3. Enter the library path once in settings
Open .vscode/settings.json. Replace:
```json
"C:/REPLACE-WITH-YOUR-JAVAFX-SDK/lib/*.jar"
```
with your actual SDK lib path followed by /*.jar, for example:
```json
"C:/Users/Student/Downloads/javafx-sdk-21/lib/*.jar"
```
Use forward slashes in this JSON value. Keep the other settings. This tells VS Code where the libraries are for compiling your code.

## 4. Run
1. Save your files.
2. Press Ctrl+Shift+D.
3. Select **Run Honors JavaFX**.
4. Click the green Run arrow.
5. When prompted, paste the same SDK **lib folder path**, without /*.jar and without quotation marks.
6. If a numbered application menu appears, click the terminal, type the desired number, and press Enter.

For the example above, the run prompt receives:
```text
C:/Users/Student/Downloads/javafx-sdk-21/lib
```
The path in settings is for compilation; the prompt is for running. Both must use the same SDK. You do not edit a Java class name in either JSON file.

Test the supplied window by entering a name and pressing its button. Close it before launching again.

## 5. Write your application
Put your Java source in the project root alongside HonorsLauncher.java. Use no package declaration in this beginner layout. Your application must extend javafx.application.Application and implement start(Stage stage).

If you rename the source file, rename its public class to match. For example, GradeTracker.java contains public class GradeTracker. The launcher finds it automatically after compilation.

Keep the installation test if you want. The launcher shows a menu when both it and your project are present. Ordinary helper classes do not appear in that menu.

## If the VM reports JAVA_HOME
This manual setup avoids the Maven wizard that produced the original JAVA_HOME error. It still needs a full JDK.

Open **Java: Configure Java Runtime** in the Command Palette to select an installed project JDK. If necessary, add java.configuration.runtimes in VS Code User Settings using the actual JDK root path. Do not put the JavaFX SDK path there.

If your VM does not have a usable JDK or restricts user settings/executable access, ask IT. Do not change protected system settings or assume a network drive installation is available.

## Common errors
| Error | What to check |
|---|---|
| JavaFX imports cannot be resolved | settings.json must point to the extracted lib/*.jar; save and allow Java to reload |
| JavaFX runtime components missing | Select Run Honors JavaFX rather than a different Run Java configuration |
| Module javafx.controls not found | Paste the lib directory, not a ZIP, bin directory, or individual JAR |
| Main class settings or launch not found | Use the supplied HonorsLauncher configuration, not a current-file configuration |
| No Application found | Fix compilation errors; keep your source in the root with no package declaration |
| Unsupported class version | Select a JDK compatible with the SDK; use the approved matching baseline |
| Several applications found | Choose a number in the integrated terminal |
| Java extension cannot start | IT may need to configure the Java language server's own supported tooling JDK |

After fixing library settings, **Java: Clean Java Language Server Workspace** can refresh stale errors.

The source and configuration have been reviewed, but the professor must verify the GUI on the actual college VM.

References:
- https://openjfx.io/openjfx-docs/
- https://code.visualstudio.com/docs/java/java-project

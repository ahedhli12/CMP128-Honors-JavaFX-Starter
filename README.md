# CMP 128 Honors JavaFX Starter

Prepared for the CMP 128 Honors Option class. Follow your course professor's project and submission requirements. It includes a working installation test and an automatic application launcher.

## Setup
1. Create your own copy of this repository, clone it, and open the whole folder in VS Code.
2. Use an installed full JDK and Microsoft's **Extension Pack for Java**. Ask IT if these are unavailable in the VM.
3. If JavaFX is not already supplied, download the **JavaFX SDK** for your operating system and architecture from [Gluon](https://gluonhq.com/products/javafx/). Use a version compatible with your JDK; JDK 21 and JavaFX SDK 21 are the recommended baseline here.
4. **Extract the ZIP.** Open the extracted **lib** folder and confirm it contains `javafx.controls.jar`.
5. In `.vscode/settings.json`, replace the example library path with your real path, keeping `/*.jar` at the end:
   ```json
   "java.project.referencedLibraries": [
     "C:/Users/Student/Downloads/javafx-sdk-21/lib/*.jar"
   ]
   ```
6. In `.vscode/launch.json`, replace the example module path with that same **lib folder**, without `/*.jar`:
   ```json
   "vmArgs": "--module-path \"C:/Users/Student/Downloads/javafx-sdk-21/lib\" --add-modules javafx.controls"
   ```
   Keep the escaped quotes shown in the actual launch.json file.
7. Save both files. Open **Run and Debug** with **Ctrl+Shift+D**, select **Run Honors JavaFX**, and click Run. **There is no SDK-path popup.**

Use your own computer's path in both files, not the instructor's username. Forward slashes are simplest in JSON. The two paths must refer to the same extracted SDK.

No Maven or project-generation wizard is needed. This manual SDK setup replaces the Maven setup section of the original handout. An installed JDK is still required. Select it with **Java: Configure Java Runtime**; ask IT if the VM prevents this.

## Run your own project
Keep `.java` files in the project root, with no package declaration. Your public class name must match its filename and your GUI class must extend `Application`.

**Do not change Java class names in launch.json or settings.json.** HonorsLauncher finds compiled JavaFX applications automatically. With several applications, choose a number in the terminal. Keep HonorsLauncher.java unchanged.

First run JavaFXInstallTest: enter a name, click the button, and confirm the greeting and click count. Close the window before running again.



References: [OpenJFX](https://openjfx.io/openjfx-docs/) · [VS Code variables](https://code.visualstudio.com/docs/reference/variables-reference)

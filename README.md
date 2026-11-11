# CMP 128 Honors JavaFX Starter

Use this starter for your professor's Honors GUI project. It includes a working installation test and an automatic application launcher.

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
6. Save. Open **Run and Debug** with **Ctrl+Shift+D**, select **Run Honors JavaFX**, and click Run.
7. When prompted, paste that same **lib folder path**, without quotation marks or `/*.jar`:
   ```text
   C:/Users/Student/Downloads/javafx-sdk-21/lib
   ```

No Maven or project-generation wizard is needed. This manual SDK setup replaces the Maven setup section of the original handout. An installed JDK is still required. Select it with **Java: Configure Java Runtime**; ask IT if the VM prevents this.

## Run your own project
Keep `.java` files in the project root, with no package declaration. Your public class name must match its filename and your GUI class must extend `Application`.

**Do not change Java class names in launch.json or settings.json.** HonorsLauncher finds compiled JavaFX applications automatically. With several applications, choose a number in the terminal. Keep HonorsLauncher.java unchanged.

First run JavaFXInstallTest: enter a name, click the button, and confirm the greeting and click count. Close the window before running again.

## Honors project checklist
Follow your professor's instructions:
- Get topic approval and meet approximately every two weeks.
- Create input, output, and interaction with JavaFX.
- Use an array or ArrayList, decisions, loops, and purposeful methods.
- Add a student-designed class/object if appropriate and approved.
- Include comments and helpful validation messages.
- Document at least five tests, including invalid input and a boundary case.
- Complete AI-Use-Report.md and prepare your Student Showcase presentation.

## Student project notes
Complete these here before submission:
- Name and approved project title:
- Purpose and intended users:
- Features and stored data:
- Progress meeting dates and feedback:
- Technical challenge and solution:
- Known limitations:

| Test | Input or steps | Expected result | Actual result |
|---|---|---|---|
| Normal | TODO | TODO | TODO |
| Normal | TODO | TODO | TODO |
| Invalid | TODO | TODO | TODO |
| Boundary | TODO | TODO | TODO |
| Additional | TODO | TODO | TODO |

Submit your source, this completed README, AI report, test screenshot/evidence, and showcase materials through your professor's specified method. Keep .github and .vscode; do not upload SDKs or JDKs.

## If it does not run
- **Imports unresolved:** check the `lib/*.jar` path in settings; allow Java to reload.
- **Module not found:** the run prompt needs the extracted `lib` folder, not a ZIP or bin.
- **Runtime components missing:** select **Run Honors JavaFX**, not another Run Java configuration.
- **No application found:** fix compilation errors and keep root Java files without packages.
- **Unsupported class version:** check JDK/JavaFX compatibility.
- **JAVA_HOME or missing JDK:** this setup avoids Maven, but cannot supply a missing JDK or change protected VM settings; contact IT.

The professor must verify the test window on the actual VM before distribution.

References: [OpenJFX](https://openjfx.io/openjfx-docs/) · [VS Code variables](https://code.visualstudio.com/docs/reference/variables-reference)

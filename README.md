# CMP 128 Honors JavaFX Starter

For the **CMP 128 Honors Option GUI Project**. Follow your professor's project instructions, progress meetings, and submission requirements.

## Simple setup
This version uses a downloaded JavaFX SDK, like the manual setup used in the reference lab. **No Maven project wizard or Maven installation is needed.** This replaces the Maven setup steps in the original project handout; the professor should distribute the updated setup instructions with the project.

1. Create your own repository using Use this template, or Fork.
2. Clone your copy and open its entire folder in VS Code.
3. Read [SETUP.md](SETUP.md).
4. Add your JavaFX SDK library path to .vscode/settings.json as explained there.
5. Select **Run Honors JavaFX** in Run and Debug.
6. Paste that same SDK lib folder path when prompted.
7. Run JavaFXInstallTest before starting your project.

**No Java filename needs to be entered in settings.json or launch.json.**

## Your Java files
Keep your .java files directly in this project folder. Do not add package declarations for this simple setup. A public class name must match its filename.

HonorsLauncher automatically finds compiled classes that extend Application:
- With one application, it runs that application.
- With several applications, it asks you to choose a number in the terminal.
- It ignores ordinary helper classes.

You may rename JavaFXInstallTest.java and its public class together, or write your own new application file. The launcher and configuration do not need renaming. Keep HonorsLauncher.java unchanged. This supports JavaFX Application classes in this project, not arbitrary files or packaged projects.

## Project requirements
- Obtain your professor's approval for your topic.
- Create a JavaFX interface with input, output, and user interaction.
- Store a collection in an array or ArrayList.
- Use loops and decisions to validate input and process data.
- Organize your work into purposeful methods.
- Add a student-designed class/object when appropriate and approved.
- Use clear names, comments, and helpful validation messages.
- Document at least five tests including boundary and invalid input.
- Meet with your professor approximately every two weeks.
- Prepare and present your Student Showcase materials.

## Student project description
Name:
Approved title:
Purpose and users:
Features:
Input and stored data:
How to run:
Meaningful Copilot use or statement of no use:
Known limitations:

## Before submitting
Complete PROJECT-PLAN.md, TEST-LOG.md, and AI-Use-Report.md. Submit your source, README, test evidence, and showcase materials through your professor's specified method. Keep .github and .vscode. Do not upload a JDK or JavaFX SDK.

## Instructor VM check
A usable full JDK, Java extensions, and matching JavaFX SDK are still required. If the VM lacks them or blocks execution, IT assistance is needed. The repository cannot configure protected VM settings. Verify the installation-test window on the actual VM before distributing to students.

# CMP 128 Honors JavaFX Starter

A starter for the Honors Option GUI project. Students design their own application; the included window only tests the installation.

## Start here
1. Select **Use this template → Create a new repository**, or Fork if the template option is unavailable.
2. Name your copy **LastName-FirstName-CMP128-Honors-GUI**.
3. Clone your own copy and open its root folder in VS Code.
4. Follow [SETUP.md](SETUP.md). Run the installation test before writing your project.
5. Complete [PROJECT-PLAN.md](PROJECT-PLAN.md), meet with your professor, and obtain topic approval.
6. Build your project in `src/main/java/edu/ccm`.
7. Complete the test log, AI-use reflection, README section below, and showcase materials.

## What is included
- `pom.xml`: Maven project with JavaFX 21.0.2 and Java release 21.
- `src/main/java/edu/ccm/HonorsLauncher.java`: infrastructure that launches a named JavaFX Application.
- `src/main/java/edu/ccm/JavaFXInstallTest.java`: a small working installation test.
- `.vscode`: launch configuration, Maven task, and extension recommendations.
- `.github/copilot-instructions.md`: guidance for introductory-level assistance.
- Project, test, and reflection templates.

## Run different student classes
The launch configuration always runs **edu.ccm.HonorsLauncher** and asks for the application class name. For example:
- `edu.ccm.JavaFXInstallTest` runs the installation test.
- `edu.ccm.GradeTracker` runs a student class named GradeTracker in package edu.ccm.

This supports different **compiled JavaFX Application classes within this project**. It does not run arbitrary files or infer a Java class from whichever editor tab is open. Enter the class name, not a filename or file path.

## Honors project requirements
- Obtain topic approval before implementation.
- Create a JavaFX interface for input, output, and user interaction.
- Store a collection in an array or ArrayList.
- Use decisions and loops to validate input and process data.
- Organize logic into purposeful methods.
- Use a student-designed class/object when appropriate, as agreed with the professor.
- Include clear names, comments, and helpful validation messages.
- Document at least five tests, including boundary and invalid-input cases.
- Meet with the professor approximately every two weeks.
- Prepare and present Student Showcase materials.

## Student project README
Replace these prompts after the installation test:
- Name:
- Approved project title and purpose:
- Intended users:
- Features:
- Inputs and stored data:
- Fully qualified application class name:
- Exact run steps:
- Meaningful Copilot use, or statement of no use:
- Known limitations:

## Submission
Keep the Maven project, source code, .vscode, and .github files. Submit the project, test evidence, reflection, and showcase materials through the method your professor specifies. Never commit downloaded JDKs, SDKs, or personal machine paths.

## Instructor note
This follows the attached project's Maven approach and avoids the project-generation wizard. Maven still needs a usable JDK, dependency access, and an available Maven installation. The supplied VS Code task sets JAVA_HOME for its own process; it does not change protected VM-wide settings. IT must provide an approved JDK/Maven installation if they are absent or blocked.

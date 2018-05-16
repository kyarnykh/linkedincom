Project: qaauto = Automation Quality Assurance
Course by SkillUp
Start date: 20.04.2018


Environment setup steps:
     1. Download "IntelliJ IDEA" 2018.1.1 for Windows x64
     2. Download "JDK" 10.0.1 for Windows x64
     3. Download "FifeFox" browser for Windows
     4. Install software by default
     5. Download "geckodriver" from google
     6. File "geckodriver" insert to "system32" folder (C -> Windows -> System32)
     7. Sync "IntelliJ IDEA" with "JDK"


Add source code to GitHub:
 Example 1:
     1. Create GitHub account
     2. Create New Project (Project name is the same name project on the PC) with file ".gitignore"
     3. Update new file .gitignore
     4. Download Git client for Windows x64
     5. Install Git client by default
     6. Restart IntelliJ IDEA
     7. Setting GitHub:
        Click on "File" button > Settings > Version control > setup link to project on PC
     8. Upload files and folders to GitHub on WEB via Drag and Drop
     9. Sync PC Project with Web Project:
        1. Click right on project folder
        2. Click on GitHub
        3. Commit repository
        4. Click "Commit and Push" button
        5. Click "push" button

 Example 2:
     1. Create new repository at the GIThub (Enter repository name)
     2. Copy link to repository
     3. Enable version control integration in IDE (VCS  => enable version control integration)
     4. Add link to IDE : VCS => GIT => Remotes
     5. At the IDE select VCS => "Commit..."
     6. At the "Commit Changes" window choose needed files and folders
     7. Enter commit text that describes changes
     8. Select VCS => Git => "Push"
     9. Select needed branch and press "Push" button


  Test cases for Login form:

     Positive Test Cases:
     1.
     - Correct Email
     - Correct Password
     2.
     - CORRECT EMAIL
     - Correct Password
     3.
     - Phone number
     - Correct Password
     4.
     - EMPTY SPACE Correct Email
     - Correct Password


     Negative Test Cases:
     1.
     - Without Email
     - Without Password
     2.
     - Without Email
     - Correct Password
     3.
     - Correct Email
     - Without Password
     4.
     - Incorrect Email
     - Correct Password
     5.
     - Correct Email
     - Incorrect Password
     6.
     - Correct Email
     - Incorrect Password (Small)
     7.
     - Incorrect Phone number
     - Correct Password
     8.
     - Incorrect Post Service
     - Correct Password
     9.
     - Incorrect Email with other language
     - Correct Password


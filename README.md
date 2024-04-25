#EtheriumCalcBonus2

Description
EtheriumCalcBonus2 is a Java program designed to calculate rewards from Ethereum staking over a specified period.
It prompts the user to input investment details and calculates rewards based on the staking reward rate and desired payment day.

How to Execute
Compile: Compile the Java source file EtheriumCalcBonus2.java.
javac EtheriumCalcBonus2.java

Run: Run the compiled Java program.
java EtheriumCalcBonus2
Follow Instructions: Follow the instructions prompted by the program to provide necessary inputs such as investment amount, staking reward rate, and desired payment day.
Output: The program will generate a CSV file named EtheriumCalc_v2.csv on the desktop containing the calculated reward data.

Requirements
Java Development Kit (JDK) installed on your system.

Execution Example
Welcome to the investor center.
Enter the date from which you would like to check the data (yyyy-MM-dd): 2024-04-15
How many months into the future are we checking ? 6
Please enter the amount you would like to invest: 1000
What is the staking reward rate? 5
What is your desired payment day? 15
The file has been created

Notes
Ensure that the JDK is properly configured and accessible from the command line.
The program generates a CSV file containing reward data named EtheriumCalc_v2.csv on the desktop. Ensure proper file permissions and directory access.
Input validation is implemented to handle invalid user inputs gracefully.





This program is written in Java (Eclipse) 

To compile and run your Java programs, you'll utilize the Java Development Kit (JDK) tools, specifically the Java compiler javac and the Java Virtual Machine java.
If you already have Java installed on your system, you can skip the installation step.

Download and Install JDK: Visit the official Oracle website to download and install the latest version of the Java Development Kit (JDK).
Note down the installation directory for future reference, typically something like C:\Program Files\Java\jdk-<version>\bin on Windows,
or /usr/local/jdk-<version>/bin on Unix-based systems.
Update System Environment Variables (Windows):
Press Windows key + Pause/Break to open System Properties.
Navigate to Advanced system settings.
Click on Environment Variables.
Under System variables, find PATH, and click Edit.
Add the JDK's bin directory path (e.g., C:\Program Files\Java\jdk-<version>\bin) to the beginning of the PATH variable.
Click OK to save the changes.
Verify Installation: Open a command prompt (CMD) and type javac -version. You should see the installed JDK version displayed, indicating a successful installation.


Compile the Program
You will use the javac command to convert your Java program into a form more amenable for execution on a computer.

From the Command Prompt, navigate to the directory containing your .java files, say C:\introcs\hello, by typing the cd command below.
C:\Users\username>cd c:\introcs\hello
C:\introcs\hello\>
Assuming the file, say HelloWorld.java, is in the current working directory, type the javac command in boldface below to compile it.
C:\introcs\hello\>javac HelloWorld.java
C:\introcs\hello\>
If everything went well, you should see no error messages.
Execute the Program
You will use the java command to execute your program.

From the Command Prompt, type the java command below.
C:\introcs\hello\>java HelloWorld
Hello, World
If all goes well, you should see the output of the program - Hello, World.
Input and Output
If your program gets stuck in an infinite loop, type Ctrl-c to break out.

If you are entering input from the keyboard, you can signify to your program that there is no more data by typing Ctrl-z for EOF (end of file). On some DOS systems the first line of output sent to the screen after you enter EOF will be rendered invisible by DOS. This is not a problem with your code, but rather a problem with DOS. To help you debug your program, we recommend including an extra System.out.println(); statement before what you really want to print out. If anyone knows of a better fix, please let us know!

Troubleshooting
Here are a few suggestions that might help correct any installation woes you are experiencing. If you need assistance, don't hesitate to contact a staff member.

When I type, "java -version" I get an error. Check that you edited your PATH environment variable as indicated. A missing ; or an added % is enough to screw things up. Close and re-open a command prompt. Type path at the command prompt and look for an entry that includes C:\Program Files\Java\jdk1.6.0_27\bin;. Check that the version number 1.6.0_27 matches the one you installed—Oracle updates Java periodically and you might have a more recent version. If this doesn't fix the problem, check if you have any old versions of Java on your system. If so, un-install them and re-install Java.

The command "java -version" works, but not "javac -version". Any thoughts? It's likely a path issue. Try the suggestions from the previous question. Also check that you installed the JDK properly by checking that the folder C:\Program Files\Java\jdk1.6.0_27\bin exists.

How can I check the values of my PATH variable? Type the following at the command prompt.

C:\introcs\hello\> echo %PATH%
The PATH variable should begin with C:\Program Files\Java\jdk1.6.0_27\bin; Be sure to open the command prompt after you have edited the PATH environment variable. You may also need to reboot for the environment variable change to take effect.
I can compile with javac, but I get the error message "Exception in thread "main" java.lang.NoClassDefFoundError: HelloWorld" when I try to execute it with java. First, be sure that HelloWorld.class is now in the current directory. Be sure to type java HelloWorld without a trailing .class or .java. Check that the command "java -version" works. Now try to execute with "java -cp . HelloWorld". If this works, you need to edit your classpath. (iTunes has a proclivity for changing the classpath, so if you recently upgraded iTunes, this is likely the source of the problem.)

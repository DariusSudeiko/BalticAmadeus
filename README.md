# EtheriumCalcBonus2

## Description
EtheriumCalcBonus2 is a Java program designed to calculate rewards from Ethereum staking over a specified period.
It prompts the user to input investment details and calculates rewards based on the staking reward rate and desired payment day.

## How to Execute
- **[Compile:](#compile:)** Compile the Java source file **EtheriumCalcBonus2.java** .
  
  ```javac EtheriumCalcBonus2.java```
- **[Run:](#run:)** Run the compiled Java program.
  
  ```java EtheriumCalcBonus2```
- **[Follow](#follow) [Instructions](#instructions:)** Follow the instructions prompted by the program to provide necessary inputs such as investment amount, staking reward rate, and desired payment day.
- **[Output:](#output:)** The program will generate a CSV file named **`EtheriumCalc_v2.csv`** on the desktop containing the calculated reward data.

## Requirements
Java Development Kit (JDK) installed on your system.

## Execution Example
```Welcome to the investor center.
Enter the date from which you would like to check the data (yyyy-MM-dd): 2024-04-15
How many months into the future are we checking ? 6
Please enter the amount you would like to invest: 1000
What is the staking reward rate? 5
What is your desired payment day? 15
The file has been created
```

## Notes
- Ensure that the JDK is properly configured and accessible from the command line.
- The program generates a CSV file containing reward data named EtheriumCalc_v2.csv on the desktop. Ensure proper file permissions and directory access.
- Input validation is implemented to handle invalid user inputs gracefully.
- **Note:** Before running the program, remember to switch the destination folder inside the code to the desired location where you want the output file to be saved.

## License

This project is licensed under the [MIT License](LICENSE).

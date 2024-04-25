package lt.balticAmadeus;

import java.time.LocalDate;
import java.util.Scanner;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;

public class EtheriumCalcBonus2 {

	// Method to append data to StringBuilder
	public static void appendData(StringBuilder stringBuilder, int line, LocalDate date, double investmentAmount,
			double rewardAmount, double totalRewardAmount, double stakingRewardRate) {

		DecimalFormat df = new DecimalFormat("#.######"); // Limiting to 6 decimal places

		stringBuilder.append(line - 1).append(" , ").append(date).append(" , ").append(df.format(investmentAmount))
				.append(" , ").append(df.format(rewardAmount)).append(" , ").append(df.format(totalRewardAmount))
				.append(" , ").append(stakingRewardRate * 100).append("%\n");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder stringBuilder = new StringBuilder();

		// Header for CSV file
		stringBuilder.append("Line").append(" , ").append("Reward Date").append(" , ").append("Investment Amount")
				.append(" , ").append("Reward Amount").append(" , ").append("Total Reward Amount Till that date")
				.append(" , ").append("Stacking Reward Rate").append("\n");

		System.out.print("Welcome to the investor center.\n");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String startDate;
		while (true) {
			System.out.print("Enter the date from which you would like to check the data (yyyy-MM-dd): ");
			String startDateInput = scanner.nextLine();
			// checking the date input with regex
			if (!startDateInput.matches("\\d{4}-\\d{2}-\\d{2}")) {
				System.out.println("Invalid input format. Please enter the date in yyyy-MM-dd format.");
				continue;
			}
			startDate = startDateInput;
			break;
		}
		// String startDate = e.g., "2024-04-15";
		LocalDate date = LocalDate.parse(startDate, formatter);
		LocalDate checkDate = LocalDate.parse(startDate, formatter);
		System.out.print("How many months into the future are we checking ? ");
		int months;
		while (true) {
			if (!scanner.hasNextInt()) {
				System.out.print("Invalid input. Please enter a number: ");
				scanner.next(); // Discard invalid input
				continue;
			}
			months = scanner.nextInt();
			if (months <= 0) {
				System.out.print("Invalid input. Please enter a positive number: ");
				continue;
			}
			break;
		}
		String lastDate = "2016-04-15"; // Random date, placeholder
		LocalDate endDate = LocalDate.parse(lastDate, formatter);
		endDate = date.plusMonths(months);

		int line = 1;
		double investmentAmount = 0;
		double rewardAmount = 0;
		double totalRewardAmount = 0;
		double stakingRewardRate = 0;
		int rewardPaymentDay = 0;
		boolean reinvest = true;

		// Get investment amount from user
		System.out.print("Please enter the amount you would like to invest: ");
		while (true) {
			if (!scanner.hasNextDouble()) {
				System.out.print("Invalid input. Please enter a number: ");
				scanner.next(); // Discard invalid input
				continue;
			}
			double nextDouble = scanner.nextDouble();
			if (nextDouble < 0) {
				System.out.print("Invalid input. Investment must be more than $0 ");
				continue;
			}
			investmentAmount = nextDouble;
			break;
		}

		// Get staking reward rate from user
		System.out.print("What is the staking reward rate? ");
		while (true) {
			if (!scanner.hasNextDouble()) {
				System.out.print("Invalid input. Please enter a number: ");
				scanner.next(); // Discard invalid input
				continue;
			}
			double nextDouble = scanner.nextDouble();
			if (nextDouble < 0 || nextDouble > 100) {
				System.out.print("Invalid input. Staking reward rates are from 1 to 100 ");
				continue;
			}
			stakingRewardRate = nextDouble / 100; // we divide by 100 , because RewardRate is percentages
			break;
		}
		System.out.print("What is your desired payment day? ");
		// Get reward payment day from user
		while (true) {
			if (!scanner.hasNextInt()) {
				System.out.print("Invalid input. Please enter an integer: ");
				scanner.next(); // Discard invalid input
				continue;
			}
			int nextInt = scanner.nextInt();
			if (nextInt <= 0 || nextInt > 31) {
				System.out.print("Invalid input. Please enter an integer between 1 and 31: ");
				continue;
			}
			rewardPaymentDay = nextInt;
			break;
		}

		try (FileWriter writer = new FileWriter("C:\\Users\\Darius\\Desktop\\EtheriumCalc_v2.csv")) {
			while ((!date.isAfter(endDate))) {
				if (line == 1) {
					// if this is the case there will be 1 more results than requested because , we
					// have to account for the money that was earned before the requested date
					if (date.getDayOfMonth() < rewardPaymentDay) {

						// interest=(actual/365)*(days that we are counting) * (investment)
						rewardAmount = (stakingRewardRate / 365) * ((rewardPaymentDay - date.getDayOfMonth()))
								* investmentAmount;
						totalRewardAmount += rewardAmount;
						line++;

					} else {
						if (date.getDayOfMonth() >= rewardPaymentDay) {
							// interest=(actual/365)*(days that we are counting) * (investment)
							LocalDate firstDayMonth = date.withDayOfMonth(1);
							LocalDate lastDayMonth1 = firstDayMonth.minusDays(1);
							double lastDayMonth = lastDayMonth1.getDayOfMonth();
							rewardAmount = (stakingRewardRate / 365)
									* (lastDayMonth - checkDate.getDayOfMonth() + rewardPaymentDay) * investmentAmount;
							totalRewardAmount += rewardAmount;
							line++;

						}
					}

				} else {

					if (date.getDayOfMonth() != rewardPaymentDay) {
						date = date.plusDays(1);
						continue;

					} else {
						// Re-investment check
						System.out.print("for " + date + " the rewards are " + rewardAmount + "\n"
								+ "Would you like to reinvest your earnings? (yes/no): ");
						while (true) {
							String reinvestChoice = scanner.next().toLowerCase(); // Convert input to lower-case for
																					// case-insensitive comparison
							switch (reinvestChoice) {
							case "yes":
								reinvest = true;
								break;
							case "no":
								reinvest = false;
								break;
							default:
								System.out.print("Invalid input. Please enter 'yes' or 'no': ");
								continue;
							}
							break;
						}
						// printing the first month with unaffected info
						appendData(stringBuilder, line, date, investmentAmount, rewardAmount, totalRewardAmount,
								stakingRewardRate);
						// Several variables whose purpose is to find the date of last month , so we can
						// more accurately calculate the reward
						LocalDate currentDate = LocalDate.now();
						LocalDate firstDayOfCurrentMonth = currentDate.withDayOfMonth(1);
						LocalDate lastDayOfLastMonth = firstDayOfCurrentMonth.minusDays(1);
						int dayOfLastMonth = lastDayOfLastMonth.getDayOfMonth();

						// interest=(actual/365)*(days that we are counting) * (investment)
						rewardAmount = (stakingRewardRate / 365) * dayOfLastMonth * investmentAmount;
						totalRewardAmount += rewardAmount;
						if (reinvest) {
							investmentAmount += rewardAmount;
						}
						date = date.plusDays(1);
						line++;
					}
				}
			}
			// Write data to file
			writer.write(stringBuilder.toString());
			System.out.println("The file has been created");
			scanner.close();
		} catch (Exception e) {
			System.out.println("An error occurred.");
		}
	}
}
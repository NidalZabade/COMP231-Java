//Nidal Zabade-1200153

import java.util.*;

public class Hospital {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);// Scanner to read values
		System.out.println("Enter the number of days that a patient has entered the hospital");// Ask a user to enter
																								// the number of days
																								// that a patient has
																								// entered the hospital
		double numberOfDays = sc.nextDouble();
		double[][] temperature = new double[(int) numberOfDays][];
		for (int i = 0; i < temperature.length; i++) {
			System.out.println(
					"Enter the number of times that nurse read the temperature of the patient in Celsius in day "
							+ (i + 1));// Ask the user to enter the number of times that nurse read the temperature of
										// the patient in Celsius
			double timeOfreading = sc.nextDouble();
			temperature[i] = new double[(int) timeOfreading];
			for (int j = 0; j < temperature[i].length; j++) {
				System.out.println("Enter the temperature that was read by the nurse");// Ask the user to enter the
																						// temperature that was read by
																						// the nurse and store each
																						// temperature in the array
				double t = sc.nextDouble();
				// loop to make sure that every temperature is valid
				while ((t < 30) || (t > 45)) {
					System.out.println("Error, Enter a corect tempreture");
					t = sc.nextDouble();
				}
				temperature[i][j] = t;
			}
		}
		// Calling method (Summary) to calculate the average, maximum temperature and
		// minimum temperature
		double[] summary = Summary(temperature);
		// Print the result on screen
		System.out.printf("The Avarage is: %.2f\nThe Maximum is: %.2f\nTHe Minimum is: %.2f\n", summary[0], summary[1],
				summary[2]);
		// Calling method (countbelowAboveAvarage) to count temperature that above and
		// below average
		int[] belowAndAbove = countbelowAboveAvarage(temperature, summary[0]);
		System.out.printf("Number of reading Below average is %d\nNumber of reading Above average is %d\n",
				belowAndAbove[0], belowAndAbove[1]);
		// New array to store the new sorted array
		double[][] AfterSorting = new double[temperature.length][];
		// Calling method (sortArray) that will sort the temperatures (per day) in
		// ascending order during all days
		AfterSorting = sortArray(temperature);
		// Calling method to print the sorted array on screen
		printArray(AfterSorting);
		// Using method that will return yes (he/she can leave) or no (he/she can’t
		// leave)
		if (leaveHospital(AfterSorting) == true) 
			System.out.println("Yes, you can leave");
		else
			System.out.println("No, you can't leave");
	}

	// A method to calculate the average, maximum temperature and minimum
	// temperature
	public static double[] Summary(double[][] temp) {
		double max = 0, sum = 0, avg, min;
		int count = 0;
		// Loop to calculate the maximum
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				if (temp[i][j] > max) {
					max = temp[i][j];
				}
			}
		}
		min = temp[0][0];
		// Loop to calculate the minimum
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				if (temp[i][j] < min) {
					min = temp[i][j];
				}

			}
		}
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				sum += temp[i][j];
				count++;
			}
		}
		// The Average
		avg = sum / count;
		double[] cal = { avg, max, min };
		return cal;
	}

	// A method to count temperature that above and below average
	public static int[] countbelowAboveAvarage(double[][] temp, double avg) {
		int above = 0, below = 0;
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				if (temp[i][j] > avg) {
					above++;
				} else {
					below++;
				}
			}
		}
		int[] count = { below, above };
		return count;
	}

	// Sorting method that will sort the temperatures (per day) in ascending order
	// during all days
	public static double[][] sortArray(double[][] temperature) {
		double temp;
		for (int i = 0; i < temperature.length; i++) {
			for (int j = 0; j < temperature[i].length; j++) {
				for (int k = 0; k < temperature[i].length - j - 1; k++) {
					if (temperature[i][k] > temperature[i][k + 1]) {
						temp = temperature[i][k];
						temperature[i][k] = temperature[i][k + 1];
						temperature[i][k + 1] = temp;
					}
				}
			}

		}
		return temperature;
	}

	// Method to print the sorted array on screen
	public static void printArray(double[][] sortedArray) {
		System.out.println("After Sort array:-");
		System.out.printf("Number of Reading\tTemperatures\n");
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.printf("%d\t\t\t", sortedArray[i].length);
			for (int j = 0; j < sortedArray[i].length; j++) {
				System.out.printf("%.2f  ", sortedArray[i][j]);
			}
			System.out.printf("\n");
		}
	}

	// A method that will return yes, he/she can leave or no, he/she can’t leave
	public static boolean leaveHospital(double[][] AfterSorting) {
		double avg;
		avg = (((AfterSorting[AfterSorting.length - 1][AfterSorting[AfterSorting.length - 1].length - 1])
				+ (AfterSorting[AfterSorting.length - 1][AfterSorting[AfterSorting.length - 1].length - 2]))
				+ ((AfterSorting[AfterSorting.length - 2][AfterSorting[AfterSorting.length - 2].length - 1])
						+ (AfterSorting[AfterSorting.length - 2][AfterSorting[AfterSorting.length - 2].length - 2])))/ 4;
		if (avg >= 35.5 && avg <= 36.5) {
			System.out.printf("Your avarage is Stabel and it's: %.2f\n", avg);
			return true;
		}
		else {
			System.out.printf("Your avarage is not Stabel and it's: %.2f\n", avg);
			return false;
		}
	}
}
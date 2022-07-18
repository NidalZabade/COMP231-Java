///Name: Nidal Zabade      Student Id: 1200153
//Instructor: Nael Qaraeen    lecture section:4    lab section:8
import java.util.*;

public class TestDrive {

	public static void main(String[] args) {
		
		//Define number of classes and student
		int numberOfClasses, numberOfStudents;
		
		//Scanner to Scan the inputs
		Scanner sc = new Scanner(System.in);
		
		//Ask user to enter number of classes
		System.out.println("Enter Number of classes");
		
		//Scan and save
		numberOfClasses = sc.nextInt();
		
		//Define Course which we put Student info in it
		Student[][] Course = new Student[numberOfClasses][];
		
		//Define Average to later use(calculate the average)
		double[] Avg = new double[Course.length];
		
		//For loop to take rows as number of classes then Entering number of Students in each class
		for (int i = 0; i < numberOfClasses; i++) {
			
			//Ask User to enter the number of student in the class
			System.out.println("Enter number of Students in class #" + (i + 1));
			
			//scan it and save
			numberOfStudents = sc.nextInt();
			while (numberOfStudents < 1 || numberOfStudents > 100) {
				System.out.println("The class must contain 1-100 students try again");
				numberOfStudents = sc.nextInt();
			}
			Course[i] = new Student[numberOfStudents];
			
			//Ask user to enter the info in term of the construct that i created in Student class
			System.out.println("Student info(First name, Last name, Id, Birth date)");
			
			//save each student info as an index of array of strings (called String)
			String[] string = new String[numberOfStudents];
			sc.nextLine();
			
			//For loop to split each student info and enter them on the construct as the prototype of the input
			for (int j = 0; j < string.length; j++) {
				string[j] = sc.nextLine();
				
				//save as upper case for strings
				string[j] = string[j].toUpperCase();
				
				//splitting the info in index on term of spaces for strings and / or - for date
				String[] r = string[j].split("[ -/]");
				Student t = new Student(r[0], r[1], Integer.parseInt(r[2]),
						new Date(Integer.parseInt(r[5]) - 1900, Integer.parseInt(r[4]) - 1, Integer.parseInt(r[3])));
				
				//save the info
				Course[i][j] = t;

			}
		}
		//Sorting:-
		
		//define 2 characters that we want to start sorting on term of
		char var = 'A';
		char var1 = 'A';
		
		// 3 For loops that start by taking the first student last name and compare it with all Students last name 
		for (int c = 0; c < Course.length; c++) {
			for (int v = 0; v < Course[c].length - 1; v++) {
				for (int z = 0; z < Course[c].length - 1; z++) {
					
					//integer s represent the return of the method that i use to sort the object on Student class
					int s;
					
					//depend on s value that the method SortSting return we swap the object
					s = SortString(Course[c][z].getLastname(), Course[c][z + 1].getLastname(), var);
					
					//if s equal 0 we compare in term of next letter
					while (s == 0) {
						s = SortString(Course[c][z].getLastname(), Course[c][z + 1].getLastname(), var1++);
					}
					var1 = 'A';
					
					//if s equal 1 we swap the two Strings
					if (s == 1) {
						Student temp = Course[c][z];
						Course[c][z] = Course[c][z + 1];
						Course[c][z + 1] = temp;
					}
				}
			}
		}
		// Calculate the Average:-
		
		//For loops to Ask user to enter each Student grade separately
		for (int c = 0; c < Course.length; c++) {
			System.out.printf("Enter grade for Students in course #%d\n", (c + 1));
			for (int v = 0; v < Course[c].length; v++) {
				System.out.println(Course[c][v].getFirsname() + " " + Course[c][v].getLastname() + ":");
				int gd = sc.nextInt();
		
				//check if the grade that user entered is in range and valid
				while (gd < 0 || gd > 99) {
					System.out.println("invalid grade try again");
					gd = sc.nextInt();
				}
				
				//save the grade in Student class by using setter
				Course[c][v].setGrade(gd);
			}
			
			//save grades in separate array and use it later to calculate the average
			int sum[][]= new int[Course.length][];
			for (int r = 0; r < Course.length; r++) {
				sum[r]=new int[Course[r].length];
				for (int x = 0; x < Course[r].length; x++) {
					sum[r][x]+= Course[r][x].getGrade();
				}
			}
			//calling method to calculate the average
			Avg= Average(sum);

		}
		//Generate the Email
		String email;
		
		//for loop to read separately
		for (int g = 0; g < Course.length; g++) {
			for (int u = 0; u < Course[g].length; u++) {
				
				/*Generate the email by getting the first letter of the first name connect
				  the last name to i and the the part(@ritag.birziet.edu), get the first and last name form 
				  the Student class by getter*/
				email = (Course[g][u].getFirsname()).charAt(0) + Course[g][u].getLastname().toLowerCase()
						+ "@ritag.birziet.edu";
				
				//use a setter to save the email
				Course[g][u].setEmail(email);
			}
		}
		//printing the output:-
		for (int f = 0; f < Course.length; f++) {
			System.out.println("Class #" + (f + 1) + " ordering");
			//printing the first name, last name, email, and grade in term of the new order
			for (int b = 0; b < Course[f].length; b++) {
				System.out.println(Course[f][b].getFirsname() + " " + Course[f][b].getLastname() + " , "
						+ Course[f][b].getEmail() + " , " + Course[f][b].getGrade());
			}
			//print the average of each class after printing the info
			System.out.println("AVG in Class #" + (f + 1) + ":  " + Avg[f] + "%");
		}

	}
	//Sorting method called SortString that take 2 Strings and the letter that we want to compare in term of
	public static int SortString(String string, String string2, char c) {
		
		//array store the number of latter that we search in each String
		int[] sort2 = new int[2];
		String[] s2 = new String[2];

		s2[0] = string;
		s2[1] = string2;
		
		//counting letters in each String and save in array sort2
		int count = 0;
		for (int j = 0; j < s2.length; j++) {
			count = 0;
			//check if the string has that character or not 
			char ch[] = s2[j].toCharArray();
			for (int k = 0; k < ch.length; k++) {
				if (ch[k] == c) {
					count++;
				}
			}
			sort2[j] = count;
		}
		//return depend of number of letter:-
		
		//if it returns 1 it will swap the object
		if (sort2[0] < sort2[1])
			return 1;
		
		//if it returns 0 he go back to main and call the method again but with the next letter
		else if (sort2[0] == sort2[1])
			return 0;
		
		//if it returns -1 then the number of letter in first String is greater than the Second String and do not swap the object
		else
			return -1;
	}
	//method to calculate the average
	public static double[] Average(int Sum[][]) {
		int sum=0, counter=0;
		double Avg[]= new double[Sum.length];
		for(int i=0; i<Sum.length; i++) {
			for(int j=0; j<Sum[i].length; j++) {
				sum+= Sum[i][j];
				counter++;
			}
			Avg[i]=(double)sum/counter;
			sum=0;
			counter=0;
		}
		return Avg;
	}

}

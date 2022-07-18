//Nidal Zabade 1200153
import java.util.*;

//define all information that we need about student and make it private
public class Student {
	private String firsname;
	private String lastname;
	private int id;
	private Date dateOfBirth;
	private int grade;
	private String email;
	private double Avg;
	
	//empty constructor
	public Student() {
		super();

	}
	//the main constructor for input
	public Student(String firsname, String lastname, int id, Date dateOfBirth) {
		super();
		this.firsname = firsname;
		this.lastname = lastname;
		this.id = id;
		this.dateOfBirth = dateOfBirth;
	}
	//Getters and setters for all prototypes
	public String getFirsname() {
		return firsname;
	}

	public void setFirsname(String firsname) {
		this.firsname = firsname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getAvg() {
		return Avg;
	}

	public void setAvg(double avg) {
		Avg = avg;
	}

}

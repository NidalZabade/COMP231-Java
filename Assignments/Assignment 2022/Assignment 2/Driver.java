import java.util.Scanner;

public class Driver {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter number of teachers:-");
        int numOfTeachers = sc.nextInt();
        Teacher[] teachers = new Teacher[numOfTeachers];
        sc.nextLine();
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher = readTeacher(teachers);
            if (teacher == null) {
                i--;
                continue;
            } else {
                teachers[i] = teacher;
            }
            System.out.println("Enter number of courses taught");
            int numOfCourses = sc.nextInt();
            Course[] coursesTaught = new Course[numOfCourses];
            System.out.println("Enter Course names and ids");
            for (int j = 0; j < coursesTaught.length; j++) {
                Course course = reaCourses(coursesTaught);
                if (course == null) {
                    j--;
                    continue;
                } else {
                    coursesTaught[j] = course;
                }
            }
            teachers[i].setCoursesTaught(coursesTaught);
        }
        while (true) {
            menu(teachers);
        }

    }

    public static void menu(Teacher[] teachers) {
        System.out.print(
                "1- Print teacher Info \n2- Display all teachers names and total Salaries \n3- Change basic salary for a teacher \n4- Display sum of total salaries for all teachers \n5- Exit\nEnter your choice of tasks ( 1-5 ):");
        System.out.println("Enter command");
        String command = sc.next();
        int id;
        switch (command) {
            case "1":
                // Print Teacher Information based on id
                System.out.println("Enter teacher's id");
                id = sc.nextInt();
                for (int i = 0; i < teachers.length; i++) {
                    if (isExistTeacher(teachers, id)) {
                        if (teachers[i].getId() == id) {
                            teachers[i].printInfo();
                        }
                    } else {
                        System.out.println("Teacher doesn't exist");
                    }
                }
                break;
            case "2":
                // Display teachers’ total salaries
                for (int i = 0; i < teachers.length; i++) {
                    System.out.println(teachers[i].getName() + " "
                            + (teachers[i].getBasicSalary()
                                    + teachers[i].calculateExtraPayment(teachers[i].getExtraPaymentRate())));
                }
                break;
            case "3":
                // Change basicSalary for a teacher
                System.out.println("Enter teacher's id");
                id = sc.nextInt();
                for (int i = 0; i < teachers.length; i++) {
                    if (isExistTeacher(teachers, id)) {
                        if (teachers[i].getId() == id) {
                            System.out.println("Enter new basic salary");
                            teachers[i].setBasicSalary(sc.nextDouble());
                        }
                    } else {
                        System.out.println("Teacher doesn't exist");
                    }

                }
                break;
            case "4":
                // Display sum of Total Salaries
                double sum = 0;
                for (int i = 0; i < teachers.length; i++) {
                    sum += teachers[i].getBasicSalary() + teachers[i].getExtraPaymentRate();
                }
                System.out.println(sum);
                break;
            case "5":
                // 5- Exit
                System.exit(0);
                break;
            default:
                System.out.println("Wrong command");

                break;
        }
    }

    public static Teacher readTeacher(Teacher[] teachers) {
        System.out.print("Enter teacher's name, id, basic salary, and extra payment rate\n");
        String[] splitInfoStrings = { sc.next(), sc.next(), sc.next(), sc.next() };
        if (isExistTeacher(teachers, Integer.parseInt(splitInfoStrings[1]))) {
            System.out.println("\nThere's such teacher with same id try again\n");
            return null;
        }

        return new Teacher(splitInfoStrings[0], Integer.parseInt(splitInfoStrings[1]),
                Double.parseDouble(splitInfoStrings[2]), Double.parseDouble(splitInfoStrings[3]), null);
    }

    public static Course reaCourses(Course[] coursesTaught) {
        String courseName = sc.next();
        int courseId = sc.nextInt();
        int level = courseId / (int) Math.pow(10, (int) Math.log10(courseId));
        while (level < 1 || level > 4) {
            System.out.println("Course level must be between 1 and 4");
            courseName = sc.next();
            courseId = sc.nextInt();
            level = courseId / (int) Math.pow(10, (int) Math.log10(courseId));

        }
        while (courseName.length() != 4) {
            System.out.println("Course name must be 4 characters");
            courseName = sc.next();
            courseId = sc.nextInt();
        }
        if (isExistCourse(coursesTaught, courseName + "" + courseId)) {
            System.out
                    .println("\nThere's such course with same name and id " + (courseName + "" + courseId)
                            + "try again");
            return null;
        }
        return new Course(courseName, courseId);

    }

    public static boolean isExistTeacher(Teacher[] teachers, int id) {
        boolean flag = false;
        if (teachers[0] == null)
            return false;
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null)
                return false;
            if (teachers[i].getId() == id) {
                flag = true;
                break;
            }
        }
        return flag;

    }

    public static boolean isExistCourse(Course[] courses, String CourseId) {
        boolean flag = false;
        if (courses[0] == null)
            return false;
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == null)
                return false;
            String id = courses[i].getCourseName().concat("" + (courses[i].getCourseId()));
            if (id.equals(CourseId)) {
                flag = true;
                break;
            }
        }
        return flag;

    }

}

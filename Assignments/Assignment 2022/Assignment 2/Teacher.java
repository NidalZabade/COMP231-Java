public class Teacher {
    private String name;
    private int id;
    private double basicSalary;
    private double extraPaymentRate;
    private Course[] coursesTaught;

    public Teacher() {
    }

    public Teacher(String name, int id, double basicSalary, double extraPaymentRate, Course[] coursesTaught) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
        this.extraPaymentRate = extraPaymentRate;
        this.coursesTaught = coursesTaught;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getExtraPaymentRate() {
        return extraPaymentRate;
    }

    public void setExtraPaymentRate(double extraPaymentRate) {
        this.extraPaymentRate = extraPaymentRate;
    }

    public Course[] getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(Course[] coursesTaught) {
        this.coursesTaught = coursesTaught;
    }

    public int countCourseLevel(int level) {
        int count = 0;
        for (int i = 0; i < coursesTaught.length; i++) {
            if (coursesTaught[i].getCourseId()
                    / (int) Math.pow(10, (int) Math.log10(coursesTaught[i].getCourseId())) == level) {
                count++;
            }
        }
        return count;

    }

    public double calculateExtraPayment(double extraPaymentRate) {
        double extraPayment = 0;
        for (int i = 1; i <= 4; i++) {
            extraPayment += (countCourseLevel(i) * i * extraPaymentRate);
        }
        return extraPayment;

    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Id: " + id);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Extra Payment Rate: " + extraPaymentRate);
        System.out.println("Courses Taught: ");
        for (int i = 0; i < coursesTaught.length; i++) {
            coursesTaught[i].printInfo();
        }
    }

}

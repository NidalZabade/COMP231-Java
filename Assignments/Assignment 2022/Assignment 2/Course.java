class Course {
    private String CourseName;
    private int CourseId;

    public Course() {
    }

    public Course(String courseName, int courseId) {
        CourseName = courseName;
        CourseId = courseId;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int courseId) {
        CourseId = courseId;
    }

    public void printInfo() {
        System.out.println(CourseName + CourseId);

    }

}
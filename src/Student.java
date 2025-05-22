/**
 * Student class, detailing real-world information related to a person in school
 */
public class Student {

    // Fields
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int academicYear;

    // Constructors
    public Student() {
        // null student declaration
    }
    public Student(int id, String firstName, String lastName, String email, int academicYear) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.academicYear = academicYear;
    }

    // Methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", academicYear=" + academicYear +
                '}';
    }

    public int compareStudent(Student o) {
        if (this.id < o.id) {
            return -1;
        }
        return 1;
    }

}

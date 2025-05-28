import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Arrays;
/**
 * Student Generator class, handles generating random students for a given input size
 */
public class StudentGenerator {

    // Fields
    private Student[] students;
    private int size;
    private List<String> firstNameList;
    private List<String> lastNameList;
    private List<Integer> usedIds;
    private Random random;

    // Constructor(s)
    public StudentGenerator(int size) {
        this(size, new Random());
    }

    public StudentGenerator(int size, Random random) {
        this.random = random;
        students = new Student[size];
        initLists();
        generateStudents(size);
    }

    // Methods
    private void initLists() {
        firstNameList = Arrays.asList("Alice", "Bob", "Chris", "David", "Eli", "Frank", "Gerald", "Hughie", "Issac",
                "Jack", "Kristen", "Lauren", "Michael", "Nathan", "Ozzy", "Penelope", "Quinn", "Riley", "Stephanie",
                "Tyler", "Uaine", "Veronica", "Wyatt", "Xander", "Yusuf", "Zack");
        lastNameList = Arrays.asList("Anderson", "Brown", "Clark", "Davis", "Edwards", "Foster", "Garcia", "Hernandez",
                "Ingram", "Johnson", "King", "Lee", "Murdock", "Nelson", "O'Connor", "Perez", "Quinn", "Reed",
                "Smith", "Taylor", "Underwood", "Vasquez", "Williams", "Xander", "Young", "Zhang");
        usedIds = new ArrayList<>();

    }

    public Student generateStudent() {
        String firstName = firstNameList.get(random.nextInt(firstNameList.size()));
        String lastName = lastNameList.get(random.nextInt(lastNameList.size()));
        int id = random.nextInt(10000000, 100000000);
        while (usedIds.contains(id)) {
            id = random.nextInt(10000000, 100000000);
        }
        usedIds.add(id);

        String email = firstName.charAt(0) + lastName + random.nextInt(0, 1000) +
                "@school.edu";
        int academicYear = random.nextInt(1, 5);
        return new Student(id, firstName, lastName, email, academicYear);
    }

    public void generateStudents(int size) {
        int counter = 0;
        while (counter < size) {
            students[counter] = generateStudent();
            counter++;
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < students.length; i++) {
            Student student = getStudent(i);
            builder.append(student.toString());
            if (i + 1 != students.length) {
                builder.append("; ");
            }
        }
        return builder.toString();
    }

    public Student getStudent(int index) {
        return students[index];
    }

    public Student[] getStudents() {
        return students;
    }
}

/**
 * Class containing multiple sorting algorithms to efficiently sort Student dataset as desired
 */
public class Sort {

    // Fields
    private Student[] students;
    private int comparisons;
    private int swaps;

    // Constructor(s)
    public Sort(Student[] students) {
        this.students = students;
        comparisons = 0;
        swaps = 0;
    }

    // Methods
    public void insertionSort() {
        for (int i = 1; i < students.length; i++) {
            for (int j = i; j > 0; j--) {
                comparisons++;
                if (students[j - 1].compareStudent(students[j]) == 1) {
                    // swap
                    Student temp = students[j];
                    students[j] = students[j - 1];
                    students[j - 1] = temp;
                    swaps++;
                }
            }
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 1; j < students.length - i; j++) {
                comparisons++;
                if (students[j - 1].compareStudent(students[j]) == 1) {
                    // swap
                    Student temp = students[j];
                    students[j] = students[j - 1];
                    students[j - 1] = temp;
                    swaps++;
                }
            }
        }
    }

    public void selectionSort() {
        for (int i = 0; i < students.length - 1; i++) {
            int biggestIndex = 0;
            int j;
            for (j = 1; j < students.length - i; j++) {
                if (students[j].getId() > students[biggestIndex].getId()) {
                    biggestIndex = j;
                }
            }
            // swap
            Student temp = students[j - 1];
            students[j - 1] = students[biggestIndex];
            students[biggestIndex] = temp;
            swaps++;
        }
    }



    public String printSort() {
        StringBuilder builder = new StringBuilder();
        builder.append("Student ID list: {");
        for (Student student : students) {
            builder.append("[");
            builder.append(student.getId());
            builder.append("]");
        }
        builder.append("}");
        return builder.toString();
    }

    public boolean isSorted() {
        for (int i = 1; i < students.length; i++) {
            if (students[i - 1].compareStudent(students[i]) == 1) {
                return false;
            }
        }
        return true;
    }


}

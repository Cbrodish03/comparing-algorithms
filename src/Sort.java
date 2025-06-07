/**
 * Class containing multiple sorting algorithms to efficiently sort Student dataset as desired
 */
public class Sort {

    // Fields
    private Student[] students;
    private long comparisons;
    private long swaps;
    private String type;

    // Constructor(s)
    public Sort(Student[] students) {
        this.students = students;
        comparisons = 0;
        swaps = 0;
    }

    // Methods
    public void insertionSort() {
        for (int i = 1; i < students.length; i++) {
            Student key = students[i];
            int j = i - 1;
            while (j >= 0) {
                comparisons++;
                if (students[j].compareStudent(key) > 0) {
                    swaps++;
                    students[j + 1] = students[j];
                    j--;
                }
                else {
                    break;
                }
            }
            students[j + 1] = key;
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
                comparisons++;
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

    public void mergeSort(Student[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private void merge(Student[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student[] leftArr = new Student[n1];
        Student[] rightArr = new Student[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            comparisons++;
            if (leftArr[i].compareStudent(rightArr[j]) < 0) {
                arr[k++] = leftArr[i++];
            }
            else {
                arr[k++] = rightArr[j++];
                swaps++;
            }
        }

        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        while (j < n2) {
            arr[k++] = rightArr[j++];
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

    public String printStatistics() {
        return "Algorithm type: " +
                type +
                "; comparisons=" +
                this.comparisons +
                ", swaps=" +
                this.swaps;
    }

    public void setType(String type) {
        this.type = type;
    }


}

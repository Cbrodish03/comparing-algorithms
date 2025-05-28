import org.junit.Test;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * Tests the usage of the Sort class for proper implementation
 */
public class SortTest
{
    // Fields
    private StudentGenerator generator1;

    // Methods
    @Test
    public void testInsertionSort() {
        Random random = new Random();
        random.setSeed(123456789);
        generator1 = new StudentGenerator(10, random);
        Student[] students = generator1.getStudents();
        Sort insertionSort = new Sort(students);
        String beforeSort = insertionSort.printSort();
        insertionSort.insertionSort();
        String afterSort = insertionSort.printSort();
        assertNotEquals(beforeSort, afterSort);
        assertEquals("Student ID list: {[18484866][23732807][25070891][30665920][40816705][40854664]" +
                "[51075538][82919789][91296483][94261274]}", afterSort);
        assertTrue(insertionSort.isSorted());
    }

    @Test
    public void testBubbleSort() {
        Random random = new Random();
        random.setSeed(123456789);
        generator1 = new StudentGenerator(10, random);
        Student[] students = generator1.getStudents();
        Sort bubbleSort = new Sort(students);
        String beforeSort = bubbleSort.printSort();
        bubbleSort.bubbleSort();
        String afterSort = bubbleSort.printSort();
        assertNotEquals(beforeSort, afterSort);
        assertEquals("Student ID list: {[18484866][23732807][25070891][30665920][40816705][40854664]" +
                "[51075538][82919789][91296483][94261274]}", afterSort);
        assertTrue(bubbleSort.isSorted());
    }

    @Test
    public void testSelectionSort() {
        Random random = new Random();
        random.setSeed(123456789);
        generator1 = new StudentGenerator(10, random);
        Student[] students = generator1.getStudents();
        Sort selectionSort = new Sort(students);
        String beforeSort = selectionSort.printSort();
        selectionSort.selectionSort();
        String afterSort = selectionSort.printSort();
        assertNotEquals(beforeSort, afterSort);
        assertEquals("Student ID list: {[18484866][23732807][25070891][30665920][40816705][40854664]" +
                "[51075538][82919789][91296483][94261274]}", afterSort);
        assertTrue(selectionSort.isSorted());
    }

}
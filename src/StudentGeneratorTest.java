import org.junit.Test;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * Tests the usage of the StudentGenerator class for proper implementation
 */
public class StudentGeneratorTest
{
    // Fields
    private StudentGenerator generator1;

    // Methods
    @Test
    public void testAttributes() {
        Random random = new Random();
        random.setSeed(123456789);
        generator1 = new StudentGenerator(1, random);
        assertEquals("Student{id=91296483, firstName='Penelope', lastName='Clark', " +
                "email='PClark344@school.edu', academicYear=1}", generator1.toString());
    }

    @Test
    public void testUniqueIDs() {
        int size = 1000;
        StudentGenerator generator = new StudentGenerator(size);
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Student student = generator.getStudent(i);
            assertFalse(ids.contains(student.getId()));
            ids.add(student.getId());
        }
    }
}
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Tests the usage of the Student class for proper implementation
 */
public class StudentTest
{
    // Fields
    private Student st1;    // higher number
    private Student st2;    // lower number

    // Methods
    @Test
    public void testAttributes() {
        st1 = new Student(345678901, "John", "Doe", "johndoe123@email.com", 1);
        st2 = new Student(789012345, "Jack", "Deer", "jackdeer123@email.com", 3);

        assertEquals(345678901, st1.getId());
        assertEquals("John", st1.getFirstName());
        assertEquals("Doe", st1.getLastName());
        assertEquals("johndoe123@email.com", st1.getEmail());
        assertEquals(1, st1.getAcademicYear());

        assertEquals(-1, st1.compareStudent(st2));
        assertEquals(1, st2.compareStudent(st1));
        assertEquals("Student{id=345678901, firstName='John', lastName='Doe', email='johndoe123@email.com', academicYear=1}", st1.toString());
    }
}

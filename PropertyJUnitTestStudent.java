import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Class: CMSC203
 * Assignment: 4
 * Description: Tests the Property class.
 * Name: Raiyan Islam
 */
public class PropertyJUnitTestStudent {

    private Property property;

    // Creates a new property before each test
    @BeforeEach
    public void setUp() {
        property = new Property("Sunset Villa", "Rockville",
                1500.00, "Alice Smith");
    }

    // Tests the property constructor
    @Test
    public void testPropertyConstructor() {
        assertEquals("Sunset Villa", property.getPropertyName());
        assertEquals("Rockville", property.getCity());
        assertEquals(1500.00, property.getRentAmount(), 0.001);
        assertEquals("Alice Smith", property.getOwner());
    }

    // Tests the copy constructor
    @Test
    public void testPropertyCopyConstructor() {
        Property copy = new Property(property);

        assertNotSame(property, copy);
        assertEquals(property.getPropertyName(), copy.getPropertyName());
        assertEquals(property.getRentAmount(), copy.getRentAmount(), 0.001);
    }

    // Tests the toString method
    @Test
    public void testToString() {
        String expected =
                "Sunset Villa, Rockville, Rent: $1500.00, Owner: Alice Smith";

        assertEquals(expected, property.toString());
    }
}
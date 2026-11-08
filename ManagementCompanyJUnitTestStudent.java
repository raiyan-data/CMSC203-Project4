import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import org.junit.jupiter.api.Test;

/*
 * Class: CMSC203
 * Assignment: 4
 * Description: Tests the ManagementCompany class.
 * Name: Raiyan Islam
 */
public class ManagementCompanyJUnitTestStudent {

    // Tests adding properties and calculating total rent
    @Test
    public void testAddPropertyAndTotalRent() {

        ManagementCompany company =
                new ManagementCompany("Campus Realty", "123-45-6789");

        Property first =
                new Property("Apt 1", "Rockville", 1200.0, "Bob");

        Property second =
                new Property("Apt 2", "Rockville", 1500.0, "Carol");

        assertEquals(0, company.addProperty(first));
        assertEquals(1, company.addProperty(second));

        assertEquals(2, company.getPropertyCount());

        assertEquals(2700.0, company.totalRent(), 0.001);
    }

    // Tests adding a property when the array is full
    @Test
    public void testAddPropertyWhenFull() {

        ManagementCompany company =
                new ManagementCompany("Campus Realty", "123-45-6789");

        for (int i = 0; i < ManagementCompany.MAX_PROPERTIES; i++) {
            company.addProperty(
                    new Property("P" + i, "City", 1000.0 + i, "Owner"));
        }

        assertEquals(-1, company.addProperty(
                new Property("Extra", "City", 2000.0, "Owner")));

        assertEquals(ManagementCompany.MAX_PROPERTIES,
                company.getPropertyCount());
    }

    // Tests the ManagementCompany copy constructor
    @Test
    public void testManagementCompanyCopyConstructor() {

        ManagementCompany original =
                new ManagementCompany("Campus Realty", "123-45-6789");

        original.addProperty(
                new Property("Apt 1", "Rockville", 1200.0, "Bob"));

        ManagementCompany copy = new ManagementCompany(original);

        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getTaxId(), copy.getTaxId());

        assertEquals(original.getPropertyCount(), copy.getPropertyCount());

        assertEquals(original.totalRent(), copy.totalRent(), 0.001);

        assertNotSame(original.getProperty(0), copy.getProperty(0));
    }
}
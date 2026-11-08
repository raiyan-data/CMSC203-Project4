import java.util.Locale;

/*
 * Class: CMSC203
 * Assignment: 4
 * Description: Manages multiple rental properties.
 * Name: Raiyan Islam
 * Platform/compiler: VS Code, Java 20
 */
public class ManagementCompany {

    public static final int MAX_PROPERTIES = 5;

    private String name;
    private String taxId;
    private Property[] properties;
    private int propertyCount;

    // Parameterized constructor
    public ManagementCompany(String name, String taxId) {
        this.name = name;
        this.taxId = taxId;
        properties = new Property[MAX_PROPERTIES];
        propertyCount = 0;
    }

    // Copy constructor
    public ManagementCompany(ManagementCompany other) {
        name = other.name;
        taxId = other.taxId;
        properties = new Property[MAX_PROPERTIES];
        propertyCount = other.propertyCount;

        for (int i = 0; i < propertyCount; i++) {
            if (other.properties[i] != null) {
                properties[i] = new Property(other.properties[i]);
            }
        }
    }

    // Returns company name
    public String getName() {
        return name;
    }

    // Returns tax ID
    public String getTaxId() {
        return taxId;
    }

    // Returns number of properties
    public int getPropertyCount() {
        return propertyCount;
    }

    // Returns a property at a specific index
    public Property getProperty(int index) {
        if (index < 0 || index >= propertyCount) {
            return null;
        }

        return properties[index];
    }

    // Adds a property to the array
    public int addProperty(Property property) {
        if (property == null || propertyCount >= MAX_PROPERTIES) {
            return -1;
        }

        properties[propertyCount] = new Property(property);

        propertyCount++;

        return propertyCount - 1;
    }

    // Calculates total rent
    public double totalRent() {
        double total = 0.0;

        for (int i = 0; i < propertyCount; i++) {
            total += properties[i].getRentAmount();
        }

        return total;
    }

    // Displays company and property information
    @Override
    public String toString() {
        String result = "Management Company: " + name + " (Tax ID: " + taxId + ")";
        result += "\nProperties:";

        for (int i = 0; i < propertyCount; i++) {
            result += "\n  " + i + ": " + properties[i].toString();
        }

        result += String.format(Locale.US, "\nTotal Rent: $%.2f", totalRent());

        return result;
    }
}
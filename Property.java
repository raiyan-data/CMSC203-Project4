import java.util.Locale;

/*
 * Class: CMSC203
 * Assignment: 4
 * Description: Represents one rental property.
 * Name: Raiyan Islam
 * Platform/compiler: VS Code, Java 20
 */
public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;

    // Default constructor
    public Property() {
        propertyName = "";
        city = "";
        rentAmount = 0.0;
        owner = "";
    }

    // Parameterized constructor
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
    }

    // Copy constructor
    public Property(Property other) {
        this.propertyName = other.propertyName;
        this.city = other.city;
        this.rentAmount = other.rentAmount;
        this.owner = other.owner;
    }

    // Getters and setters
    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    // Displays property information
    @Override
    public String toString() {
        return String.format(Locale.US, "%s, %s, Rent: $%.2f, Owner: %s",
                propertyName, city, rentAmount, owner);
    }
}
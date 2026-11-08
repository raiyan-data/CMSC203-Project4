import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * Class: CMSC203
 * Assignment: 4
 * Description: Provides a graphical interface for the Property Management Application.
 * Name: Raiyan Islam
 * Platform/compiler: VS Code, Java 20 with JavaFX
 */
public class PropertyManagementGUI extends Application {

    private ManagementCompany company;

    private TextField propertyNameField;
    private TextField cityField;
    private TextField rentField;
    private TextField ownerField;

    private TextArea outputArea;

    // Creates the GUI window
    @Override
    public void start(Stage stage) {

        company = new ManagementCompany("Campus Realty", "123-45-6789");

        Label title = new Label("Assignment 4: Property Manager");

        Label nameLabel = new Label("Property name:");
        Label cityLabel = new Label("City:");
        Label rentLabel = new Label("Monthly rent:");
        Label ownerLabel = new Label("Owner:");

        propertyNameField = new TextField();
        cityField = new TextField();
        rentField = new TextField();
        ownerField = new TextField();

        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setWrapText(true);

        GridPane form = new GridPane();

        form.setHgap(10);
        form.setVgap(10);

        form.add(nameLabel, 0, 0);
        form.add(propertyNameField, 1, 0);

        form.add(cityLabel, 0, 1);
        form.add(cityField, 1, 1);

        form.add(rentLabel, 0, 2);
        form.add(rentField, 1, 2);

        form.add(ownerLabel, 0, 3);
        form.add(ownerField, 1, 3);

        Button addButton = new Button("Add Property");
        Button displayButton = new Button("Display All Properties");
        Button totalButton = new Button("Show Total Rent");

        addButton.setOnAction(event -> addProperty());

        displayButton.setOnAction(event -> displayProperties());

        totalButton.setOnAction(event -> showTotalRent());

        HBox buttons = new HBox(10, addButton, displayButton, totalButton);

        VBox layout = new VBox(15, title, form, buttons, outputArea);

        layout.setPadding(new Insets(15));

        Scene scene = new Scene(layout, 600, 420);

        stage.setTitle("Property Manager");
        stage.setScene(scene);
        stage.show();
    }

    // Adds a property
    private void addProperty() {

        double rent;

        try {
            rent = Double.parseDouble(rentField.getText().trim());

            if (rent < 0) {
                outputArea.setText("Enter a non-negative rent amount.");
                return;
            }

        } catch (NumberFormatException e) {
            outputArea.setText("Enter a valid monthly rent amount.");
            return;
        }

        Property property = new Property(
                propertyNameField.getText(),
                cityField.getText(),
                rent,
                ownerField.getText()
        );

        int index = company.addProperty(property);

        if (index == -1) {

            outputArea.setText(
                    "The management company is full. Property was not added.");

        } else {

            outputArea.setText("Property added at index " + index + ".");

            propertyNameField.clear();
            cityField.clear();
            rentField.clear();
            ownerField.clear();
        }
    }

    // Displays all properties
    private void displayProperties() {
        outputArea.setText(company.toString());
    }

    // Displays total rent
    private void showTotalRent() {
        outputArea.setText(
                String.format("Total rent: $%.2f", company.totalRent()));
    }

    // Starts the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}
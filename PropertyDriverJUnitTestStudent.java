import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

/*
 * Class: CMSC203
 * Assignment: 4
 * Description: Tests the PropertyDriver class.
 * Name: Raiyan Islam
 */
public class PropertyDriverJUnitTestStudent {

    // Tests adding and displaying a property through the menu
    @Test
    public void testDriverMenuAndPropertyEntry() throws Exception {

        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;

        ByteArrayInputStream testInput = new ByteArrayInputStream(
                "1\nApt 1\nRockville\n1200\nBob\n2\n4\n"
                        .getBytes(StandardCharsets.UTF_8));

        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();

        try {
            System.setIn(testInput);
            System.setOut(new PrintStream(testOutput));

            PropertyDriver.main(new String[0]);

        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }

        String output = testOutput.toString();

        assertTrue(output.contains("Property added at index 0."));

        assertTrue(output.contains(
                "Apt 1, Rockville, Rent: $1200.00, Owner: Bob"));

        assertTrue(output.contains("Programmer: Raiyan Islam"));
    }
}
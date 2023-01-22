// DO NOT TOUCH THIS FILE!
package edu.nyu.cs;

// import junit 4 testing framework
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.contrib.java.lang.system.SystemOutRule; // system rules lib - useful for capturing system output
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
// import static org.mockito.Mockito.*;

import org.junit.ClassRule;

public class PopulationProjector_Test {

    // @Rule
    // public final TextFromStandardInputStream systemInMock =
    // emptyStandardInputStream();

    @ClassRule
    public static final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();

    String[] expecteds = {
            "Here are the projected population numbers for the next five years:",
            "- Year 2024: 335636750",
            "- Year 2025: 336972650",
            "- Year 2026: 338308550",
            "- Year 2027: 339644450",
            "- Year 2028: 340980350"
    };

    @Test
    public void testCorrectCalculations() {
        systemOutRule.enableLog(); // start capturing System.out
        String[] args = {};
        try {
            PopulationProjector.main(args);
            String output = systemOutRule.getLogWithNormalizedLineSeparator();
            for (String expected : this.expecteds) {
                boolean contained = output.contains(expected);
                assertEquals(true, contained);
            }
        } catch (Exception e) {
            assertEquals(true, e); // program crashed
        }
    }

    @Test
    public void testExactOutput() {

        systemOutRule.enableLog(); // start capturing System.out
        int i = 0;
        String[] args = {};
        try {
            PopulationProjector.main(args);
            String output = systemOutRule.getLogWithNormalizedLineSeparator();
            String[] outputLines = output.split("\n");
            for (String line : outputLines) {
                assertEquals(this.expecteds[i], line.trim());
                i++;
            }
        } catch (Exception e) {
            assertEquals(true, e); // program crashed
        }
    }

}

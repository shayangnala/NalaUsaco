import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shayangnala on 6/1/16.
 */
public class fridayTest {

    private friday unit;

    @Test
    public void testLeapYear() {
        assertTrue(unit.isLeapYear(1992));
        assertFalse(unit.isLeapYear(1990));
        assertTrue(unit.isLeapYear(2000));
        assertFalse(unit.isLeapYear(1700));
        assertFalse(unit.isLeapYear(1800));
        assertFalse(unit.isLeapYear(1900));
        assertFalse(unit.isLeapYear(2100));
    }
}
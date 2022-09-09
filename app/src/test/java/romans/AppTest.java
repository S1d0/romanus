/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package romans;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }

    @Test
    void romanNumerals() {
        assertEquals(1, RomanusTranslatus.romanusNumeral("I"));
        assertEquals(5, RomanusTranslatus.romanusNumeral("V"));
        assertEquals(10, RomanusTranslatus.romanusNumeral("X"));
        assertEquals(50, RomanusTranslatus.romanusNumeral("L"));
        assertEquals(100, RomanusTranslatus.romanusNumeral("C"));
        assertEquals(500, RomanusTranslatus.romanusNumeral("D"));
        assertEquals(1000, RomanusTranslatus.romanusNumeral("M"));

    }

    @Test
    void translateRomanusToArabic() {
        assertEquals(4, RomanusTranslatus.toArabic("IV"));
        assertEquals(20, RomanusTranslatus.toArabic("XX"));
        assertEquals(19, RomanusTranslatus.toArabic("XIX"));
        assertEquals(369, RomanusTranslatus.toArabic("CCCLXIX"));
        assertEquals(2751, RomanusTranslatus.toArabic("MMDCCLI"));
    }

    @Test
    void translateArabicToRomanus() {
        assertEquals("IV", RomanusTranslatus.toRomanus(4));
    }

}

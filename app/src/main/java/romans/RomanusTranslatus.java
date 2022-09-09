package romans;

import java.util.HashMap;
import java.util.Map;
import java.util.random.RandomGenerator.StreamableGenerator;

public class RomanusTranslatus {

    private static Map<String, Integer> romanusDict = Map.of(
        "I", 1,
        "V", 5,
        "X", 10,
        "L", 50,
        "C", 100,
        "D", 500,
        "M", 1000 
    );

    static Integer toArabic(String string) {
        var romanus = string.split("");
        var sum = 0;
        if (romanus.length == 1) {
            sum = romanusNumeral(romanus[0]);
        } else {
            for (int i = 0; i < romanus.length; i++) {
                if (i + 1 < romanus.length) {
                    sum = isPositive(romanus, i) ? add(sum, romanus[i]) : substract(sum, romanus[i]);
                } else {
                    sum = add(sum,romanus[i]);
                }
            }
        }
        return sum;
    }

    static String toRomanus(int i) {
        var rest = i;
        var romanus = "";
        while(rest > 0) {
            if(i > 1000) {
                int numberOfM = i / 1000;
                addRoman(numberOfM, "M", romanus);
            }

        }

        return romanus;
    }

    private static void addRoman(int numberOfM, String el, String romanus) {
        var i = 0;
        while (i < numberOfM) {
            romanus = romanus + el;
        }
    }

    static Integer romanusNumeral(String romanus) {
        return romanusDict.get(romanus);
    }
    
    private static boolean isPositive(String[] romanus, int i) {
        return romanusNumeral(romanus[i]) >= romanusNumeral(romanus[i + 1]);
    }

    private static Integer substract(int sum, String romanus) {
        return sum - romanusNumeral(romanus);
    }

    private static int add(int sum, String romanus) {
        return sum + romanusNumeral(romanus);
    }
}

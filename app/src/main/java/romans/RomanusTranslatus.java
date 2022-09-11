package romans;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class RomanusTranslatus {

    private static Map<String, Integer> romanusDict = Map.of(
            "I", 1,
            "V", 5,
            "X", 10,
            "L", 50,
            "C", 100,
            "D", 500,
            "M", 1000);

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
                    sum = add(sum, romanus[i]);
                }
            }
        }
        return sum;
    }

    static String toRomanus(int i) {
        Map<Integer, String> fullRomans = new LinkedHashMap<>();
        fullRomans.put(1000, "M");
        fullRomans.put(900, "CM");
        fullRomans.put(500, "D");
        fullRomans.put(400, "CD");
        fullRomans.put(100, "C");
        fullRomans.put(90, "XC");
        fullRomans.put(50, "L");
        fullRomans.put(10, "X");
        fullRomans.put(9, "IX");
        fullRomans.put(5, "V");
        fullRomans.put(4, "IV");
        fullRomans.put(1, "I");


        Deque<Integer> lastVal = new LinkedList<>();
        lastVal.add(i);
        var romanus = new StringBuilder("");
        while(lastVal.peek() > 0) {
            fullRomans.forEach((k,v) -> {
                int val = lastVal.peek();
                if(val >= k) {
                    val = lastVal.pop();
                    int numbOfOccurance = val / k; 
                    int newVal = val - numbOfOccurance * k;
                    lastVal.add(newVal);
                    addRoman(numbOfOccurance, v, romanus);
                }
            });
        }
        return romanus.toString();
    }

    private static StringBuilder addRoman(int numberOfM, String el, StringBuilder romanus) {
        var i = 0;
        while (i < numberOfM) {
            romanus.append(el);
            i = i + 1;
        }
        return romanus;
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

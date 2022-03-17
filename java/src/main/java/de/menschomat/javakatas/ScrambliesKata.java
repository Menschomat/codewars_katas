package de.menschomat.javakatas;

import java.util.HashMap;
import java.util.Map;

//https://www.codewars.com/kata/55c04b4cc56a697bb0000048/train/java
public abstract class ScrambliesKata {

    public static boolean scramble(String str1, String str2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        str1.chars().forEach(c -> countMap.put(c,
                countMap.getOrDefault(c, 0) + 1));
        for (int c : str2.toCharArray()) {
            int count = countMap.getOrDefault(c, 0) - 1;
            if (count < 0) return false;
            countMap.put(c, count);
        }
        return true;
    }

}

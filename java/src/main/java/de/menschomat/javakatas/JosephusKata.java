package de.menschomat.javakatas;

import java.util.ArrayList;
import java.util.List;

//https://www.codewars.com/kata/5550d638a99ddb113e0000a2/solutions/java
public abstract class JosephusKata {
    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        List<T> out = new ArrayList<>();
        int idx = 0;
        while (items.size() != 0) {
            idx--;
            for (int i = 0; i < k; i++) {
                idx = idx + 1 < items.size() ? idx + 1 : 0;
            }
            out.add(items.remove(idx));
        }
        return out;
    }
}

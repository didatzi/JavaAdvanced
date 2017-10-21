package Excercise.ObjectsClassesAndCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P10_CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();
        char[] char_array = str.toCharArray();
        Map<Character, Integer> charCounter = new HashMap<>();

        for (char i : char_array) {
            charCounter.put(i, charCounter.get(i) == null ? 1 : charCounter.get(i) + 1);
        }
        charCounter.keySet().stream().sorted().forEach(k ->System.out.println(k + ": "+ charCounter.get(k) + " time/s"));
    }
}

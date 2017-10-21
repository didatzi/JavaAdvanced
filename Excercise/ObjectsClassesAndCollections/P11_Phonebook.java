package Excercise.ObjectsClassesAndCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P11_Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        HashMap<String, String> result = new HashMap<>();

        while(!input.equals("search")){
            String[] tokens = input.split("-");
            if (tokens.length > 1) {
                String name = tokens[0];
                String number = tokens[1];
                result.put(name, number);
            }
            input = reader.readLine();
        }
        while(!input.equalsIgnoreCase("Stop")){
            if (!input.equals("search")){
                if (result.containsKey(input)){
                    System.out.println(input + " -> " + result.get(input));
                } else {
                    System.out.println("Contact " + input + " does not exist.");
                }
            }
            input = reader.readLine();
        }
    }
}

package Excercise.ObjectsClassesAndCollections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P12_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> collection = new HashMap<>();
        int counter = 1;
        Integer quantity = 0;
        String resource = "";
        while (true) {
            String input = scanner.nextLine();
            if ("stop".equalsIgnoreCase(input)) {
                break;
            }

            if (counter % 2 == 0) {
                quantity = Integer.parseInt(input);
                quantity += collection.get(resource);
                collection.put(resource, quantity);
            }else if (counter % 2 !=0){
                resource = input;
                if (!collection.containsKey(resource)){
                    collection.put(resource, 0);
                }
            }
            counter++;
        }
        for (String item:collection.keySet()) {
            System.out.println(item + " -> " + collection.get(item));
        }

    }
}

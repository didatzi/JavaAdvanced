package Excercise.FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class P11_PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] names = in.readLine().split("\\s+");

        LinkedHashMap<String, Integer> namesByCount = new LinkedHashMap<>();
        for (String name : names) {
            namesByCount.put(name, 1);
        }

        String command = in.readLine();
        while (!"Party!".equals(command)) {
            String[] commandArgs = command.split("\\s+");
            String removeOrDouble = commandArgs[0].toLowerCase();
            String commandType = commandArgs[1].toLowerCase();
            String argument = commandArgs[2];

            switch (commandType) {
                case "startswith":
                    for (Map.Entry<String, Integer> stringIntegerEntry : namesByCount.entrySet()) {
                        String name = stringIntegerEntry.getKey();

                        if (removeOrDouble.equals("remove")) {
                            if (name.startsWith(argument)) {
                                stringIntegerEntry.setValue(0);
                            }
                        } else {
                            if (name.startsWith(argument)) {
                                stringIntegerEntry.setValue(stringIntegerEntry.getValue() * 2);
                            }
                        }
                    }
                    break;
                case "endswith":
                    for (Map.Entry<String, Integer> stringIntegerEntry : namesByCount.entrySet()) {
                        String name = stringIntegerEntry.getKey();

                        if (removeOrDouble.equals("remove")) {
                            if (name.endsWith(argument)) {
                                stringIntegerEntry.setValue(0);
                            }
                        } else {
                            if (name.endsWith(argument)) {
                                stringIntegerEntry.setValue(stringIntegerEntry.getValue() * 2);
                            }
                        }
                    }
                    break;
                case "length":
                    int length = Integer.parseInt(argument);

                    for (Map.Entry<String, Integer> stringIntegerEntry : namesByCount.entrySet()) {
                        String name = stringIntegerEntry.getKey();

                        if (removeOrDouble.equals("remove")) {
                            if (name.length() == length) {
                                stringIntegerEntry.setValue(0);
                            }
                        } else {
                            if (name.length() == length) {
                                stringIntegerEntry.setValue(stringIntegerEntry.getValue() * 2);
                            }
                        }
                    }
                    break;
            }

            command = in.readLine();
        }

        ArrayList<String> goingToParty = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : namesByCount.entrySet()) {
            for (int i = 0; i < stringIntegerEntry.getValue(); i++) {
                goingToParty.add(stringIntegerEntry.getKey());
            }
        }

        if (goingToParty.size() == 0) {
            System.out.println("Nobody is going to the party!");
            return;
        }

        boolean isFirst = true;
        for (String goingParty : goingToParty) {
            if (isFirst) {
                System.out.print(goingParty);
                isFirst = false;
            } else {
                System.out.print(", " + goingParty);
            }
        }

        System.out.print(" are going to the party!");
    }
}

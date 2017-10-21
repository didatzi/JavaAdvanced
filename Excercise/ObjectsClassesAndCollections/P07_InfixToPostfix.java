package Excercise.ObjectsClassesAndCollections;

import java.util.*;

public class P07_InfixToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<String> queueOutput = new LinkedList<>();
        Deque<String> stackRepo = new ArrayDeque<>();
        Map<String, Integer> priorityMap = new HashMap<>();

        priorityMap.put("*", 3);
        priorityMap.put("/", 3);
        priorityMap.put("+", 2);
        priorityMap.put("-", 2);
        priorityMap.put("(", 1);
        String[] input = sc.nextLine().split(" ");

        for (String element : input) {
            if (Character.isDigit(element.charAt(0))) {
                queueOutput.offer(element);
            } else if (!Character.isDigit(element.charAt(0))) {
                switch (element) {
                    case "x":
                        queueOutput.offer(element);
                        break;

                    case "(":
                        stackRepo.push(element);
                        break;

                    case ")":
                        String popUpElement = stackRepo.pop();
                        while (!"(".equals(popUpElement)) {
                            queueOutput.offer(popUpElement);
                            popUpElement = stackRepo.pop();
                        }
                        break;
                    default:
                        while (!stackRepo.isEmpty() && priorityMap.get(stackRepo.peek()) >= priorityMap.get(element)) {
                            queueOutput.offer(stackRepo.pop());
                        }
                        stackRepo.push(element);
                        break;
                }
            }
        }

        while (!stackRepo.isEmpty()) {
            queueOutput.offer(stackRepo.pop());
        }

        while (!queueOutput.isEmpty()) {
            System.out.print(queueOutput.poll() + " ");
        }
    }
}

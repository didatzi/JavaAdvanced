package Lab.ObjectsClassesAndCollections;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P05_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> setOfGuest = new TreeSet<>();
        while (true){
            String guest = scanner.nextLine();
            if (!guest.equals("PARTY")){
                setOfGuest.add(guest);
            }else{
                break;
            }
        }
        while (true){
            String guest = scanner.nextLine();
            if (!guest.equals("END")){
                setOfGuest.remove(guest);
            }else{
                break;
            }
        }
        System.out.println(setOfGuest.size());
        for (String guest : setOfGuest) {
            System.out.println(guest);
        }
    }
}

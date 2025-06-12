import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Set<String> cardSet = new HashSet<>();
        Map<Character, Integer> suitCount = new HashMap<>();
        suitCount.put('P', 0);
        suitCount.put('K', 0);
        suitCount.put('H', 0);
        suitCount.put('T', 0);

        boolean duplicate = false;

        for (int i = 0; i < input.length(); i += 3) {
            String card = input.substring(i, i + 3);
            char suit = card.charAt(0);

            if (cardSet.contains(card)) {
                duplicate = true;
                break;
            }

            cardSet.add(card);
            suitCount.put(suit, suitCount.get(suit) + 1);
        }

        if (duplicate) {
            System.out.println("GRESKA");
        } else {
            System.out.print((13 - suitCount.get('P')) + " ");
            System.out.print((13 - suitCount.get('K')) + " ");
            System.out.print((13 - suitCount.get('H')) + " ");
            System.out.print((13 - suitCount.get('T')));
        }
    }
}

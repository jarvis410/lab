package nupl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q10 {

    private static HashMap<Character, Integer> characterCount;
    private static String input;
    private static List<String> validSubstrings;

    public static void main(String[] args) {
        input = "aabaacaba";
        populateCharacterCount();
        System.out.println("length: " + getResult());
    }

    private static void populateCharacterCount() {
        characterCount = new HashMap<>();
        for (Character c :
                input.toCharArray()) {
            if (!characterCount.containsKey(c)) {
                characterCount.put(c, 0);
            }
        }
    }

    private static int getResult() {
        validSubstrings = new ArrayList<>();
        int strLength = input.length();
        int si= 0, ei = 0;

        try {
            do {
                increaseCount(input.charAt(ei));
                while (!validSubstring() && ei + 1 < strLength) {
                    ei += 1;
                    increaseCount(input.charAt(ei));
                }
                validSubstrings.add(input.substring(si, ei + 1));

                decreaseCount(input.charAt(si));
                si += 1;
                while (validSubstring() && si < strLength) {
                    validSubstrings.add(input.substring(si, ei + 1));
                    decreaseCount(input.charAt(si));
                    si += 1;
                }

                si -= 1;
                increaseCount(input.charAt(si));
                ei += 1;
            } while (ei < strLength);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("valid substrings: " + validSubstrings);
        System.out.println("shortest valid substring: " + getShortestSubstring());
        return getShortestSubstring().length();
    }

    private static String getShortestSubstring() {
        int minLength = Integer.MAX_VALUE;
        int index = 0, minIndex = 0;

        for (String substring :
                validSubstrings) {
            if (substring.length() < minLength) {
                minLength = substring.length();
                minIndex = index;
            }
            index++;
        }

        return validSubstrings.get(minIndex);
    }

    private static void increaseCount(char c) {
        int oldValue = characterCount.get(c);
        characterCount.replace(c, oldValue + 1);
    }

    private static void decreaseCount(char c) {
        int oldValue = characterCount.get(c);
        characterCount.replace(c, oldValue - 1);
    }

    private static boolean validSubstring() {
        for (Integer value :
                characterCount.values()) {
            if (value == 0)
                return false;
        }
        return true;
    }
}

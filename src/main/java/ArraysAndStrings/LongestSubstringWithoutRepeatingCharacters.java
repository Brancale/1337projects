package ArraysAndStrings;

import java.util.ArrayList;

public class LongestSubstringWithoutRepeatingCharacters {

    //// 1 Efficient Implementation ////
    public int lengthOfLongestSubstringImpl1(String s) {
        if (s.length() <= 1)
            return s.length();

        int maxLen = 0;
        ArrayList<Character> charsFound = new ArrayList();
        char currChar;

        for (int i = 0; i < s.length(); i++) {

            currChar = s.charAt(i);

            // If character has been found, clear everything before and
            // including the current character
            if (charsFound.contains(currChar)) {
                for (int j = 0; j < charsFound.size(); j++) {
                    char currFound = charsFound.get(j);
                    charsFound.remove(j--);
                    if (currFound == currChar)
                        break;
                }
            }

            // Add current character to charsFound
            charsFound.add(currChar);

            if (charsFound.size() > maxLen)
                maxLen = charsFound.size();

            //charsFound.forEach(c -> System.out.print(c));
            //System.out.println();
        }

        return maxLen;
    }

    //// 2 Inefficient Implementation ////
    public int lengthOfLongestSubstringImpl2(String s) {
        if (s.length() <= 1)
            return s.length();

        int maxLen = 0;
        int currLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.length() - i < maxLen)
                return maxLen;

            currLen = getStringWithoutRepeatsFrom(s, i);
            if (currLen > maxLen)
                maxLen = currLen;
            //System.out.println(getStringWithoutRepeatsFrom(s, i));
        }

        return maxLen;
    }

    private int getStringWithoutRepeatsFrom(String s, int start) {
        ArrayList<Character> charsFound = new ArrayList();
        charsFound.add(s.charAt(start));

        char currChar;
        int i = 0;

        for (i = start + 1; i < s.length(); i++) {
            currChar = s.charAt(i);
            if (charsFound.contains(currChar))
                break;
            charsFound.add(currChar);
        }

        return i - start;
    }
}

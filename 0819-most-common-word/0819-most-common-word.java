import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();

        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");

        String[] words = paragraph.split("\\s+");

        String result = "";
        int max = 0;

        for (String word : words) {

            if (!ban.contains(word) && !word.isEmpty()) {

                count.put(word, count.getOrDefault(word, 0) + 1);

                if (count.get(word) > max) {
                    max = count.get(word);
                    result = word;
                }
            }
        }

        return result;
    }
}
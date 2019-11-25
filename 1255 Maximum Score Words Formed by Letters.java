class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[26];
        for (char c : letters) {
            count[c-'a'] += 1;
        }
        return maxScore(words, 0, count, score);
    }
    
    private int maxScore(String[] words, int i, int[] count, int[] score) {
        if (i >= words.length) return 0;
        String word = words[i];
        int mScore = maxScore(words, i+1, count, score);
        int wordScore = 0;
        for (int k = 0; k < word.length(); k += 1) {
            char c = word.charAt(k);
            int index = c - 'a';
            if (count[index] == 0) {
                // cannot choose this word, restore and return
                for (int j = 0; j < k; j += 1) {
                    char x = word.charAt(j);
                    count[x-'a'] += 1;
                }
                return mScore;
            }
            wordScore += score[index];
            count[index] -= 1;
        }
        mScore = Math.max(mScore, wordScore + maxScore(words, i + 1, count, score));
        
        for (int k = 0; k < word.length(); k += 1) {
            char c = word.charAt(k);
            count[c-'a'] += 1;
        }
        return mScore;
    }
}
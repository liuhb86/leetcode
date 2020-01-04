class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int totalLength = 0;
        for (String s : sentence) totalLength += (s.length() + 1);
        int[] timesMemo = new int[sentence.length];
        int[] rowMemo = new int[sentence.length];
        int[] nextMemo = new int[sentence.length];
        int times = 0;
        Arrays.fill(timesMemo, -1);
        int iword = 0;
        int rowTimes = cols / totalLength;
        cols = cols % totalLength;
        for (int r = 0; r < rows; ++r) {
            int firstWord = iword;
            if (timesMemo[iword] >= 0) {
                int nRepeat = r - rowMemo[iword];
                int leftRows = rows - r;
                int ti = times;
                times += (leftRows / nRepeat) * (ti - timesMemo[iword]);
                leftRows = leftRows % nRepeat;
                for (int i = 0; i < leftRows; ++i) {
                    times += timesMemo[nextMemo[iword]] - timesMemo[iword];
                    iword = nextMemo[iword];
                }
                return times;
            }
            timesMemo[firstWord] = times;
            rowMemo[firstWord] = r;
            times += rowTimes;
            int c = 0;
            while (c + sentence[iword].length() <= cols) {
                c = c + sentence[iword].length() + 1;
                ++iword;
                if (iword == sentence.length) {
                    ++times;
                    iword = 0;
                }
            }
            nextMemo[firstWord] = iword;
        }
        return times;
    }
}
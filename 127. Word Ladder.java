// Hard
// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. 
// Note that beginWord does not need to be in wordList.
// sk == endWord

// Given two words, 
// beginWord and endWord, 
// and a dictionary wordList, 
// return the number of words in the shortest transformation sequence from beginWord to endWord, 
// or 0 if no such sequence exists.

// Example 1:
// Input: beginWord = "hit", 
// endWord = "cog", 
// wordList = ["hot","dot","dog","lot","log","cog"]
// Output: 5
// Explanation: 
// One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
  
// Example 2:
// Input: beginWord = "hit", 
// endWord = "cog", 
// wordList = ["hot","dot","dog","lot","log"]
// Output: 0
// Explanation: 
// The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 
// Constraints:
// 1 <= beginWord.length <= 10
// endWord.length == beginWord.length
// 1 <= wordList.length <= 5000
// wordList[i].length == beginWord.length
// beginWord, endWord, and wordList[i] consist of lowercase English letters.
// beginWord != endWord
// All the words in wordList are unique.
  
// Solution
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) {
            return 0;
        }
        
        int len = beginWord.length();
        int lenEnd = endWord.length();
        int lenList = wordList.size();
        
        if (len == 0 || lenEnd == 0 || lenList == 0) {
            return 0;
        }
        
        Set<String> visited = new HashSet<>();
        Set<String> wordMap = wordMap(wordList);
        Queue<String> q = new LinkedList<>();
        int cnt = 0;
        
        q.offer(beginWord);
        visited.add(beginWord);
        
        int size = q.size();
        
        while (!q.isEmpty()) {
            int tempSize = 0;
            
            cnt++;
            
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                
                if (cur.equals(endWord)) {
                    return cnt;
                }
                
                List<String> nextWords = searchWords(cur, len, wordMap);
             
                for (String word : nextWords) {
                    if (!visited.contains(word)) {
                        q.offer(word);
                        visited.add(word);
                        tempSize++;
                    }
                } 
            } 
    
            size = tempSize;
        }
        
        return 0;
    }
    
    private List<String> searchWords(String cur, int len, Set<String> wordMap) {
        char[] curCh = cur.toCharArray();
        char[] alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        List<String> words = new LinkedList<>();
        int TWENTY_SIX = 26;
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < TWENTY_SIX; j++) {
                char[] temp = Arrays.copyOf(curCh, len);
                
                if (temp[i] == alphabet[j]) {
                    continue;
                }
                
                temp[i] = alphabet[j];
                String newWord = new String(temp);
                
                if (wordMap.contains(newWord)) {
                    words.add(newWord);
                }
            }
        }
        
        return words;
    }
    
    private Set<String> wordMap(List<String> wordList) {
        Set<String> wordMap = new HashSet<>();
        
        for (String word : wordList) {
            wordMap.add(word);
        }
        
        return wordMap;
    } 
}
// TC: O(n * m); SC: O(n * m)
// Success
// Details 
// Runtime: 311 ms, faster than 26.12% of Java online submissions for Word Ladder.
// Memory Usage: 117.4 MB, less than 12.48% of Java online submissions for Word Ladder.

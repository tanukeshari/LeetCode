// Medium
// A gene string can be represented by an 8-character long string, 
// with choices from 'A', 'C', 'G', and 'T'.
// Suppose we need to investigate a mutation from a gene string start to a gene string end where one mutation is defined as one single character changed in the gene string.

// For example, 
// "AACCGGTT" --> "AACCGGTA" is one mutation.
// There is also a gene bank bank that records all the valid gene mutations. 
// A gene must be in bank to make it a valid gene string.

// Given the two gene strings start and end and the gene bank bank, 
// return the minimum number of mutations needed to mutate from start to end. 
// If there is no such a mutation, return -1.

// Note that the starting point is assumed to be valid, 
// so it might not be included in the bank.

// Example 1:
// Input: 
// start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
// Output: 
// 1
  
// Example 2:
// Input: 
// start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
// Output: 
// 2
  
// Example 3:
// Input: 
// start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
// Output: 
// 3
 
// Constraints:
// start.length == 8
// end.length == 8
// 0 <= bank.length <= 10
// bank[i].length == 8
// start, end, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].
  
// Solution
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> geneDict = geneDict(bank);
        char[] geneCh = new char[] {'A', 'T', 'C', 'G'};
        
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        Set<String> visited = new HashSet<>();
        
        int len = 1;
        int curLen = 0;
        int cnt = 0;
        
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            len--;
                       
            for (int i = 0; i < cur.length(); i++) {           
                for (char ch : geneCh) {
                    StringBuilder sb = new StringBuilder(cur);
                    sb.setCharAt(i, ch);
                    String s = sb.toString();

                    if (geneDict.contains(s)) {
                        if (!visited.contains(s)) {
                            
                            if (s.equals(end)) {
                                return cnt + 1;
                            }
                            
                            queue.offer(s);
                            curLen++;
                            visited.add(s);
                        }
                    }
                }               
            }
            
            if (len == 0) {
                len = curLen;
                curLen = 0;
                cnt++;
            }
        }
        
        return -1;
    }
    
    private Set<String> geneDict(String[] bank) {
        Set<String> geneDict = new HashSet<>();
        
        for (String gene : bank) {
            geneDict.add(gene);
        }
        
        return geneDict;
    }
}
// TC: O(V + E); SC: O(V)
// Success
// Details 
// Runtime: 2 ms, faster than 32.61% of Java online submissions for Minimum Genetic Mutation.
// Memory Usage: 42.3 MB, less than 17.21% of Java online submissions for Minimum Genetic Mutation.

// Easy
// Given a list of the scores of different students, 
// items, 
// where items[i] = [IDi, scorei] represents one score from a student with IDi, 
// calculate each student's top five average.

// Return the answer as an array of pairs result, 
// where result[j] = [IDj, topFiveAveragej] represents the student with IDj and their top five average. 
// Sort result by IDj in increasing order.

// A student's top five average is calculated by taking the sum of their top five scores and dividing it by 5 using integer division.

// Example 1:
// Input: items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
// Output: [[1,87],[2,88]]

// Explanation: 
// The student with ID = 1 got scores 91, 92, 60, 65, 87, and 100. 
// Their top five average is (100 + 92 + 91 + 87 + 65) / 5 = 87.
// The student with ID = 2 got scores 93, 97, 77, 100, and 76. 
// Their top five average is (100 + 97 + 93 + 77 + 76) / 5 = 88.6, 
// but with integer division their average converts to 88.
  
// Example 2:
// Input: items = [[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100]]
// Output: [[1,100],[7,100]]
 
// Constraints:
// 1 <= items.length <= 1000
// items[i].length == 2
// 1 <= IDi <= 1000
// 0 <= scorei <= 100
// For each IDi, there will be at least five scores.
  
// Solution
class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> hm = new HashMap<>();
        
        for (int[] item : items) {
            int id1 = item[0];
            int score = item[1];
            
            if (hm.containsKey(id1)) {
                PriorityQueue pq = hm.get(id1);
                
                if (pq.size() < 5) {
                    pq.add(score);
                }
                else {
                    pq.add(score);
                    pq.poll();
                }
            }
            else {
                PriorityQueue<Integer> newPq = new PriorityQueue<>();
                newPq.add(score);
                hm.put(id1, newPq);
            }
        }
        
        ArrayList<Integer> sortedKeys = new ArrayList<>(hm.keySet());
        Collections.sort(sortedKeys);
        
        int[][] ans = new int[hm.size()][];
        int idx = 0;
        
        for (int id2 : sortedKeys) {
            PriorityQueue<Integer> cur = hm.get(id2);
            int sum = 0;
            
            for (int i = 0; i < 5; i++) {
                int temp = cur.poll();
                sum += temp;   
            }
            
            int avg = sum / 5;
                
            ans[idx] = new int[] {id2, avg};
            idx++;
        }
        
        return ans;
    }
}
// TC: O(nlgn); SC: O(n)
// Success
// Details 
// Runtime: 6 ms, faster than 73.54% of Java online submissions for High Five.
// Memory Usage: 45.4 MB, less than 82.57% of Java online submissions for High Five.

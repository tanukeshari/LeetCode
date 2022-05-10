// Medium
// There are a total of numCourses courses you have to take, 
// labeled from 0 to numCourses - 1. 
// You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

// For example, 
// the pair [0, 1], 
// indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

// Example 1:
// Input: 
// numCourses = 2, 
// prerequisites = [[1,0]]
// Output: 
// true
  
// Explanation: 
// There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. 
// So it is possible.
  
// Example 2:
// Input: 
// numCourses = 2, 
// prerequisites = [[1,0],[0,1]]
// Output: 
// false
  
// Explanation: 
// There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0, 
// and to take course 0 you should also have finished course 1. 
// So it is impossible.
 
// Constraints:
// 1 <= numCourses <= 2000
// 0 <= prerequisites.length <= 5000
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// All the pairs prerequisites[i] are unique.
  
// Solution
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || numCourses == 0) {
            return true;
        }
        
        int[] numPres = new int[numCourses];
        List<List<Integer>> preLists = new ArrayList<>();
        int cnt = 0;
        
        for (int i = 0; i < numCourses; i++) {
            preLists.add(new ArrayList<Integer>());
        }
        
        for (int j = 0; j < prerequisites.length; j++) {
            preLists.get(prerequisites[j][1]).add(prerequisites[j][0]);
            numPres[prerequisites[j][0]]++;
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int k = 0; k < numCourses; k++) {
            if (numPres[k] == 0) {
                queue.offer(k);
            }
        }
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            cnt++;
            
            for (int l = 0; l < preLists.get(cur).size(); l++) {
                numPres[preLists.get(cur).get(l)]--;
                
                if (numPres[preLists.get(cur).get(l)] == 0) {
                    queue.offer(preLists.get(cur).get(l));
                }
            } 
        }
        
        return cnt == numCourses;
    }
}
// TC: O(E + V); SC: O(E + V)
// Success
// Details 
// Runtime: 6 ms, faster than 69.46% of Java online submissions for Course Schedule.
// Memory Usage: 47.5 MB, less than 64.57% of Java online submissions for Course Schedule.

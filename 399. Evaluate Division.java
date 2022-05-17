// Medium
// You are given an array of variable pairs equations and an array of real numbers values, 
// where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. 
// Each Ai or Bi is a string that represents a single variable.
// You are also given some queries, 
// where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
// Return the answers to all queries. 
// If a single answer cannot be determined, return -1.0.

// Note: 
// The input is always valid. 
// You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

// Example 1:
// Input: 
// equations = [["a","b"],["b","c"]], 
// values = [2.0,3.0], 
// queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
// Output: 
// [6.00000,0.50000,-1.00000,1.00000,-1.00000]

// Explanation: 
// Given: 
// a / b = 2.0, b / c = 3.0
// queries are: 
// a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
// return: 
// [6.0, 0.5, -1.0, 1.0, -1.0 ]

// Example 2:
// Input: 
// equations = [["a","b"],["b","c"],["bc","cd"]], 
// values = [1.5,2.5,5.0], 
// queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
// Output: 
// [3.75000,0.40000,5.00000,0.20000]

// Example 3:
// Input: 
// equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
// Output: 
// [0.50000,2.00000,-1.00000,-1.00000]
 
// Constraints:
// 1 <= equations.length <= 20
// equations[i].length == 2
// 1 <= Ai.length, Bi.length <= 5
// values.length == equations.length
// 0.0 < values[i] <= 20.0
// 1 <= queries.length <= 20
// queries[i].length == 2
// 1 <= Cj.length, Dj.length <= 5
// Ai, Bi, Cj, Dj consist of lower case English letters and digits.
  
// Solution
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> hm = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double quotient = values[i];
            
            if (hm.containsKey(dividend)) {
                Map<String, Double> temp = hm.get(dividend);
                temp.put(divisor, quotient);
                hm.put(dividend, temp);
            }
            else {
                Map<String, Double> temp = new HashMap<>();
                temp.put(divisor, quotient);
                hm.put(dividend, temp);
            }
            
            if (hm.containsKey(divisor)) {
                Map<String, Double> temp = hm.get(divisor);
                temp.put(dividend, 1 / quotient);
                hm.put(divisor, temp);
            }
            else {
                Map<String, Double> temp = new HashMap<>();
                temp.put(dividend, 1 / quotient);
                hm.put(divisor, temp);
            }
        }
        
        int qLen = queries.size();
        double[] ans = new double[qLen];
        
        for (int j = 0; j < qLen; j++) {
            String qDividend = queries.get(j).get(0);
            String qDivisor = queries.get(j).get(1);
            
            if (!hm.containsKey(qDividend)) {
                ans[j] = -1.0;
            }
            else if (qDividend == qDivisor) {
                ans[j] = 1.0;
            }
            else {
                Set<String> visited = new HashSet<>();
                ans[j] = dfs(hm, qDividend, qDivisor, 1, visited);  
            }
        }
        
        return ans;
    }
    
    private double dfs(Map<String, Map<String, Double>> hm, String dividend, String divisor, double accProduct, Set<String> visited) {
        double result = -1.0;
        
        if (hm.get(dividend).containsKey(divisor)) {
            accProduct *= hm.get(dividend).get(divisor);
            
            return accProduct;
        }
        else {
            Map<String, Double> curMap = hm.get(dividend);
            
            for (String dvs :curMap.keySet()) {
                if (visited.contains(dvs)) {
                    continue;
                }
                
                visited.add(dvs);
                result = dfs(hm, dvs, divisor, accProduct * curMap.get(dvs), visited);
                
                if (result != -1.0) {
                    break;
                }
            }   
        }
        
        return result;
    }
}
// TC: O(n * m); SC: O(n);
// Let n be the number of input equations and m be the number of queries.
// Success
// Details 
// Runtime: 2 ms, faster than 57.00% of Java online submissions for Evaluate Division.
// Memory Usage: 43 MB, less than 28.96% of Java online submissions for Evaluate Division.

// Medium
// Given a non-empty array of integers, 
// return the k most frequent elements.

// Example 1:
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]

// Example 2:
// Input: nums = [1], k = 1
// Output: [1]

// Note:
// You may assume k is always valid, 
// 1 ≤ k ≤ number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), 
// where n is the array's size.
// It's guaranteed that the answer is unique, 
// in other words the set of the top k frequent elements is unique.
// You can return the answer in any order.

// Solution 1
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        
        if (k == len) {
            return nums;
        }
        
        Map<Integer, Integer> hm = new HashMap<>();
        
        
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        } 
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (n1, n2) -> hm.get(n1) - hm.get(n2)
        );
        
        for (int num : hm.keySet()) {
            pq.offer(num);
            
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        int[] ans = new int[k];
        
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        
        return ans;
    }
}
// Success
// Details 
// Runtime: 11 ms, faster than 39.68% of Java online submissions for Top K Frequent Elements.
// Memory Usage: 41.5 MB, less than 64.46% of Java online submissions for Top K Frequent Elements.

// Solution 2
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frq = new HashMap<>();
        
        for (int n : nums) {
            frq.put(n, frq.getOrDefault(n, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> frq.get(a) - frq.get(b));
        
        for (int key : frq.keySet()) {
            pq.offer(key);
            
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        int[] ans = new int[k];
        int i = 0;
        
        while (!pq.isEmpty()) {
            ans[i] = pq.poll();
            i++;
        }
        
        return ans;
    }
}
// TC: O(n * lgk); SC: O(n)
// Success
// Details 
// Runtime: 28 ms, faster than 18.36% of Java online submissions for Top K Frequent Elements.
// Memory Usage: 49.3 MB, less than 83.15% of Java online submissions for Top K Frequent Elements.

// Solution 3
class Solution {
    Map<Integer, Integer> frq;
    List<Integer> keys;
    
    public int[] topKFrequent(int[] nums, int k) {
        frq = new HashMap<>();
        
        for (int num : nums) {
            frq.put(num, frq.getOrDefault(num, 0) + 1);
        }
        
        keys = new ArrayList<>(frq.keySet());
        
        quickSelect(keys.size(), k, 0, keys.size() - 1);
             
        int[] ans = new int[k];
        
        for (int i = keys.size() - k; i < keys.size(); i++) {
            ans[i - keys.size() + k] = keys.get(i);
        }
        
        return ans;
    }
    
    private void quickSelect(int len, int k, int lt, int rt) {
        if (lt == rt) {
            return;
        }
        
        Random rand = new Random();
        int pivot = lt + rand.nextInt(rt - lt);
        
        pivot = partition(lt, rt, pivot);
        
        if (pivot == len - k) {
            return;
        }
        else if (pivot < len - k) {
            quickSelect(len, k, pivot + 1, rt);
        }
        else {
            quickSelect(len, k, lt, pivot - 1);
        }
    }
    
    private int partition(int lt, int rt, int pivot) {
        swap(keys, pivot, rt);
        
        int idx = lt;
        
        for (int i = lt; i < rt; i++) {
            if (frq.get(keys.get(i)) < frq.get(keys.get(rt))) {
                swap(keys, i, idx);
                idx++;
            }
        }
        
        swap(keys, idx, rt);
        
        return idx;     
    }
    
    private void swap(List<Integer> keys, int i, int j) {
        int temp = keys.get(i);
        keys.set(i, keys.get(j));
        keys.set(j, temp);
    }
}
// TC: average O(n); SC: O(n)
// Success
// Details 
// Runtime: 15 ms, faster than 76.40% of Java online submissions for Top K Frequent Elements.
// Memory Usage: 50.2 MB, less than 72.43% of Java online submissions for Top K Frequent Elements.

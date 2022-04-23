// Easy
// The school cafeteria offers circular and square sandwiches at lunch break, 
// referred to by numbers 0 and 1 respectively. 
// All students stand in a queue. 
// Each student either prefers square or circular sandwiches.

// The number of sandwiches in the cafeteria is equal to the number of students. 
// The sandwiches are placed in a stack. 
// At each step:
// If the student at the front of the queue prefers the sandwich on the top of the stack, 
// they will take it and leave the queue.
// Otherwise, 
// they will leave it and go to the queue's end.
// This continues until none of the queue students want to take the top sandwich and are thus unable to eat.

// You are given two integer arrays students and sandwiches
// where sandwiches[i] is the type of the i​​​​​​th sandwich in the stack (i = 0 is the top of the stack) 
// and students[j] is the preference of the j​​​​​​th student in the initial queue (j = 0 is the front of the queue). 
// Return the number of students that are unable to eat.

// Example 1:
// Input: 
// students = [1,1,0,0], 
// sandwiches = [0,1,0,1]
// Output: 
// 0 
  
// Explanation:
// - Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
// - Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
// - Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
// - Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
// - Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
// - Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
// - Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
// - Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
// Hence all students are able to eat.
  
// Example 2:
// Input: 
// students = [1,1,1,0,0,1], 
// sandwiches = [1,0,0,0,1,1]
// Output: 
// 3
 
// Constraints:
// 1 <= students.length, sandwiches.length <= 100
// students.length == sandwiches.length
// sandwiches[i] is 0 or 1.
// students[i] is 0 or 1.

// Solution
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        if (students == null || sandwiches == null) {
            return -1;
        }
        
        int nStu = students.length;
        int nSan = sandwiches.length;
        
        if (nStu == 0) {
            return 0;
        }
        
        if (nSan == 0) {
            return nStu;
        }
        
        int start = 0;
        int end = nStu - 1;
        int len = nStu;
        
        for (int i = 0; i < nSan; i++) {
            int cur = start;
            int cnt = 0;
            boolean notFind = true;
            
            while (cnt < len) {
                int stu = students[cur];
                int san = sandwiches[i];
                
                if (stu == san) {
                    boolean moved = moveStudents(students, cur, len);
                    
                    if (moved) {
                        start = cur;
                    }
                    else {
                        start = cur - 1; 
                    }
                    
                    end = (start + len - 1) % len;
                    len--;
                    
                    notFind = false;
                    break;
                }
                else {
                    cur = (cur + 1) % len;
                    cnt++;
                }
            }
            
            if (notFind) {
                break;
            }
        }
        
        return len;
    }
    
    private boolean moveStudents(int[] students, int location, int len) {
        boolean moved = false;
        
        for (int i = location; i < len - 1; i++) {
            students[i] = students[i + 1];
            
            moved = true;
        }
        
        return moved;
    }
}
// TC: O(n^2); SC: O(1)
// Success
// Details 
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Students Unable to Eat Lunch.
// Memory Usage: 40.3 MB, less than 82.78% of Java online submissions for Number of Students Unable to Eat Lunch.

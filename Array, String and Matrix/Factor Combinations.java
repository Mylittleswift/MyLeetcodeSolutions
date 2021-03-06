/*
Numbers can be regarded as product of its factors. For example,
8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.
Note: 
Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Examples: 
input: 1
output: 
[]
input: 37
output: 
[]
input: 12
output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
input: 32
output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
*/

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 1) {
            return result;
        }
        List<Integer> curr = new ArrayList<>();
        helper(2, 1, n, curr, result);
        return result;
    }
     
    private void helper(int start, int product, int n, List<Integer> curr, List<List<Integer>> result) {
        if (start > n || product > n) {
            return;
        }
        if (product == n) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = start; i < n; i++) {
            if (i * product > n) {
                break;
            }
            if (n % (product * i) == 0) {
                curr.add(i);
                helper(i, product * i, n, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
}


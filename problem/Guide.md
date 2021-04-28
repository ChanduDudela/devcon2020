# Approaches

1. If the given input is a sorted array/list/matrix, then we will be using a variation of Binary Search 
   or a Two-pointer strategy.
2. If we're dealing with top/minimum/maximum/closest 'k' elements among 'n' elements, we will be using a Heap
   (PriorityQueue)
3. If we need to try all combinations (or permutations) of input, either use recursive backtracking or 
   iterative BFS
4. For Trees/Graphs related problems, BFS or DFS can be used
5. Every recursive solution can be converted to an iterative solution using a stack.
6. If the problem is asking for optimization (maximize or minimize), we can use Dynamic Programming to solve it. 
7. To find common substring among a set of strings, we will be using a HashMap or a Trie.
8. To search among a strings, Trie will be the best data structure.
9. If the problem involves a LinkedList, and we can't use extra space, then use "Fast and Slow" pointer approach.
10. If for a problem, there exists a brute-force solution in O(n^2) time and O(1) space, then there must exist 2 other solutions,
    * Using a Map or a Set for O(n) time and O(n) space
    * Using Sorting for O(n log n) time and O(1) space

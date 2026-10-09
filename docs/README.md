# DSA Vault — Complete Learning Roadmap

This is the master course map for learning Data Structures and Algorithms in Java. Work through fundamentals first, then learn problem-solving patterns alongside the data structures where they naturally apply. Advanced topics are useful additions, but they should not delay core interview preparation.

## Full Course Tree

```text
dsa-vault/
├── README.md
├── docs/
│   ├── README.md
│   ├── 00-java-foundations/
│   │   ├── 01-variables-and-data-types.md
│   │   ├── 02-type-conversion.md
│   │   ├── 03-operators.md
│   │   ├── 04-conditionals.md
│   │   ├── 05-loops.md
│   │   ├── 06-methods-and-functions.md
│   │   ├── 07-string-stringbuilder.md
│   │   ├── 08-scanner-bufferreader.md
│   │   ├── 09-scope-and-lifetime.md
│   │   ├── 10-arrays-basics.md
│   │   ├── 11-strings-basics.md
│   │   ├── 12-classes-and-objects.md
│   │   ├── 13-stack-and-heap-basics.md
│   │   ├── 14-recursion-basics.md
│   │   ├── 15-wrapper-classes.md
│   │   ├── 16-math-utilities.md
│   │   └── 17-string-builder.md
│   ├── 01-complexity-analysis/
│   │   ├── 01-time-complexity.md
│   │   ├── 02-space-complexity.md
│   │   ├── 03-big-o-notation.md
│   │   ├── 04-complexity-classes.md
│   │   ├── 05-loop-complexity.md
│   │   └── 06-recursion-complexity.md
│   ├── 02-java-collections/
│   │   ├── 01-collections-overview.md
│   │   ├── 02-arraylist.md
│   │   ├── 03-linkedlist.md
│   │   ├── 04-hashmap.md
│   │   ├── 05-hashset.md
│   │   ├── 06-stack.md
│   │   ├── 07-queue-and-deque.md
│   │   ├── 08-priority-queue.md
│   │   └── 09-comparable-and-comparator.md
│   ├── 03-arrays/
│   │   ├── 01-traversal-and-updates.md
│   │   ├── 02-searching.md
│   │   ├── 03-two-pointers.md
│   │   ├── 04-sliding-window.md
│   │   ├── 05-prefix-sum.md
│   │   ├── 06-subarrays-and-kadane.md
│   │   ├── 07-difference-array.md
│   │   └── 08-two-dimensional-arrays.md
│   ├── 04-strings/
│   │   ├── 01-string-operations.md
│   │   ├── 02-character-frequency.md
│   │   ├── 03-palindromes-and-anagrams.md
│   │   ├── 04-string-two-pointers.md
│   │   ├── 05-string-sliding-window.md
│   │   └── 06-string-matching.md
│   ├── 05-hashing/
│   │   ├── 01-hashing-fundamentals.md
│   │   ├── 02-frequency-counting.md
│   │   ├── 03-hashmap-and-hashset-patterns.md
│   │   └── 04-prefix-sum-with-hashing.md
│   ├── 06-sorting/
│   │   ├── 01-sorting-fundamentals.md
│   │   ├── 02-bubble-selection-insertion-sort.md
│   │   ├── 03-merge-sort.md
│   │   ├── 04-quick-sort.md
│   │   ├── 05-counting-sort.md
│   │   └── 06-stability-in-place-and-comparators.md
│   ├── 07-binary-search/
│   │   ├── 01-basic-binary-search.md
│   │   ├── 02-first-last-occurrence-and-bounds.md
│   │   ├── 03-rotated-sorted-array.md
│   │   ├── 04-binary-search-on-answer.md
│   │   └── 05-two-dimensional-binary-search.md
│   ├── 08-recursion-backtracking/
│   │   ├── 01-recursion-and-base-cases.md
│   │   ├── 02-recursion-trees-and-complexity.md
│   │   ├── 03-subsets-and-subsequences.md
│   │   ├── 04-permutations-and-combinations.md
│   │   └── 05-backtracking-patterns.md
│   ├── 09-linked-lists/
│   │   ├── 01-singly-and-doubly-linked-lists.md
│   │   ├── 02-insertion-deletion-and-search.md
│   │   ├── 03-reversal.md
│   │   ├── 04-middle-and-cycle-detection.md
│   │   └── 05-merge-and-pointer-patterns.md
│   ├── 10-stacks-queues/
│   │   ├── 01-stack-and-queue-fundamentals.md
│   │   ├── 02-valid-parentheses.md
│   │   ├── 03-monotonic-stack.md
│   │   ├── 04-next-greater-element.md
│   │   ├── 05-deque-and-monotonic-queue.md
│   │   └── 06-circular-queue.md
│   ├── 11-trees-bst/
│   │   ├── 01-tree-fundamentals.md
│   │   ├── 02-dfs-traversals.md
│   │   ├── 03-bfs-level-order.md
│   │   ├── 04-height-diameter-and-balance.md
│   │   ├── 05-binary-search-tree.md
│   │   ├── 06-lowest-common-ancestor.md
│   │   └── 07-tree-views-and-serialization.md
│   ├── 12-heaps/
│   │   ├── 01-heap-fundamentals.md
│   │   ├── 02-heapify-and-priority-queue.md
│   │   ├── 03-top-k-and-kth-element.md
│   │   └── 04-two-heaps-and-merge-k.md
│   ├── 13-greedy/
│   │   ├── 01-greedy-reasoning.md
│   │   ├── 02-intervals-and-scheduling.md
│   │   └── 03-classic-greedy-problems.md
│   ├── 14-graphs/
│   │   ├── 01-graph-representations.md
│   │   ├── 02-bfs-and-dfs.md
│   │   ├── 03-components-and-cycle-detection.md
│   │   ├── 04-topological-sort.md
│   │   ├── 05-shortest-paths.md
│   │   ├── 06-disjoint-set-union.md
│   │   └── 07-minimum-spanning-tree.md
│   ├── 15-dynamic-programming/
│   │   ├── 01-dp-state-and-recurrence.md
│   │   ├── 02-memoization-and-tabulation.md
│   │   ├── 03-one-dimensional-dp.md
│   │   ├── 04-grid-dp.md
│   │   ├── 05-knapsack-and-subsequence-dp.md
│   │   ├── 06-lis-and-lcs.md
│   │   └── 07-partition-and-stock-dp.md
│   ├── 16-bit-manipulation/
│   │   ├── 01-binary-and-bitwise-operators.md
│   │   ├── 02-bit-masks.md
│   │   └── 03-xor-and-set-bits.md
│   ├── 17-advanced-data-structures/
│   │   ├── 01-trie.md
│   │   ├── 02-fenwick-tree.md
│   │   └── 03-segment-tree.md
│   └── 18-interview-patterns/
│       ├── 01-two-pointers.md
│       ├── 02-sliding-window.md
│       ├── 03-fast-and-slow-pointers.md
│       ├── 04-prefix-sum.md
│       ├── 05-monotonic-stack-queue.md
│       ├── 06-top-k-elements.md
│       ├── 07-intervals.md
│       ├── 08-bfs-dfs.md
│       └── 09-dp-patterns.md
└── src/                         # Executable Java examples

```

> This tree is a plan, not an assertion that every listed file already exists. Create topic notes as the material is studied. Keep executable code in the existing `src/` structure unless a future cleanup is explicitly planned.

## Course Sequence and Priority

| Stage | Topics | Priority |
|---|---|---|
| 00 | Java foundations | Essential |
| 01 | Time and space complexity | Essential |
| 02 | Java Collections Framework | Essential |
| 03–05 | Arrays, strings, hashing | Highest |
| 06–07 | Sorting, binary search | Highest |
| 08–10 | Recursion/backtracking, linked lists, stacks/queues | High |
| 11–12 | Trees/BST, heaps | High |
| 13–15 | Greedy, graphs, dynamic programming | High |
| 16–17 | Bit manipulation, advanced data structures | Selective |
| 18 | Interview patterns and mixed practice | Continuous |

Patterns (two pointers, sliding window, prefix sums, fast/slow pointers, monotonic stack, BFS/DFS, and DP patterns) should be learned with the corresponding topic and revisited through mixed practice.

## Standard Topic Note Format

For every topic, capture:

1. Definition and intuition
2. When and why it is useful
3. Java syntax or implementation
4. A worked example and dry run
5. Brute-force approach, then optimization
6. Time complexity and auxiliary space
7. Edge cases and common mistakes
8. Practice problems, difficulty, and status
9. Key takeaways for revision


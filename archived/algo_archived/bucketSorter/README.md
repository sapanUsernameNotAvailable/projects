# An implementation for bucket sort.

The algorithm needs two things to run : 

1. the maximum value we'll be putting in.
2. the range of values each bucket can hold

## How to use

1. put some values int the algorithm instance
2. the values must implement 2 interfaces : Comparable(so they can be sorted) and Evaluable(so that they can be allocated a bucket)
3. call the getSorted... method to get sorted list.

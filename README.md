# Implementation of Dominator Chain Data structure

Finds the double vertex dominators in a directed acyclic graph
Dominator Chains are datastructures which allows representing all possible O(n2) double vertex dominators in O(n) space, where n is the number of vertices.

# Definition

A vertex v is said to dominate another vertex u if every path from u to the output of the circuit contains v. If two vertices u1,u2 together dominate a vetex v i.e every path from v to the output passes through either u1 or u2 and there exists atleast one path from v to output which contains u1(u2) but does not contain u2(u1), then they are called the double vertex dominators of v.

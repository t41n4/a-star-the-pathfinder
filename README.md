#a-star-the-pathfinder
### **Implement A* algorithm on Terminal**
**Algorithm A*** is a very popular search and optimization algorithm in finding the shortest path in graphs, especially in problems such as finding paths in matrices and games. , maps, etc.
### **Concepts and Ideas of Algorithm A\***
Algorithm A* (A-star) is a **heuristic** search algorithm (based on an estimate) and is used to find the shortest path from a start point to a destination point in the search space. sword. A* combines two factors for optimal search:
- **g(n)**: Cost from starting point to current point `n`.
- **h(n)**: Estimate the cost from current point `n` to destination. This is a heuristic function (evaluation function).
Formula to calculate the value f(n) of each point `n`:
```
f(n) = g(n) + h(n)
```
- **f(n)**: Estimated total cost (or total cost from starting point to destination through point `n`).
- **g(n)**: Cost from starting point to current point `n`.
- **h(n)**: Estimate the cost from `n` to the destination.
**Goal**: Find a path from the starting point to the destination with the lowest total cost.

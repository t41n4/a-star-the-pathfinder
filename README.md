---

# A* Pathfinding Algorithm

This project implements the **A* Pathfinding Algorithm** using Java. It generates a random map with walls and paths, then visualizes the pathfinding process, showing how A* finds the shortest path from a start point to an endpoint.

## Features

- **Random Map Generation**: Generate an N x N grid with random walls.
- **A* Algorithm**: Use A* to find the shortest path between a start and end point on the grid.
- **Map Visualization**: Visualize the generated map with walls (`X`) and paths (`.`). The start point is marked as `S` and the end point as `E`.

## Project Structure

```
src/
│
├── aStarCore/
│   ├── AStar.java        # A* Algorithm implementation
│   ├── Node.java         # Node class for the pathfinding algorithm
│   ├── Visualize.java    # Visualization of the map and the path
│
├── Main.java             # Main entry point of the project
├── MapGenerator.java     # Generates a random map with walls and paths
└── README.md             # Project description and documentation
```

## Requirements

- **Java 8+** (preferably Java 11 or later)

## Setup

1. Clone this repository:

   ```bash
   git clone https://github.com/yourusername/a-star-pathfinding.git
   ```

2. Navigate to the project folder:

   ```bash
   cd a-star-pathfinding
   ```

3. Compile the project:

   ```bash
   javac src/Main.java src/aStarCore/*.java
   ```

4. Run the program:

   ```bash
   java Main
   ```

   You can modify the size of the map (`N x N`) and the number of walls (`wallCount`) in the `Main` class.

## How it works

1. **Random Map Generation**:
    - The map is generated as a 2D grid of size `N x N`, where each cell can either be a **wall** (`1`) or a **path** (`0`).
    - The number of walls is configurable by setting the `wallCount` parameter. The rest of the cells are paths.
    - The start point (`S`) is always at position `(0, 0)` and the end point (`E`) is at position `(N-1, N-1)`.

2. **A* Pathfinding Algorithm**:
    - The **A\* algorithm** searches for the shortest path from the start point to the end point, considering the walls as obstacles.
    - The algorithm uses a **heuristic function** to estimate the distance from a node to the target, making it more efficient than a simple breadth-first search (BFS).

3. **Visualization**:
    - The generated map is printed on the console with `X` representing walls, `.` representing paths, `S` for the start point, and `E` for the end point.
    - Once the algorithm finds a path, it is visualized in the console.

## Example Output

When the program runs, it generates a random map and tries to find a path. A sample output might look like this:

```plaintext
Generated Map:
. . . . X X . . . . 
X . X . . . . . X . 
. . . . . X . . . . 
X . X . . . . . . . 
. . . . . . . . . . 
. X X X . . . . . X 
. . X . X . . . X . 
. . . . . X . . X X 
X . . . . . . . . . 
. . . X . . . . . . 
Path found:
S O O O X X . . . . 
X . X O O O O . X . 
. . . . . X O . . . 
X . X . . . O . . . 
. . . . . . O . . . 
. X X X . . O . . X 
. . X . X . O . X . 
. . . . . X O O X X 
X . . . . . . O O O 
. . . X . . . . . E 
```

- **`X`**: Wall (Obstacle)
- **`.`**: Path (Walkable area)
- **`S`**: Start point (0, 0)
- **`E`**: End point (N-1, N-1)

## Customization

- **Map Size**: You can change the map size by adjusting the `N` value in the `Main.java` file. A larger `N` will generate a larger map.
- **Wall Count**: You can control the number of walls by adjusting the `wallCount` parameter in `Main.java`. The number of walls should be less than or equal to `N * N - 2` to ensure that the start and end points are always reachable.
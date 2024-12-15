package aStarCore;

import java.util.*;

public class AStar {

    private int[][] grid;
    private Node start, end;
    private int rows, cols;
    private PriorityQueue<Node> openList;
    private Set<Node> closedList;
    private List<Node> path;

    public AStar(int[][] grid, Node start, Node end) {
        this.grid = grid;
        this.start = start;
        this.end = end;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.openList = new PriorityQueue<>(Comparator.comparingInt(n -> n.f));
        this.closedList = new HashSet<>();
        this.path = new ArrayList<>();
    }

    // Hàm tính toán khoảng cách Manhattan
    private int calculateH(Node current) {
        return Math.abs(current.x - end.x) + Math.abs(current.y - end.y);
    }

    // Hàm tính g(n) = g cha + chi phí di chuyển (tại đây luôn là 1)
    private int calculateG(Node current, Node neighbor) {
        return current.g + 1;  // Di chuyển từ 1 ô sang ô kề có chi phí là 1
    }

    // Tìm đường đi
    public List<Node> findPath() {
        start.g = 0;
        start.f = calculateH(start);
        openList.add(start);

        while (!openList.isEmpty()) {
            Node current = openList.poll();
            closedList.add(current);

            // Nếu đã đến đích, phục hồi đường đi
            if (current.x == end.x && current.y == end.y) {
                Node temp = current;
                while (temp != null) {
                    path.add(temp);
                    temp = temp.parent;
                }
                Collections.reverse(path);
                return path;
            }

            // Xử lý các điểm kề của node hiện tại
            for (int[] direction : new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}}) {
                int newX = current.x + direction[0];
                int newY = current.y + direction[1];

                // Kiểm tra xem điểm có hợp lệ và chưa được xét chưa
                if (newX >= 0 && newY >= 0 && newX < rows && newY < cols && grid[newX][newY] == 0) {
                    Node neighbor = new Node(newX, newY);
                    if (closedList.contains(neighbor)) continue;

                    int tentativeG = calculateG(current, neighbor);
                    if (!openList.contains(neighbor) || tentativeG < neighbor.g) {
                        neighbor.g = tentativeG;
                        neighbor.h = calculateH(neighbor);
                        neighbor.f = neighbor.g + neighbor.h;
                        neighbor.parent = current;

                        if (!openList.contains(neighbor)) {
                            openList.add(neighbor);
                        }
                    }
                }
            }
        }

        return null; // Nếu không tìm thấy đường đi
    }

    // Hiển thị đường đi
    public void printPath() {
        if (path == null) {
            System.out.println("No path found!");
            return;
        }
        for (Node node : path) {
            System.out.println("(" + node.x + "," + node.y + ")");
        }
    }
}

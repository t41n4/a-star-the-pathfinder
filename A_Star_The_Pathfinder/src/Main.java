import java.util.List;

import aStarCore.AStar;
import aStarCore.MapGenerator;
import aStarCore.Node;
import aStarCore.Visualize;

public class Main {
    public static void main(String[] args) {
        int N = 10;  // Kích thước bản đồ (N x N)
        int wallCount = 20;  // Giới hạn số lượng tường

        // Tạo bản đồ ngẫu nhiên với giới hạn số lượng tường
        int[][] grid = MapGenerator.generateRandomMap(N, wallCount);

        // In bản đồ ngẫu nhiên
        System.out.println("Generated Map:");
        MapGenerator.printMap(grid);

        // Khởi tạo điểm xuất phát và điểm đích
        Node start = new Node(0, 0);  // Điểm bắt đầu (0, 0)
        Node end = new Node(N - 1, N - 1);  // Điểm đích (N-1, N-1)

        // Kiểm tra có thể tìm được đường đi không
        if (MapGenerator.isPathPossible(grid, start, end)) {
            // Khởi tạo thuật toán A* và tìm đường đi
            AStar astar = new AStar(grid, start, end);
            List<Node> path = astar.findPath();

            // Hiển thị đường đi
            if (path != null) {
                System.out.println("Path found:");
            } else {
                System.out.println("No path found!");
            }

            // Trực quan hóa bản đồ và đường đi
            Visualize visualize = new Visualize(grid, path, start, end);
            visualize.displayMap();
        } else {
            System.out.println("No valid path exists!");
        }
    }
}

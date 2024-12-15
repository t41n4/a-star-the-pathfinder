package aStarCore;

import java.util.Random;

public class MapGenerator {
    // Tạo bản đồ ngẫu nhiên với kích thước N và giới hạn số lượng tường
    public static int[][] generateRandomMap(int N, int wallCount) {
        int[][] grid = new int[N][N];
        Random rand = new Random();

        // Khởi tạo bản đồ với tất cả ô là đường đi (0)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = 0;  // 0 là đường đi
            }
        }

        // Đảm bảo điểm xuất phát (0,0) và điểm đích (N-1,N-1) là đường đi (0)
        grid[0][0] = 0;
        grid[N-1][N-1] = 0;

        // Tạo các tường (1) sao cho số lượng tường là wallCount
        int wallsPlaced = 0;
        while (wallsPlaced < wallCount) {
            int x = rand.nextInt(N);
            int y = rand.nextInt(N);

            // Chỉ tạo tường nếu ô chưa là tường và không phải là điểm xuất phát hoặc đích
            if (grid[x][y] == 0 && (x != 0 || y != 0) && (x != N-1 || y != N-1)) {
                grid[x][y] = 1;  // 1 là tường
                wallsPlaced++;
            }
        }

        return grid;
    }

    // In bản đồ ra màn hình
    public static void printMap(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    System.out.print("X ");  // Tường
                } else {
                    System.out.print(". ");  // Đường đi
                }
            }
            System.out.println();
        }
    }

    // Kiểm tra có thể tìm đường từ điểm bắt đầu đến điểm đích
    public static boolean isPathPossible(int[][] grid, Node start, Node end) {
        // Sử dụng thuật toán BFS hoặc DFS để kiểm tra xem có thể tìm được đường đi không
        return new AStar(grid, start, end).findPath() != null;
    }
}

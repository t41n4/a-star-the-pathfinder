package aStarCore;

import java.util.List;


public class Visualize {
    private int[][] grid;       // Bản đồ
    private List<Node> path;    // Đường đi đã tìm được
    private Node start, end;    // Điểm xuất phát và điểm đích

    public Visualize(int[][] grid, List<Node> path, Node start, Node end) {
        this.grid = grid;
        this.path = path;
        this.start = start;
        this.end = end;
    }

    // Hàm in ra bản đồ và đánh dấu đường đi, điểm xuất phát, điểm đích
    public void displayMap() {
        // Duyệt qua từng ô trong bản đồ và in ra
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // In tường là 'X'
                if (grid[i][j] == 1) {
                    System.out.print("X ");
                }
                // In điểm xuất phát là 'S'
                else if (i == start.x && j == start.y) {
                    System.out.print("S ");
                }
                // In điểm đích là 'E'
                else if (i == end.x && j == end.y) {
                    System.out.print("E ");
                }
                // In ô trống là '.'
                else {
                    boolean isPath = false;
                    // Kiểm tra nếu ô này nằm trong đường đi
                    for (Node n : path) {
                        if (n.x == i && n.y == j) {
                            isPath = true;
                            break;
                        }
                    }
                    // In đường đi là 'O'
                    if (isPath) {
                        System.out.print("O ");
                    } else {
                        System.out.print(". ");
                    }
                }
            }
            System.out.println(); // Chuyển sang dòng mới
        }
    }
}
package aStarCore;

public class Node {
	 int x, y;
	    int g, h, f;
	    Node parent;

	    public Node(int x, int y) {
	        this.x = x;
	        this.y = y;
	        this.g = Integer.MAX_VALUE;  // Chi phí ban đầu là vô hạn
	        this.h = 0;
	        this.f = Integer.MAX_VALUE;
	        this.parent = null;
	    }

	    // Hàm so sánh để sắp xếp Node theo giá trị f
	    public int compareTo(Node other) {
	        return Integer.compare(this.f, other.f);
	    }
	    
	    // Hàm equals để so sánh các node
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) return false;
	        Node node = (Node) obj;
	        return x == node.x && y == node.y;
	    }

	    // Hàm hashCode để sử dụng với các cấu trúc dữ liệu như List, Set
	    @Override
	    public int hashCode() {
	        return 31 * x + y;
	    }
}

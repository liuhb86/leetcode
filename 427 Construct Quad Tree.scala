/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node construct(int[][] grid) {
        if (grid.length == 0) return null;
        return construct(grid, 0, 0, grid.length);
    }
    
    Node construct(int[][] grid, int x, int y, int size) {
        if (size == 1) return new Node(grid[x][y] == 1, true, null, null, null, null);
        int cs = size / 2;
        Node tl = construct(grid, x,y,cs);
        Node tr = construct(grid, x, y+cs, cs);
        Node bl = construct(grid, x+cs, y, cs);
        Node br = construct(grid, x+cs, y+cs, cs);
        if (!(tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf)) return new Node(false, false, tl,tr,bl,br);
        boolean v = tl.val;
        if (tr.val == v && bl.val==v && br.val==v) {
            return new Node(v, true, null, null, null, null);
        } else {
            return new Node(false, false, tl,tr,bl,br);
        }
    }
}
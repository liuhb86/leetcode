/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Frame{
    public int x;
    public int y;
    public int returnDir;
    public boolean[] state = new boolean[4];
    public Frame(int x, int y, int dir) {
        this.x = x; this.y = y;
        returnDir = (dir + 2) % 4;
    }
}

class Solution {
    public void cleanRoom(Robot robot) {
        Set<Long> visited = new HashSet<>();
        Stack<Frame> stack = new Stack<>();
        visited.add(0L);
        stack.add(new Frame(0,0,0));
        int dir = 0; // up, right, down, left
        int dx[] = {0, 1, 0, -1};
        int dy[] = {-1,0,1,0};
        robot.clean();
        while (!stack.empty()) {
            Frame f = stack.peek();
            boolean moved = false;
            int dir1 = dir -1;
            for (int i = 0; i<4; i++) {
                dir1 = (dir1 + 1) % 4;
                if (f.state[dir1]) continue;
                int x1 = f.x + dx[dir1];
                int y1 = f.y + dy[dir1];
                if (checkVisited(x1, y1, visited)) continue;
                
                dir = turn(dir, dir1, robot);
                if (robot.move()) {
                    moved = true;
                    stack.add(new Frame(x1,y1, dir1));
                    robot.clean();
                    //System.out.println("c " +(y1+1) +" " + (x1+3));
                    break;
                }
            }
            if (!moved) {
                dir = turn(dir, f.returnDir, robot);
                robot.move();
                stack.pop();
                //if (!stack.empty()) System.out.println("" +(stack.peek().y+1) +" " + (stack.peek().x+3));
            }
        }
    }
    
    boolean checkVisited(int x, int y, Set<Long> visited) {
        long k = x;
        k = k << 32;
        k += y;
        return !visited.add(k);
    }
    
    int turn(int srcDir, int destDir, Robot robot) {
        switch((destDir + 4 - srcDir) % 4) {
            case 1: robot.turnRight(); break;
            case 2: robot.turnRight(); robot.turnRight(); break;
            case 3: robot.turnLeft(); break;
        }
        return destDir;
    }
}
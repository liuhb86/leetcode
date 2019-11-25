import javafx.util.Pair;
class Solution {
    public int minPushBox(char[][] grid) {
        Set<State> visited = new HashSet<>();
        Pair<Integer, Integer> player = null;
        Pair<Integer, Integer> box = null;
        Pair<Integer, Integer> target = null;
        for (int i = 0; i < grid.length; i += 1) {
            for (int j = 0; j < grid[i].length; j += 1) {
                char c = grid[i][j];
                if (c=='S') player = new Pair<Integer, Integer>(i,j);
                else if (c=='B') box = new Pair<Integer, Integer>(i, j);
                else if (c=='T') target = new Pair<Integer, Integer>(i,j);
            }
        }
        if (player == null || box == null || target == null) throw new RuntimeException();
        int moves = 0;
        List<State> current = new ArrayList<>();
        State initState = new State(player, player, box);
        visited.add(initState);
        current.add(initState);
        while (!current.isEmpty()) {
            moves += 1;
            List<State> next = new ArrayList<>();
            for (State state : current) {
                if (move(-1, 0, state, grid, visited, next, target)) return moves;
                if (move(1, 0, state, grid, visited, next, target)) return moves;
                if (move(0, -1, state, grid, visited, next, target)) return moves;
                if (move(0, 1, state, grid, visited, next, target)) return moves;
            }
            current = next;
        }
        return -1;
    }
    
    private boolean move(int dx, int dy, State state, char[][] grid, Set<State> visited, List<State> next, Pair<Integer, Integer> target) {
        int bx = state.box.getKey() + dx;
        int by = state.box.getValue() + dy;
        if (!isEmpty(bx, by, grid)) return false;
        int px = state.box.getKey() - dx;
        int py = state.box.getValue() - dy;
        if (!isEmpty(px, py, grid)) return false;
        Pair<Integer, Integer> newBox = new Pair<>(bx,by);
        Pair<Integer, Integer> newPlayer = new Pair<>(px, py);
        State newState = new State(state.player2, state.box, newBox);
        if (visited.contains(newState)) return false;
        visited.add(newState);
        Set<Pair<Integer, Integer>> pvisited = new HashSet<>();
        //System.out.format("%d %d %d %d %d %d\n", state.box.getKey(), state.box.getValue(), bx, by, px, py);
        if (reachable(state.player2.getKey(), state.player2.getValue(), newPlayer, state.box, grid, pvisited)) {
            //System.out.println("reachable");
            if (bx == target.getKey() && by == target.getValue()) return true;
            next.add(newState);
        }
        return false;
    }
    
    private boolean isEmpty(int x, int y, char[][] grid) {
        if (x < 0 || x >= grid.length) return false;
        if (y < 0 || y >= grid[x].length) return false;
        return grid[x][y] != '#';
    }
    
    private boolean reachable(int x, int y, Pair<Integer, Integer> dest, Pair<Integer, Integer> box, char[][] grid, Set<Pair<Integer, Integer>> visited) {
        if (!isEmpty(x, y, grid)) return false;
        if (x == dest.getKey() && y == dest.getValue()) return true;
        if (x == box.getKey() && y == box.getValue()) return false;
        Pair<Integer, Integer> p = new Pair<>(x, y);
        if (visited.contains(p)) return false;
        visited.add(p);
        return reachable(x+1, y, dest, box, grid, visited) ||
            reachable(x-1, y, dest, box, grid, visited) ||
            reachable(x, y-1, dest, box, grid, visited) ||
            reachable(x, y+1, dest, box, grid, visited);
    }
}

class State {
    Pair<Integer, Integer> player;
    Pair<Integer, Integer> player2;
    Pair<Integer, Integer> box;
    public State(Pair<Integer, Integer> player, Pair<Integer, Integer> player2, Pair<Integer, Integer> box) {
        this.player = player;
        this.player2 = player2;
        this.box = box;
    }
    
    @Override
    public boolean equals(Object that) {
        if (that == this) return true;
        if (! (that instanceof State)) return false;
        State thatState = (State) that;
        return player.equals(thatState.player) && player2.equals(thatState.player2) &&box.equals(thatState.box);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(player, player2, box);
    }
}
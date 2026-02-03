import java.util.*;

class LockingTree {

    int[] parent;
    List<Integer>[] children;
    boolean[] locked;
    int[] lockedBy;

    public LockingTree(int[] parent) {
        int n = parent.length;
        this.parent = parent;

        children = new ArrayList[n];
        for (int i = 0; i < n; i++) children[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) children[parent[i]].add(i);

        locked = new boolean[n];
        lockedBy = new int[n];
        Arrays.fill(lockedBy, -1);
    }

    public boolean lock(int num, int user) {
        if (locked[num]) return false;   // ONLY check
        locked[num] = true;
        lockedBy[num] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if (!locked[num] || lockedBy[num] != user) return false;
        locked[num] = false;
        lockedBy[num] = -1;
        return true;
    }

    public boolean upgrade(int num, int user) {
        if (locked[num] || hasLockedAncestor(num)) return false;

        List<Integer> lockedDesc = new ArrayList<>();
        collectLockedDescendants(num, lockedDesc);

        if (lockedDesc.isEmpty()) return false;

        for (int node : lockedDesc) {
            locked[node] = false;
            lockedBy[node] = -1;
        }

        locked[num] = true;
        lockedBy[num] = user;
        return true;
    }

    private boolean hasLockedAncestor(int node) {
        while (parent[node] != -1) {
            node = parent[node];
            if (locked[node]) return true;
        }
        return false;
    }

    private void collectLockedDescendants(int node, List<Integer> list) {
        for (int child : children[node]) {
            if (locked[child]) list.add(child);
            collectLockedDescendants(child, list);
        }
    }
}

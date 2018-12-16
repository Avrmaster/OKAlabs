import java.util.Stack;

public class Degrees {
    private Digraph digraph;

    Degrees(Digraph G) {
        this.digraph = G;
    }

    int in(int v) {
        int count = 0;
        for (int i = 0; i < digraph.V(); i++) {
            for (int a : digraph.adj(i)) {
                if (a == v) count++;
            }
        }
        return count;
    }

    Iterable<Integer> sources() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < digraph.V(); i++) {
            for (int a : digraph.adj(i)) {
                if (in(a) == 0) stack.push(a);
            }
        }
        return stack;
    }

    Iterable<Integer> sinks() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < digraph.V(); i++) {
            for (int a : digraph.adj(i)) {
                if (out(a) == 0) stack.push(a);
            }
        }
        return stack;
    }
    boolean isMap() {
        for (int i = 0; i < digraph.V(); i++) {
            for (int a : digraph.adj(i)) {
                if (out(a) != 1) return false;
            }
        }
        return true;
    }

    int out(int v) {
        int count = 0;
        for (int a : digraph.adj(v)) {
            count++;
        }
        return count;
    }

}
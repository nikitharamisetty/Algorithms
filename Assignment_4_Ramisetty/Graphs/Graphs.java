import java.util.*;
public class Graphs {
    private final int v = 10;
    private final List<List<Integer>> adj_lst = new ArrayList<>();
    private boolean visitedDFS[] = new boolean[v];
    private boolean[] visitedBFS = new boolean[v];

    Graphs(){
        for(int i = 0 ; i < v; i++)
            adj_lst.add(new LinkedList<>());
    }

    public void addEdge(int v, int val){
        adj_lst.get(v).add(val);
    }

    public void printEdges(int n){
        System.out.println("Start Nodes -> Destination Nodes");
        for(int i = 0; i < n; i++){
            System.out.print(i + "    ->     ");
            for(int j = 0; j < adj_lst.get(i).size(); j++ ){
                System.out.print(adj_lst.get(i).get(j) + "   ");
            }
            System.out.println();
        }
    }

    public void BFS(int node){
        Queue<Integer> q = new ArrayDeque<>();
        visitedBFS[node] = true;
        q.add(node);

        while(!q.isEmpty()){
            int temp = q.poll();
            System.out.print(temp + " ");

            Iterator<Integer> iterator = adj_lst.get(temp).listIterator();
            while(iterator.hasNext()){
                int n = iterator.next();
                if(!visitedBFS[n]){
                    visitedBFS[n] = true;
                    q.add(n);
                }
            }
        }

    }

    public void DFS(int node){
        visitedDFS[node] = true;
        System.out.print(node + " ");

        Iterator<Integer> iterator = adj_lst.get(node).listIterator();
        while(iterator.hasNext()){
            int adj = iterator.next();
            if(!visitedDFS[adj])
                DFS(adj);
        }

    }


    public static void main(String[] args) {
        Graphs g = new Graphs();
        g.addEdge(0,5);
        g.addEdge(0,9);
        g.addEdge(1,2);
        g.addEdge(1,8);
        g.addEdge(2,5);
        g.addEdge(3,5);
        g.addEdge(3,6);
        g.addEdge(3,8);
        g.addEdge(4,9);
        g.addEdge(4,1);
        g.addEdge(5,2);
        g.addEdge(5,3);
        g.addEdge(5,7);
        g.addEdge(6,4);
        g.addEdge(6,2);
        g.addEdge(7,8);
        g.addEdge(8,3);
        g.addEdge(8,7);
        g.addEdge(9,7);
        g.addEdge(9,2);

        g.printEdges(10);
        System.out.println();
        System.out.println("----------------------------------");

        System.out.println("DFS Traversal and the start point is 2:");
        g.DFS(2);
        System.out.println();
        System.out.println("----------------------------------");

        System.out.println("BFS Traversal and the start point is 2:");
        g.BFS(2);
        System.out.println();
        System.out.println("----------------------------------");
    }


}

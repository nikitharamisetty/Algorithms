import java.util.*;
public class Topological_Sort {
    private Map<String, Boolean> visited;

    private Map<String, Boolean>  done;

    private Map<String, Integer>  inDegree;

    private Map<String,ArrayList<String>> adj;


    Topological_Sort(){
        visited = new HashMap<>();
        adj = new HashMap<>();
        inDegree = new HashMap<>();
        done = new HashMap<>();
    }


    void addEdge(String label1, String label2) {
        if(!adj.containsKey(label1))
            adj.put(label1, new ArrayList<String>());
        adj.get(label1).add(label2);


        if(!visited.containsKey(label1)) {
            visited.put(label1, Boolean.FALSE);
            done.put(label1, Boolean.FALSE);
            inDegree.put(label1, 0);
        }
        if(!visited.containsKey(label2)) {
            visited.put(label2, Boolean.FALSE);
            done.put(label2, Boolean.FALSE);
            inDegree.put(label2, 0);
        }

    }

    boolean dfsTopologicalUtil(String label, Map<String, Boolean> visited,Map<String, Boolean>  done, Stack<String> sort){

        boolean cycle = false;
        visited.put(label, Boolean.TRUE);

        if(adj.containsKey(label)) {
            ArrayList<String> adjacentacentNodes = adj.get(label);

            for (int i = 0; i < adjacentacentNodes.size(); i++) {
                if (!done.get(adjacentacentNodes.get(i)) && visited.get(adjacentacentNodes.get(i))) {
                    return true;
                }
                if (!done.get(adjacentacentNodes.get(i))) {
                    cycle = dfsTopologicalUtil(adjacentacentNodes.get(i), visited, done, sort) || cycle;
                }
            }
        }
        done.put(label, Boolean.TRUE);
        sort.push(label);
        return cycle;
    }

    void dfsInitialize(){
        for (String key : visited.keySet()) {
            visited.put(key, Boolean.FALSE);
            done.put(key, Boolean.FALSE);
        }
    }

    void bfsInitialize(){

        for (String key : inDegree.keySet()) {
            inDegree.put(key, 0);
        }
        for (String key : inDegree.keySet()) {
            if(adj.containsKey(key)) {
                ArrayList<String> adjacentacentNodes = adj.get(key);
                for (String temp : adjacentacentNodes)
                    inDegree.put(temp, inDegree.get(temp) + 1);
            }
        }
    }

    public void dfs(){

        Stack<String> sort = new Stack<>();

        dfsInitialize();

        System.out.println("DFS Topological Sort:");

        for (String key : visited.keySet()) {
            if(!visited.get(key))
                if(dfsTopologicalUtil(key, visited, done, sort)){
                    System.out.println("Cycle Detected in the graph so this will break the Topological order!!!");
                    return;
                }
        }

        while (!sort.empty()){
            System.out.print(sort.pop()+" -> ");
        }
        System.out.println();
    }


    public void bfs() {

        bfsInitialize();
        Queue<String> q = new LinkedList<String>();


        System.out.println("BFS Topological Sort:");

        int V = 0;

        for (String key : inDegree.keySet()){
            V++;
            if (inDegree.get(key) == 0)
                q.add(key);
        }

        ArrayList<String> tpSort = new ArrayList<>(V);

        int count = 0;

        while (!q.isEmpty()){
            String temp = q.poll();
            tpSort.add(temp);

            if(adj.containsKey(temp)) {
                for (String adjacentacentNode : adj.get(temp)) {
                    inDegree.put(adjacentacentNode, inDegree.get(adjacentacentNode) - 1);
                    if (inDegree.get(adjacentacentNode) == 0) {
                        q.add(adjacentacentNode);
                    }
                }
            }
            count++;
        }

        if(count != V){
            System.out.println("Cycle Detected in the graph so this will break the Topological order!!!");
            return;
        }
        for (String i : tpSort) {
            System.out.print(i + " -> ");
        }
        System.out.println();
    }


    public static void main(String args[])
    {
        System.out.println("Graph 1 :");
        Topological_Sort g2 = new Topological_Sort();


        g2.addEdge("m","q");
        g2.addEdge("m","r");
        g2.addEdge("m","x");

        g2.addEdge("n","q");
        g2.addEdge("n","u");
        g2.addEdge("n","o");

        g2.addEdge("o","r");
        g2.addEdge("o","s");
        g2.addEdge("o","v");

        g2.addEdge("p","o");
        g2.addEdge("p","s");
        g2.addEdge("p","z");

        g2.addEdge("q","t");

        g2.addEdge("r","u");
        g2.addEdge("r","y");

        g2.addEdge("s","r");

        g2.addEdge("u","t");

        g2.addEdge("v","w");
        g2.addEdge("v","x");

        g2.addEdge("w","z");

        g2.addEdge("y","v");

        g2.dfs();
        g2.bfs();

        System.out.println("Graph 2 : ");
        Topological_Sort g1 = new Topological_Sort();
        g1.addEdge("1","2");
        g1.addEdge("1","6");
        g1.addEdge("1","5");

        g1.addEdge("2","3");
        g1.addEdge("2","5");
        g1.addEdge("2","7");

        g1.addEdge("3","4");

        g1.addEdge("4","5");

        g1.addEdge("5","7");
        g1.addEdge("5","8");

        g1.addEdge("6","5");
        g1.addEdge("6","8");

        g1.addEdge("7","4");
        g1.addEdge("7","8");


        g1.dfs();
        g1.bfs();

        System.out.println("-------------------------------------");




    }

}

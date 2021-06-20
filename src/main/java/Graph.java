import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Graph {

    private LinkedList<Integer> graph[];

    public Graph(int numberOfVertices){
        graph = new LinkedList[numberOfVertices];
        // 0 -> 1
        // 0 -> 4
        // 1 -> 2
       // 2 - 3
       // 3 -> 4
        graph[0].add(1);
        graph[1].add(0);
        graph[0].add(4);
        graph[4].add(0);
        graph[1].add(2);
        graph[2].add(1);
        graph[2].add(3);
        graph[3].add(2);
        graph[3].add(4);
        graph[4].add(3);
    }

    public void bfsExecuter(int source,int destination){

        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        //bfs();
    }

    public void bfs(int source, int destination,Queue<Integer> q,Set<Integer> visited){

        q.add(source);
        visited.add(source);

        if (q.isEmpty()) return;

        for ( int neighbour : graph[source]){
            if (visited.contains(neighbour)) continue;
            q.add(neighbour);
            visited.add(source);
            //bfs(q.poll(),destination);
        }



            int current = q.poll();
           // if ( current == destination) break;


    }

    private boolean dfs(int source, int destination){
        if (source == destination) return true;
        for (int neighbour: graph[source]){
            //if (visited.contains(neighbour)) continue;
            //visited.add(neighbour);
            return dfs(neighbour,destination);
        }

        return  false;
    }
















}

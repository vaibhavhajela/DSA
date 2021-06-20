package Datastructures;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NonDirectedGraph {

    private LinkedList<Integer> graph[];

    public NonDirectedGraph(int noOfVertices){
        graph = new LinkedList[noOfVertices];
        graph[0].add(1);
        graph[0].add(4);
        graph[1].add(0);
        graph[1].add(2);
        graph[2].add(1);
        graph[2].add(3);
        graph[2].add(4);
        graph[3].add(2);
        graph[3].add(4);
        graph[4].add(0);
        graph[4].add(3);
        graph[4].add(2);

    }

    public int bfsExecutor(int start, int destination){
        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        int parent[] = new int[graph.length];
        return bfs(start,destination, visited, q,parent);
    }

    private int  bfs(int start, int destination, Set<Integer> visited,
                     Queue<Integer> q,
                     int parent[]){
        q.add(start);
        visited.add(start);
        parent[start] = -1;

        while (!q.isEmpty()){
            int current = q.poll();
            if ( current == destination) break;

            for (int neighbour: graph[current]){
                if (visited.contains(neighbour)) continue;
                q.add(neighbour);
                visited.add(neighbour);
                parent[neighbour] = current;
                System.out.println(current + "=>" + neighbour);
            }
        }

        int cur = destination;
        int distance = 0;
        while(parent[cur] != -1){
            System.out.println(cur + "<-" );
            cur = parent[cur];
            distance++;
        }

        System.out.println("Shortest distance=" + distance) ;
        return distance;
    }
    public boolean dfs(int start,int destination){
        Set<Integer> visited = new HashSet<Integer>();
        return dfsUtil(start,destination,visited);
    }

    public boolean dfsUtil(int start, int destination,Set<Integer> visited){
        if (start == destination) return true;

        for (int neighnour:graph[start]){
            if (visited.contains(neighnour)) continue;
            visited.add(neighnour);
            // Recursive call
            boolean isConnected = dfsUtil(neighnour,destination,visited);
            if (isConnected) return true;
        }
        return false;
    }





}

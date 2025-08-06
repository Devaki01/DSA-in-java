package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ass3 {

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    static class DisjointSet {
        int[] parent;
        int n;

        public DisjointSet(int n) {
            this.n = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }

    private int V;
    private int[][] graph;
    private long primsComparisons = 0;
    private long kruskalsComparisons = 0;


    public ass3(int v) {
        V = v;
        graph = new int[v][v];
    }

    public void readGraphFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        int fileV = scanner.nextInt();
        if (fileV != V) {
            System.out.println("Warning: Number of vertices in file does not match constructor. Using value from file: " + fileV);
            V = fileV;
            graph = new int[V][V];
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (scanner.hasNextInt()) {
                    graph[i][j] = scanner.nextInt();
                }
            }
        }
        scanner.close();
    }

    public void primsAlgorithm() {
        primsComparisons = 0;
        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mstSet, false);

        key[0] = 0;
        parent[0] = -1;

        System.out.println("\n--- Starting Prim's Algorithm ---");
        System.out.println("Stage | Edge Added | Cumulative Cost");
        System.out.println("------------------------------------");

        int totalCost = 0;

        for (int count = 0; count < V; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            if (parent[u] != -1) {
                totalCost += graph[u][parent[u]];
                System.out.printf("%-5d | %-2d - %-2d (%-4d) | %-15d\n", count, parent[u], u, graph[u][parent[u]], totalCost);
            } else {
                System.out.printf("%-5d | Start at %-2d | %-15d\n", count, u, totalCost);
            }


            for (int v = 0; v < V; v++) {
                primsComparisons++;
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        System.out.println("------------------------------------");
        System.out.println("Prim's Algorithm Finished.");
        printMST(parent, graph, "Prim's");
        System.out.println("Total edge comparisons in Prim's Algorithm: " + primsComparisons);
    }

    private int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++) {
            primsComparisons++; // Comparison for finding min key
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }

    public void kruskalsAlgorithm() {
        kruskalsComparisons = 0;
        List<Edge> edges = new ArrayList<>();
        // Create a list of all edges from the adjacency matrix
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (graph[i][j] != 0) {
                    edges.add(new Edge(i, j, graph[i][j]));
                }
            }
        }

        // Step 1: Sort all the edges in non-decreasing order of their weight.
        // The comparisons for sorting are a major part of this algorithm's complexity.
        // Collections.sort() uses a variant of MergeSort or TimSort in Java,
        // which has a complexity of O(E log E). We can approximate comparisons.
        kruskalsComparisons = (long) (edges.size() * (Math.log(edges.size()) / Math.log(2)));
        Collections.sort(edges);

        DisjointSet ds = new DisjointSet(V);
        ArrayList<Edge> resultMST = new ArrayList<>();

        System.out.println("\n--- Starting Kruskal's Algorithm ---");
        System.out.println("Edge Added | Cost | Action");
        System.out.println("------------------------------------");

        for (Edge edge : edges) {
            int rootSrc = ds.find(edge.src);
            int rootDest = ds.find(edge.dest);
            kruskalsComparisons++; // Comparison for cycle check

            // If including this edge does not cause a cycle
            if (rootSrc != rootDest) {
                resultMST.add(edge);
                ds.union(rootSrc, rootDest);
                System.out.printf("%-2d - %-2d    | %-4d | Added to MST\n", edge.src, edge.dest, edge.weight);
            } else {
                System.out.printf("%-2d - %-2d    | %-4d | Discarded (forms a cycle)\n", edge.src, edge.dest, edge.weight);
            }
        }

        System.out.println("------------------------------------");
        System.out.println("Kruskal's Algorithm Finished.");
        int totalCost = 0;
        System.out.println("\n--- Kruskal's MCST Result ---");
        System.out.println("Edge   | Weight");
        System.out.println("--------------");
        for (Edge edge : resultMST) {
            System.out.printf("%d - %d  | %d\n", edge.src, edge.dest, edge.weight);
            totalCost += edge.weight;
        }
        System.out.println("Total Cost of MCST: " + totalCost);
        System.out.println("Total (approximate) edge comparisons in Kruskal's Algorithm: " + kruskalsComparisons);

    }


    /**
     * A utility function to print the constructed MST stored in parent[].
     * @param parent The array storing the MST structure.
     * @param graph The adjacency matrix.
     */
    private void printMST(int[] parent, int[][] graph, String algorithmName) {
        System.out.println("\n--- " + algorithmName + "'s MCST Result ---");
        System.out.println("Edge   | Weight");
        System.out.println("--------------");
        int totalCost = 0;
        for (int i = 1; i < V; i++) {
            System.out.printf("%d - %d  | %d\n", parent[i], i, graph[i][parent[i]]);
            totalCost += graph[i][parent[i]];
        }
        System.out.println("Total Cost of MCST: " + totalCost);
    }

    /**
     * Main method to drive the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        String filename = "campus_graph.txt";
        createSampleGraphFile(filename); // Create a sample file if it doesn't exist

        try {
            // First, read the number of vertices from the file to initialize the planner
            Scanner preScanner = new Scanner(new File(filename));
            int vertices = preScanner.nextInt();
            preScanner.close();

            ass3 planner = new ass3(vertices);
            planner.readGraphFromFile(filename);

            System.out.println("Graph read successfully from " + filename);
            System.out.println("Number of departments (vertices): " + planner.V);

            // Run Prim's Algorithm
            planner.primsAlgorithm();

            System.out.println("\n====================================================\n");

            // Run Kruskal's Algorithm
            planner.kruskalsAlgorithm();


        } catch (FileNotFoundException e) {
            System.err.println("Error: The file '" + filename + "' was not found.");
            System.err.println("Please make sure the file exists in the same directory or provide the correct path.");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Creates a sample graph file for demonstration purposes if it doesn't already exist.
     * @param filename The name of the file to create.
     */
    public static void createSampleGraphFile(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            return; // File already exists, do nothing
        }
        System.out.println("Sample file '" + filename + "' not found. Creating one for you...");
        try (FileWriter writer = new FileWriter(file)) {
            // 6 departments (vertices)
            // Adjacency matrix representation
            // 0 means no direct edge
            writer.write("6\n");
            writer.write("0 3 0 0 6 5\n");
            writer.write("3 0 1 0 0 4\n");
            writer.write("0 1 0 6 0 4\n");
            writer.write("0 0 6 0 8 5\n");
            writer.write("6 0 0 8 0 2\n");
            writer.write("5 4 4 5 2 0\n");
            System.out.println("Sample file created successfully.");
        } catch (IOException e) {
            System.err.println("Could not create sample file: " + e.getMessage());
        }
    }
}


# Graph Algorithms

This repository contains Java implementations of various graph algorithms, including Breadth-First Search (BFS), Depth-First Search (DFS), Dijkstra's algorithm, and classes representing graphs and vertices.

## Table of Contents
- [Introduction](#introduction)
- [Algorithms](#algorithms)
- [Classes](#classes)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction

Graphs are a fundamental data structure used to represent connections between entities. Graph algorithms are essential for solving many real-world problems, such as finding the shortest path between two points, determining network connectivity, and analyzing social networks.

This repository provides Java implementations of several graph algorithms and data structures to facilitate graph-based problem-solving.

## Algorithms

### Breadth-First Search (BFS)
- Implementation: [BreadthFirstSearch.java](src/graphs/BreadthFirstSearch.java)
- Description: BFS is a graph traversal algorithm that explores all the neighbor vertices at the present depth prior to moving on to the vertices at the next depth level.

### Depth-First Search (DFS)
- Implementation: [DepthFirstSearch.java](src/graphs/DepthFirstSearch.java)
- Description: DFS is a graph traversal algorithm that explores as far as possible along each branch before backtracking.

### Dijkstra's Algorithm
- Implementation: [Dijkstra.java](src/graphs/Dijkstra.java)
- Description: Dijkstra's algorithm is used to find the shortest paths between nodes in a graph, which may represent, for example, road networks.

## Classes

- [MyGraph.java](src/graphs/MyGraph.java): Represents a graph with vertices and edges.
- [Vertex.java](src/graphs/Vertex.java): Represents a vertex in a graph.
- [Edge.java](src/graphs/Edge.java): Represents a weighted edge in a graph.
- [WeightedGraph.java](src/graphs/WeightedGraph.java): Represents a weighted graph with edges having weights.

## Usage

To use these graph algorithms and data structures in your Java project, you can simply include the necessary Java files from this repository. Each algorithm and class is contained in its own file and can be easily integrated into your existing project.

Here is an example of how to use the provided algorithms:

```java
import graphs.*;

public class Main {

    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Search<String> djk = new Dijkstra<>(weightedGraph, "Almaty");
        outputPath(djk, "Kyzylorda");


        System.out.println("--------------------------------");

        MyGraph<String> graph = new MyGraph<>(true);
        fillWithoutWeights(graph);

        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(graph, "Almaty");
        outputPath(dfs, "Kyzylorda");

        System.out.println("--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");
        outputPath(bfs, "Kyzylorda");
    }

    public static void fillWithoutWeights(MyGraph<String> graph) {
        // Add edges without weights
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        // Add edges with weights
    }

    public static void outputPath(Search<String> search, String key) {
        // Output path
    }
}

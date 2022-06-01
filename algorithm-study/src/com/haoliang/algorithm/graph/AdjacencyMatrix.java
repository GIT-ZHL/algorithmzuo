package com.haoliang.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class AdjacencyMatrix {
    private ArrayList<String> vexs; // 顶点表
    private int[][] edges; // 边表
    int numVertexes;
    int numEdges;
    boolean[] visited;

    public AdjacencyMatrix(int numVertexes, int numEdges) {
        this.numVertexes = numVertexes;
        this.numEdges = numEdges;
        this.vexs = new ArrayList<>(numVertexes);
        this.edges = new int[numVertexes][numVertexes];
        this.visited = new boolean[numVertexes];
    }

    private void insertVex(String v) {
        vexs.add(v);
    }

    private void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
    }

    private void show() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    private void DFS(int i) {
        visited[i] = true;
        System.out.print(vexs.get(i) + " ");
        for (int j = 0; j < numVertexes; j++) {
            if (edges[i][j] > 0 && !visited[j]) {
                DFS(j);
            }
        }
    }

    private void DFSTraverse() {
        int i;
        for (i = 0; i < numVertexes; i++) {
            visited[i] = false;
        }
        for (i = 0; i < numVertexes; i++) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    private void BFSTraverse() {
        int i, j;
        LinkedList queue = new LinkedList();
        for (i = 0; i < numVertexes; i++) {
            visited[i] = false;
        }
        for (i = 0; i < numVertexes; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.print(vexs.get(i) + " ");
                queue.addLast(i);
                while (!queue.isEmpty()) {
                    i = (Integer) queue.removeFirst();
                    for (j = 0; j < numVertexes; j++) {
                        if (edges[i][j] > 0 && !visited[j]) {
                            visited[j] = true;
                            System.out.print(vexs.get(j) + " ");
                            queue.addLast(j);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int numVertexes = 9;
        int numEdges = 15;
        AdjacencyMatrix graph = new AdjacencyMatrix(numVertexes, numEdges);
        graph.insertVex("A");
        graph.insertVex("B");
        graph.insertVex("C");
        graph.insertVex("D");
        graph.insertVex("E");
        graph.insertVex("F");
        graph.insertVex("G");
        graph.insertVex("H");
        graph.insertVex("I");
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 5, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 6, 1);
        graph.insertEdge(1, 8, 1);
        graph.insertEdge(2, 3, 1);
        graph.insertEdge(2, 8, 1);
        graph.insertEdge(3, 4, 1);
        graph.insertEdge(3, 6, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(3, 8, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(4, 5, 1);
        graph.insertEdge(5, 6, 1);
        graph.insertEdge(6, 7, 1);
        System.out.println("邻接矩阵");
        graph.show();
        System.out.print("深度优先遍历：");
        graph.DFSTraverse();
        System.out.println();
        System.out.print("广度优先遍历：");
        graph.BFSTraverse();
    }
}


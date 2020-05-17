package BT3_3;

import javafx.util.Pair;

import java.util.*;

public class DijkstraPriorityQueue {
    public int distances[];
    private Set<Integer> setted;
    private PriorityQueue<Node> priorityQueue;
    private int number_of_nodes;
    private int adjacencyMatrix[][];



    private void setInit(int adjacency_matrix[][]){
        for(int i = 0; i < this.number_of_nodes; i++){
            this.distances[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < this.number_of_nodes; i++){
            for(int j = 0; j < this.number_of_nodes; j++){
                this.adjacencyMatrix[i][j] = adjacency_matrix[i][j];
                if(i == j){
                    continue;
                }
                if(this.adjacencyMatrix[i][j] == 0){
                    this.adjacencyMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    public DijkstraPriorityQueue(int adjacency_matrix[][]){
        this.number_of_nodes = adjacency_matrix.length;
        this.distances = new int[this.number_of_nodes];
        this.setted = new HashSet<Integer>();
        this.priorityQueue = new PriorityQueue<Node>(this.number_of_nodes, new Node());
        this.adjacencyMatrix = new int[this.number_of_nodes][this.number_of_nodes];


        this.setInit(adjacency_matrix);
    }

    public void dijkstra(int src, int dst){
        ArrayList<Pair<Integer, Integer>> distancesMatrix = new ArrayList<>();
        Pair<Integer, Integer> fakeValue = new Pair<Integer, Integer>(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for(int i = 0; i < this.number_of_nodes; i++){
            distancesMatrix.add(fakeValue);
        }

        Node evaluationNode;

        this.priorityQueue.add(new Node(src, 0));
        distances[src] = 0;

        distancesMatrix.set(src, new Pair<Integer, Integer>(0, src));
        int flag = src;
        while (!priorityQueue.isEmpty()){
            evaluationNode = this.getNodeWithMinimumDistanceFromPriorityQueue();
            this.setted.add(evaluationNode.node);


            this.evaluationNeighbours(evaluationNode.node);

            for(int i = 0; i < this.distances.length; i++){
                if(this.distances[i] < distancesMatrix.get(i).getKey()){
                    distancesMatrix.set(i, new Pair<>(this.distances[i], flag));
                }
            }

            if(!this.priorityQueue.isEmpty()){
                flag = this.priorityQueue.peek().node;
            }
        }

        this.printTheShortestPath(distancesMatrix, src, dst);

    }

    private void printTheShortestPath(ArrayList<Pair<Integer, Integer>> distancesMatrix, int src, int dst){
        Pair<Integer, Integer> dstNode = distancesMatrix.get(dst);
        int total = dstNode.getKey();
        String shorestPath = new String(String.valueOf(dst + 1));
        LinkedList<String> weightList = new LinkedList<>();
        int newDestination = dst;

        while(dstNode.getKey() != 0){
            Pair<Integer, Integer> preNode = distancesMatrix.get(dstNode.getValue());
            shorestPath = "--> " + shorestPath;
            shorestPath = " |--(" + String.valueOf(dstNode.getKey() - preNode.getKey()) + ")" + shorestPath;
            shorestPath = String.valueOf(dstNode.getValue() + 1) + shorestPath;

            String weight = new String();
            weight = String.valueOf(dstNode.getValue() + 1) + " --> " + String.valueOf(newDestination + 1) + ": " + String.valueOf(dstNode.getKey() - preNode.getKey()) + " (weight)";
            weightList.addFirst(weight);
            newDestination = dstNode.getValue();

            dstNode = preNode;
        }

        System.out.println("*Result: ");
        System.out.println("- The shorest path: ");
        System.out.println(shorestPath.toString());

        System.out.println("- The weight of each of nodes in the shorest path: ");
        for(int i = 0; i < weightList.size(); i++){
            System.out.println(weightList.get(i));
        }

        System.out.println("- Total: " + total);
    }

    private Node getNodeWithMinimumDistanceFromPriorityQueue(){
        Node node = this.priorityQueue.poll();
        //this.priorityQueue.clear();
        return node;
    }

    public void evaluationNeighbours(int evaluationNode){
        int edgeDistance = -1;
        int newDistance = -1;

        for(int destinationNode  = 0; destinationNode < this.number_of_nodes; destinationNode++){
            if(!this.setted.contains(destinationNode)){
                if(this.adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE){
                    edgeDistance = this.adjacencyMatrix[evaluationNode][destinationNode];
                    newDistance = this.distances[evaluationNode] + edgeDistance;

                    if(newDistance < this.distances[destinationNode]){
                        this.distances[destinationNode] = newDistance;


                    }
                    this.priorityQueue.add(new Node(destinationNode, this.distances[destinationNode]));
                }
            }
        }
    }
}

class Node implements Comparator<Node>{
    public int node;
    public int cost;

    public Node(){

    }

    public String toString(){
        return this.node + " " + this.cost;
    }

    public Node(int node, int cost){
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if(node1.cost > node2.cost){
            return 1;
        }
        else if(node1.cost < node2.cost){
            return -1;
        }
        return 0;
    }
}

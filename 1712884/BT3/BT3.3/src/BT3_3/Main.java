package BT3_3;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filePath = new String();
        BufferedReader inStream = null;
        ArrayList<ArrayList<Integer>> weightMatrix = new ArrayList<>();

        int source = -1;
        int destination = -1;


        while (true) {
            System.out.println("- Input the weight file path: ");
            filePath = sc.nextLine();

            if (!isValidFile(filePath)) {
                System.out.println("Warning: Invalid. Please type again");
                continue;
            }
            break;
        }


        try {
            File inFile = new File(filePath);
            inStream = new BufferedReader(new FileReader(inFile));

            String weightLine;
            while ((weightLine = inStream.readLine()) != null) {
                System.out.println(weightLine);

                String w = new String();
                ArrayList<Integer> weightLineArrayList = new ArrayList<>();
                for (int i = 0; i < weightLine.length(); i++) {
                    if (weightLine.charAt(i) == ' ') {
                        weightLineArrayList.add(Integer.parseInt(w));
                        w = new String();
                        continue;
                    }
                    w = w + weightLine.charAt(i);

                    if (i == weightLine.length() - 1) {
                        weightLineArrayList.add(Integer.parseInt(w));
                    }
                }

                weightMatrix.add(weightLineArrayList);
            }

            while (true){
                System.out.print("- Input source: ");
                source = sc.nextInt();

                if(source >= 1 && source <= weightMatrix.size()){
                    break;
                }
                System.out.println("Warning: Invalid. Please type again");
            }

            while (true){
                System.out.print("- Input destination: ");
                destination = sc.nextInt();

                if(destination >= 1 && destination <= weightMatrix.size() && source != destination){
                    break;
                }
                System.out.println("Warning: Invalid. Please type again");
            }



            int[][] weightMatrixArray = convertArrayListToArray(weightMatrix);
            DijkstraPriorityQueue dijkstrasPriorityQueue = new DijkstraPriorityQueue(weightMatrixArray);
            dijkstrasPriorityQueue.dijkstra(source - 1, destination - 1);

        } catch (IOException ex) {
            System.out.println("Wrong Input Format");
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException ex) {

                }
            }
            sc.close();
        }
    }

    private static boolean isValidFile(String filePath) {
        File file = new File(filePath);
        if (file.exists() && !file.isDirectory()) {
            return true;
        }
        return false;
    }

    private static int[][] convertArrayListToArray(ArrayList<ArrayList<Integer>> weightMatrixArrayList){
        int[][] weightMatrixArray = new int[weightMatrixArrayList.size()][weightMatrixArrayList.size()];
        for(int i = 0; i < weightMatrixArrayList.size(); i++){
            for(int j = 0; j < weightMatrixArrayList.size(); j++){
                weightMatrixArray[i][j] = weightMatrixArrayList.get(i).get(j);
            }
        }
        return weightMatrixArray;
    }
}

package BT1;

import javafx.util.Pair;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int type = -1;
        Pair<Integer, String> inputType;
        int algorithmType = -1;
        Pair<Integer, String> outputType;
        EncodeAndDecode algorithm = null;

        while(true){
            type = chooseType();   //Choose encoding or decoding
            if(type == 3){  //Exit
                break;
            }
            inputType = chooseInputType();  //Choose from file or key board
            algorithmType = chooseAlgorithmType();  //Choose Ceasar or ROT13

            if(algorithmType == 1){     //If Ceasar
                algorithm = new Ceasar();
            }
            else if(algorithmType == 2){    //If ROT13
                algorithm = new ROT13();
            }

            outputType = chooseOutputType();    //Choose saving to file or console

            if(type == 1){     //If encoding
                if(inputType.getKey() == 1){    //If from file
                    if(outputType.getKey() == 1){   //If file
                        algorithm.encodeDataFromFileToFile(inputType.getValue(), outputType.getValue());
                    }
                    else if(outputType.getKey() == 2){  //If console
                        algorithm.encodeDataFromFileToConsole(inputType.getValue());
                    }
                }
                else if(inputType.getKey() == 2){   //If from key board
                    if(outputType.getKey() == 1){   //If file
                        algorithm.encodeDataFromConsoleToFile(inputType.getValue(), outputType.getValue());
                    }
                    else if(outputType.getKey() == 2){  //If console
                        algorithm.encodeDataFromConsoleToConsole(inputType.getValue());
                    }
                }
            }
            else if(type == 2){    //If decoding
                if(inputType.getKey() == 1){    //If from file
                    if(outputType.getKey() == 1){   //If file
                        algorithm.decodeDataFromFileToFile(inputType.getValue(), outputType.getValue());
                    }
                    else if(outputType.getKey() == 2){  //If console
                        algorithm.decodeDataFromFileToConsole(inputType.getValue());
                    }
                }
                else if(inputType.getKey() == 2){   //If from key board
                    if(outputType.getKey() == 1){   //If file
                        algorithm.decodeDataFromConsoleToFile(inputType.getValue(), outputType.getValue());
                    }
                    else if(outputType.getKey() == 2){  //If console
                        algorithm.decodeDataFromConsoleToConsole(inputType.getValue());
                    }
                }
            }
        }
    }

    /*Choose encoding or encoding type*/
    private static int chooseType(){
        int type = -1;
        while(true){
            System.out.println("- Choose Encoding or Decoding Type");
            TypeMenu();
            type = Integer.parseInt(new Scanner(System.in).nextLine());

            if(type == 1 || type == 2 || type == 3){
                break;
            }
            else{
                System.out.println("Warning: Invalid. Please type again");
                continue;
            }
        }
        return type;
    }


    private static Pair<Integer, String> chooseInputType(){
        Scanner sc = new Scanner(System.in);
        int inputType = -1;
        String inputValue = new String();
        while(true){
            System.out.println("- Choose the method of inputting data");
            InputTypeMenu();
            inputType = Integer.parseInt(new Scanner(System.in).nextLine());

            if(inputType == 1){
                while(true){
                    System.out.print("- Type the path of file: ");
                    inputValue = sc.nextLine();

                    if(!inputValue.contains(".txt")){
                        System.out.println("Warning: Invalid. Please type again");
                        continue;
                    }

                    if(!isValidFile(inputValue)){   //check weather file is valid
                        System.out.println("Warning: Invalid. Please type again");
                        continue;
                    }
                    break;
                }
                InputFileInfo(inputValue);
                break;
            }
            else if(inputType == 2){
                System.out.print("- Type the input data: ");
                inputValue = sc.nextLine();
                break;
            }
            else{
                System.out.println("Warning: Invalid. Please type again");
                continue;
            }
        }
        return new Pair<Integer, String>(inputType, inputValue);
    }

    private static boolean isValidFile(String filePath){
        File file = new File(filePath);
        if(file.exists() && !file.isDirectory()){
            return true;
        }
        return false;
    }


    private static void InputFileInfo(String inputFilePath){
        File file = new File(inputFilePath);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");

         System.out.println("    - Last modified: " + sdf.format(file.lastModified()));
         System.out.println("    - Length: " + file.length() + " bytes");
    }

    private static int chooseAlgorithmType(){
        int algorithmType = -1;
        while(true){
            System.out.println("- Choose Algorithm Type");
            AlgorithmTypeMenu();
            algorithmType = Integer.parseInt(new Scanner(System.in).nextLine());

            if(algorithmType == 1 || algorithmType == 2){
                break;
            }
            else{
                System.out.println("Warning: Invalid. Please type again");
                continue;
            }
        }
        return algorithmType;
    }

    private static Pair<Integer, String> chooseOutputType(){
        Scanner sc = new Scanner(System.in);
        int outputType = -1;
        String outputValue = new String();
        while(true){
            System.out.println("- Choose the method of outputting data");
            OutputTypeMenu();
            outputType = Integer.parseInt(sc.nextLine());

            if(outputType == 1){
                while(true){
                    System.out.print("- Type the path of file: ");
                    outputValue = sc.nextLine();

                    if(!outputValue.contains(".txt")){
                        System.out.println("Warning: Invalid. Please type again");
                        continue;
                    }

                    if(isValidFile(outputValue)){   //check weather file is exist
                        System.out.print("The file is exist. Do you want to replace it?? Input: 1. Yes; 2. No ==> Choose: ");
                        int c = Integer.parseInt(sc.nextLine());
                        if(c == 1){
                            break;
                        }
                        else if(c == 2){
                            System.out.println("Please type again");
                            continue;
                        }
                    }
                    else{
                        try{
                            File file = new File(outputValue);
                            file.createNewFile();
                        }catch (Exception ex){
                            System.out.println("Warning: Invalid. Please type again");
                            continue;
                        }
                    }
                    break;
                }
                break;
            }
            else if(outputType == 2){
                outputValue = "Console";
                break;
            }
            else{
                System.out.println("Warning: Invalid. Please type again");
                continue;
            }
        }
        return new Pair<Integer, String>(outputType, outputValue);
    }

    private static void TypeMenu(){
        System.out.println("- Input: ");
        System.out.println("        1. Encoding");
        System.out.println("        2. Decoding");
        System.out.println("        3. Exit");
        System.out.print("==> Choose: ");
    }


    private static void InputTypeMenu(){
        System.out.println("- Input: ");
        System.out.println("        1. File");
        System.out.println("        2. Keyboard");
        System.out.print("==> Choose: ");
    }

    private static void AlgorithmTypeMenu(){
        System.out.println("- Input: ");
        System.out.println("        1. Ceasar");
        System.out.println("        2. ROT13");
        System.out.print("==> Choose: ");
    }

    private static void OutputTypeMenu(){
        System.out.println("- Input: ");
        System.out.println("        1. File");
        System.out.println("        2. Console");
        System.out.print("==> Choose: ");
    }
}


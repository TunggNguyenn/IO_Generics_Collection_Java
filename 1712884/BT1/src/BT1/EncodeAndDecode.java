package BT1;

import java.io.*;

public abstract class EncodeAndDecode {
    abstract String encode(String strEncode);
    abstract String decode(String strDecode);

    public void encodeDataFromFileToFile(String inFilePath, String outFilePath) {
        BufferedReader inStream = null;
        BufferedWriter outStream = null;
        File inFile = new File(inFilePath);
        File outFile = new File(outFilePath);

        try{
            inStream = new BufferedReader(new FileReader(inFile));
            outStream = new BufferedWriter(new FileWriter(outFile));

            String strEncode;
            while ((strEncode = inStream.readLine()) != null){
                String encode = this.encode(strEncode);
                outStream.write(encode);
                outStream.newLine();
            }
        }catch (IOException ex) {

        } finally {
            if(inStream != null){
                try{
                    inStream.close();
                }catch (IOException ex){

                }

            }

            if(outStream != null){
                try{
                    outStream.close();
                }catch (IOException ex){

                }
            }
        }
    }

    public void encodeDataFromConsoleToConsole(String strEncode){
        System.out.println("- Result: ");
        System.out.println(this.encode(strEncode));
    }

    public void encodeDataFromFileToConsole(String inFilePath){
        BufferedReader inStream = null;
        File inFile = new File(inFilePath);

        try{
            inStream = new BufferedReader(new FileReader(inFile));

            String strEncode;
            while ((strEncode = inStream.readLine()) != null){
                String encode = this.encode(strEncode);
                System.out.println(encode);
            }
        }catch (IOException ex) {

        } finally {
            if(inStream != null){
                try{
                    inStream.close();
                }catch (IOException ex){

                }

            }
        }
    }

    public void encodeDataFromConsoleToFile(String strEncode, String outFilePath){
        BufferedWriter outStream = null;
        File outFile = new File(outFilePath);

        try{
            outStream = new BufferedWriter(new FileWriter(outFile));

            String encode = encode(strEncode);
            outStream.write(encode);
            outStream.newLine();
        }catch (IOException ex) {

        } finally {
            if(outStream != null){
                try{
                    outStream.close();
                }catch (IOException ex){

                }
            }
        }
    }

    public void decodeDataFromFileToFile(String inFilePath, String outFilePath) {
        BufferedReader inStream = null;
        BufferedWriter outStream = null;
        File inFile = new File(inFilePath);
        File outFile = new File(outFilePath);

        try{
            inStream = new BufferedReader(new FileReader(inFile));
            outStream = new BufferedWriter(new FileWriter(outFile));

            String strDecode;
            while ((strDecode = inStream.readLine()) != null){
                String decode = this.decode(strDecode);
                outStream.write(decode);
                outStream.newLine();
            }
        }catch (IOException ex) {

        } finally {
            if(inStream != null){
                try{
                    inStream.close();
                }catch (IOException ex){

                }

            }

            if(outStream != null){
                try{
                    outStream.close();
                }catch (IOException ex){

                }
            }
        }
    }

    public void decodeDataFromConsoleToConsole(String strDecode){
        System.out.println("- Result: ");
        System.out.println(this.decode(strDecode));
    }

    public void decodeDataFromFileToConsole(String inFilePath){
        BufferedReader inStream = null;
        File inFile = new File(inFilePath);

        try{
            inStream = new BufferedReader(new FileReader(inFile));

            String strDecode;
            while ((strDecode = inStream.readLine()) != null){
                String decode = this.decode(strDecode);
                System.out.println(decode);
            }
        }catch (IOException ex) {

        } finally {
            if(inStream != null){
                try{
                    inStream.close();
                }catch (IOException ex){

                }

            }
        }
    }

    public void decodeDataFromConsoleToFile(String strDecode, String outFilePath){
        BufferedWriter outStream = null;
        File outFile = new File(outFilePath);

        try{
            outStream = new BufferedWriter(new FileWriter(outFile));

            String decode = this.decode(strDecode);
            outStream.write(decode);
            outStream.newLine();
        }catch (IOException ex) {

        } finally {
            if(outStream != null){
                try{
                    outStream.close();
                }catch (IOException ex){

                }
            }
        }
    }
}

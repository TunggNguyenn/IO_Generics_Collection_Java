package BT1;

public class Ceasar extends EncodeAndDecode {
    public String encode(String strEncode){
        String encode = new String();

        for(int i = 0; i < strEncode.length(); i++){
            if(strEncode.charAt(i) >= 'A' && strEncode.charAt(i) <='W' || strEncode.charAt(i) >= 'a' && strEncode.charAt(i) <='w'){
                encode = encode + Character.toString((char)(((int) strEncode.charAt(i)) + 3));
            }
            else if(strEncode.charAt(i) >= 'X' && strEncode.charAt(i) <= 'Z' || strEncode.charAt(i) >= 'x' && strEncode.charAt(i) <= 'z'){
                encode = encode + Character.toString((char)(((int) strEncode.charAt(i)) - 23));
            }
            else {
                encode = encode + Character.toString((char)(((int) strEncode.charAt(i))));
            }
        }
        return encode;
    }

    public String decode(String strDecode){
        String decode = new String();

        for(int i = 0; i < strDecode.length(); i++){
            if(strDecode.charAt(i) >= 'D' && strDecode.charAt(i) <='Z' || strDecode.charAt(i) >= 'd' && strDecode.charAt(i) <='z'){
                decode = decode + Character.toString((char)(((int) strDecode.charAt(i)) - 3));
            }
            else if(strDecode.charAt(i) >= 'A' && strDecode.charAt(i) <= 'C' || strDecode.charAt(i) >= 'a' && strDecode.charAt(i) <= 'c'){
                decode = decode + Character.toString((char)(((int) strDecode.charAt(i)) + 23));
            }
            else {
                decode = decode + Character.toString((char)(((int) strDecode.charAt(i))));
            }
        }
        return decode;
    }

}

package BT1;

public class ROT13 extends EncodeAndDecode {
    public String encode(String strEncode){
        String encode = new String();

        for(int i = 0; i < strEncode.length(); i++){
            if(strEncode.charAt(i) >= 'A' && strEncode.charAt(i) <='M' || strEncode.charAt(i) >= 'a' && strEncode.charAt(i) <='m'){
                encode = encode + Character.toString((char)(((int) strEncode.charAt(i)) + 13));
            }
            else if(strEncode.charAt(i) >= 'N' && strEncode.charAt(i) <= 'Z' || strEncode.charAt(i) >= 'n' && strEncode.charAt(i) <= 'z'){
                encode = encode + Character.toString((char)(((int) strEncode.charAt(i)) - 13));
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
            if(strDecode.charAt(i) >= 'N' && strDecode.charAt(i) <='Z' || strDecode.charAt(i) >= 'n' && strDecode.charAt(i) <='z'){
                decode = decode + Character.toString((char)(((int) strDecode.charAt(i)) - 13));
            }
            else if(strDecode.charAt(i) >= 'A' && strDecode.charAt(i) <= 'M' || strDecode.charAt(i) >= 'a' && strDecode.charAt(i) <= 'm'){
                decode = decode + Character.toString((char)(((int) strDecode.charAt(i)) + 13));
            }
            else {
                decode = decode + Character.toString((char)(((int) strDecode.charAt(i))));
            }
        }
        return decode;
    }

}


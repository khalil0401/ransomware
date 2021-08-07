/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ransomware;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;
/**
 *
 * @author benchek
 */
public class AESAlgo {
    private static final String ALGO="AES";
    private byte [] keyValue;
    public AESAlgo(String key){
        keyValue=key.getBytes();
    }
    public byte[] encrypt(byte []Data) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
       Key key =generateKey();
       Cipher c =Cipher.getInstance(ALGO);
       c.init(Cipher.ENCRYPT_MODE, key);
       byte[] encVal=c.doFinal(Data);
   //    String encryptesdValue =new BASE64Encoder().encode(encVal);
       return encVal;
    }
    public byte [] decrypt(byte [] encryptesdData) throws NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, IOException{
        Key key =generateKey();
        Cipher c=Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
       // byte [] decordedValue =new BASE64Decoder().decodeBuffer(encryptesdData);
        byte[] decValue=c.doFinal(encryptesdData);
       // String decryptedValue=new String(decValue);
        return decValue;
    }
    public Key generateKey(){
        Key k=new SecretKeySpec(keyValue, ALGO);
        return k;
    }
    
}

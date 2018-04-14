package temp;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class mdbes {
    public mdbes() {
        return;
    }



    public String mdbes_convert(String sifre) throws NoSuchAlgorithmException {
        String password = sifre;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash_password = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
      return hash_password;
    }
    public boolean mdbes(String sifre,String hash_sifre)
            throws NoSuchAlgorithmException {
        String hash = hash_sifre;
        String password =sifre;

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte[] digest = md.digest();
        String hash_password = DatatypeConverter
                .printHexBinary(digest).toUpperCase();

        if(hash_password.equals(hash)){
            return true;
        }
        else{
            return false;
        }
    }
}

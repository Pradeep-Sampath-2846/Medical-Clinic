package lk.ijse.dep9.clinic.misc;

import org.apache.commons.codec.digest.DigestUtils;

public class CryptoUtil {
    public static void main(String[] args) {
        String plainPassword = "admin";
        String cipher = DigestUtils.sha256Hex(plainPassword);
        //System.out.println(cipher);

        String [] passwords ={"admin","doc123","doc456","rec123","rec123"};
        for (String password : passwords) {
            System.out.println(getSha256Hex(password));
        }
    }

    public static String getSha256Hex(String input){
        return DigestUtils.sha256Hex(input);
    }
}

import java.util.Base64;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class Main {
    public static void main(String[] args) {
        for (int i=0; i<=9999; i++){
            try {
            String pin = String.format("%04d", i);
            String s = "<base64 code here>";
            String key = "<=== P3nt3st3rL4b ===>";
            byte[] decode = Base64.getDecoder().decode(s);
            byte[] bArr = new byte[decode.length];
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[16];
            System.arraycopy(decode, 0, bArr2, 0, bArr2.length);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            int length = decode.length - 16;
            byte[] bArr4 = new byte[length];
            System.arraycopy(decode, 16, bArr4, 0, length);
            MessageDigest instance = MessageDigest.getInstance("MD5");

            instance.update(key.getBytes("UTF-8"));
            instance.update(pin.getBytes("UTF-8"));
            System.arraycopy(instance.digest(), 0, bArr3, 0, bArr3.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr3, "AES");
            Cipher instance2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance2.init(2, secretKeySpec, ivParameterSpec);
            String clear = new String(instance2.doFinal(bArr4));
            System.out.println(clear);
        } catch (Exception e) {
            
        }
    }
}
}

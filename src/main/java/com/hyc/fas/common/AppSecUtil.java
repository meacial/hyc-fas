package com.hyc.fas.common;

import org.springframework.util.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/23 16:02
 */
public class AppSecUtil {
    // 定义加密算法,可用
    // DES,DESede,Blowfish
    private static final String Algorithm = "DESede";


    /**
     * 3des加密
     * @param key 密钥
     * @param src 原文
     * @return
     */
    public static String encryptMode(String key,  String src, String encoding) {
        try {
            // 生成密钥
            SecretKey deskey = new SecretKeySpec(hex(key), Algorithm);
            // 加密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            byte[] encoded = c1.doFinal(src.getBytes(encoding));// 在单一方面的加密或解密
            return Base64.encode(encoded);
        } catch (java.security.NoSuchAlgorithmException e1) {
            // TODO: handle exception
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    /**
     * 3des解密
     * @param key 密钥
     * @param desrc 密文
     * @return
     */
    public static String decryptMode(String key,  String desrc, String encoding) {
        try {
            // 生成密钥
            SecretKey deskey = new SecretKeySpec(hex(key), Algorithm);
            // 解密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            byte[] encoded = c1.doFinal(Base64.decode(desrc));

            return  new String(encoded, encoding);
        } catch (java.security.NoSuchAlgorithmException e1) {
            // TODO: handle exception
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    // 转换成十六进制字符串
    public static String byte2Hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
            if (n < b.length - 1)
                hs = hs + ":";
        }
        return hs.toUpperCase();
    }

    public static byte[] hex(String username) {
        String key = "test";// 关键字
        String f = DigestUtils.md5DigestAsHex((username + key).getBytes());
        byte[] bkeys = new String(f).getBytes();
        byte[] enk = new byte[24];
        for (int i = 0; i < 24; i++) {
            enk[i] = bkeys[i];
        }
        return enk;
    }

    /*public static void main(String[] args) {
        // 添加新安全算法,如果用JCE就要把它添加进去
        String enk = "0123456789";// 用户名
        String password = "14111111012";// 密码
        System.out.println("加密前的字符串:" + password);
        String pword = encryptMode(enk, password, "utf-8");
        System.out.println("加密后的字符串:" + pword);

        String srcBack = decryptMode(enk, "Iq63w+w1ATP35ycdbXzIyA==", "utf-8");
        System.out.println("解密后的字符串:" + srcBack);
    }*/

}

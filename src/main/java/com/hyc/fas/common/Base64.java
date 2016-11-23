package com.hyc.fas.common;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/23 16:03
 */
public class Base64 {
    private String a;
    private int b = 0;

    public static String encode(byte[] paramArrayOfByte) {
        return new Base64().internalEncode(paramArrayOfByte);
    }

    public String internalEncode(byte[] paramArrayOfByte) {
        int i = paramArrayOfByte.length * 4 / 3 + 4;
        StringBuffer localStringBuffer = new StringBuffer(i * 77 / 76);
        int j = paramArrayOfByte.length;
        int k = 0;
        int m = 0;
        while (k < j - 2) {
            m = b(paramArrayOfByte[(k++)]);
            m <<= 8;
            m |= b(paramArrayOfByte[(k++)]);
            m <<= 8;
            m |= b(paramArrayOfByte[(k++)]);
            byte b1 = (byte) (0x3F & m);
            m >>= 6;
            byte b2 = (byte) (0x3F & m);
            m >>= 6;
            byte b3 = (byte) (0x3F & m);
            m >>= 6;
            byte b4 = (byte) (0x3F & m);
            localStringBuffer.append(a(b4));
            localStringBuffer.append(a(b3));
            localStringBuffer.append(a(b2));
            localStringBuffer.append(a(b1));
        }
        if (k == j - 1) {
            m = b(paramArrayOfByte[(k++)]);
            m <<= 4;
            byte b1 = (byte) (0x3F & m);
            m >>= 6;
            byte b2 = (byte) (0x3F & m);
            localStringBuffer.append(a(b2));
            localStringBuffer.append(a(b1));
            localStringBuffer.append("==");
        }
        if (k == j - 2) {
            m = b(paramArrayOfByte[(k++)]);
            m <<= 8;
            m |= b(paramArrayOfByte[(k++)]);
            m <<= 2;
            byte b1 = (byte) (0x3F & m);
            m >>= 6;
            byte b2 = (byte) (0x3F & m);
            m >>= 6;
            byte b3 = (byte) (0x3F & m);
            localStringBuffer.append(a(b3));
            localStringBuffer.append(a(b2));
            localStringBuffer.append(a(b1));
            localStringBuffer.append("=");
        }
        return localStringBuffer.toString();
    }

    public static byte[] decode(String paramString) {
        return new Base64().internalDecode(paramString);
    }

    public byte[] internalDecode(String paramString) {
        this.a = paramString;
        this.b = 0;
        int i = 0;
        int j = this.a.length();
        for (int k = 0; k < j; k++) {
            if (b(this.a.charAt(k))) {
                i++;
            }
        }
        int k = i * 3 / 4;
        byte[] arrayOfByte = new byte[k];
        int m = 0;
        int n = 0;
        while (n + 2 < k) {
            m = a(a());
            m <<= 6;
            m |= a(a());
            m <<= 6;
            m |= a(a());
            m <<= 6;
            m |= a(a());
            arrayOfByte[(n + 2)] = ((byte) (m & 0xFF));
            m >>= 8;
            arrayOfByte[(n + 1)] = ((byte) (m & 0xFF));
            m >>= 8;
            arrayOfByte[n] = ((byte) (m & 0xFF));
            n += 3;
        }
        if (n == k - 1) {
            m = a(a());
            m <<= 6;
            m |= a(a());
            m >>= 4;
            arrayOfByte[n] = ((byte) (m & 0xFF));
        }
        if (n == k - 2) {
            m = a(a());
            m <<= 6;
            m |= a(a());
            m <<= 6;
            m |= a(a());
            m >>= 2;
            arrayOfByte[(n + 1)] = ((byte) (m & 0xFF));
            m >>= 8;
            arrayOfByte[n] = ((byte) (m & 0xFF));
        }
        return arrayOfByte;
    }

    private int a(char paramChar) {
        if ((paramChar >= 'A') && (paramChar <= 'Z')) {
            return paramChar - 'A';
        }
        if ((paramChar >= 'a') && (paramChar <= 'z')) {
            return paramChar - 'a' + 26;
        }
        if ((paramChar >= '0') && (paramChar <= '9')) {
            return paramChar - '0' + 52;
        }
        if (paramChar == '+') {
            return 62;
        }
        if (paramChar == '/') {
            return 63;
        }
        throw new IllegalArgumentException(paramChar + " is not a valid Base64 character.");
    }

    private char a(byte paramByte) {
        if (paramByte < 26) {
            return (char) (65 + paramByte);
        }
        if (paramByte < 52) {
            return (char) (97 + (paramByte - 26));
        }
        if (paramByte < 62) {
            return (char) (48 + (paramByte - 52));
        }
        if (paramByte == 62) {
            return '+';
        }
        if (paramByte == 63) {
            return '/';
        }
        throw new IllegalArgumentException("Byte " + new Integer(paramByte) + " is not a valid Base64 value");
    }

    private boolean b(char paramChar) {
        return ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= '0') && (paramChar <= '9')) || (paramChar == '+') || (paramChar == '/');
    }

    private char a() {
        char c = '_';
        while (!b(c)) {
            c = this.a.charAt(this.b++);
        }
        return c;
    }

    private int b(byte paramByte) {
        if (paramByte >= 0) {
            return paramByte;
        }
        return 256 + paramByte;
    }

    /*public static void main(String[] paramArrayOfString) throws Exception {
        String str1 = "I am !1";
        System.out.println("Text = [" + str1 + "]");
        String str2 = encode(str1.getBytes());
        System.out.println("Encoded = [" + str2 + "]");
        byte[] arrayOfByte = decode(str2);
        System.out.println("Decoded = [" + new String(arrayOfByte) + "]");
    }*/
}

package lin.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    /**
     * 将传入的密码加密并返回
     */
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}

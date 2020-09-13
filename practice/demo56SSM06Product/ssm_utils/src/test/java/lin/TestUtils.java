package lin;

import lin.utils.BCryptPasswordEncoderUtils;
import org.junit.Test;

public class TestUtils {

    @Test
    public void testEncodePassword() {
        String password = "aaaaaa";
        String newPassword = BCryptPasswordEncoderUtils.encodePassword(password);
        System.out.println(newPassword);
    }
}

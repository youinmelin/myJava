package lin;

import lin.utils.StringUtils;
import org.junit.Test;

public class TestUtils {

    @Test
    public void testChangeSign() {
        String originName = "originName:还有中文#修^改%&.xym";
        System.out.println(StringUtils.changeSign(originName));
    }
}

package lin;

import lin.dao.IAccountDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class testDao {

    @Autowired
    IAccountDao accountDao;

    @Test
    public void testFindAllAccount() {
        accountDao.findAllAccount();
    }
}

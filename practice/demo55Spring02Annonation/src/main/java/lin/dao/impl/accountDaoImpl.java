package lin.dao.impl;

import lin.dao.IAccountDao;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class accountDaoImpl implements IAccountDao{
    public void useDao(){
        System.out.println("Dao...");
    }

}

package lin.service.impl;

import lin.dao.IUserDao;
import lin.dao.impl.UserDaoImpl;
import lin.service.IUserService;

public class UserServiceImpl implements IUserService {

    IUserDao userDao ;

    public void init() {
        System.out.println("initialize program");
    }

    public void showAll() {
        userDao.showAll();
    }

    public void addNew() {
        userDao.addNew();
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }
}

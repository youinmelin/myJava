package lin.dao.impl;

import lin.dao.IUserDao;
import lin.service.IUserService;

public class UserDaoImpl implements IUserDao {

    public void showAll() {
        System.out.println("Show all students.");
    }

    public void addNew() {
        System.out.println("Add a new student.");
    }
}

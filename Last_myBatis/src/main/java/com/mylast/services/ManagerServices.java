package com.mylast.services;

import com.mylast.dao.ManagerDao;
import com.mylast.domain.Manager;
import com.mylast.domain.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServices {
    @Autowired
    ManagerDao managerDao;
    public Manager findBynameAndpassword(String name, String password){
        return managerDao.findBynameAndpassword(name,password);
    }

}

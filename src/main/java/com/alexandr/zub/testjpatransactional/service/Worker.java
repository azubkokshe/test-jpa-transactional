package com.alexandr.zub.testjpatransactional.service;

import com.alexandr.zub.testjpatransactional.dao.UserDao;
import com.alexandr.zub.testjpatransactional.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;

@Service
@Scope(value = "prototype")
public class Worker extends Thread {
    @Autowired
    UserDao userDao;

    private boolean isLock;

    public Worker(boolean isLock) {
        this.isLock = isLock;
    }

    @Override
    public void run() {

//        if (!this.isLock) {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        System.out.println("[x] Thread start work: " + Thread.currentThread().getName());

        userDao.logic("Alex", isLock);

//        User user = userDao.getUserByName("Alex");
//
//        if (!this.isLock) {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        user.setAge(18);
//
//        userDao.saveUser(user);
//

        System.out.println("[x] Thread finished work: " + Thread.currentThread().getName());

//        if (user != null) {
//            user.setAge(13);
//            if (this.isLock) {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println("saved");
//            userRepo.save(user);
//        }
    }
}

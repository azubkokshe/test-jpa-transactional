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
        System.out.println("[x] Thread start work: " + Thread.currentThread().getName());
        userDao.logic("Alex", isLock);
        System.out.println("[x] Thread finished work: " + Thread.currentThread().getName());
    }
}

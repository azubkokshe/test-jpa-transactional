package com.alexandr.zub.testjpatransactional.dao;

import com.alexandr.zub.testjpatransactional.model.Sex;
import com.alexandr.zub.testjpatransactional.model.User;
import com.alexandr.zub.testjpatransactional.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW, timeout = 10)
public class UserDao {
    @Autowired
    UserRepo userRepo;

    public void logic(String name, boolean isSleep) {
        User user = userRepo.findUserByName(name);
        int age = user.getAge();
        System.out.println("[x] Thread read age: " + Thread.currentThread().getName() + " : " + age);
        age++;
        user.setAge(age);
        if (isSleep) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        User usr = User.builder().age(1).name(Thread.currentThread().getName()).sex(Sex.MALE).build();
        userRepo.saveAndFlush(usr);
        userRepo.save(user);
    }
}
package com.alexandr.zub.testjpatransactional.repo;

import com.alexandr.zub.testjpatransactional.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;

public interface UserRepo extends JpaRepository<User, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    User findUserByName(String name);
}

package com.capgemini.repo;

import com.capgemini.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<UserLogin,String> {

    UserLogin findByUserid(String userid);
}

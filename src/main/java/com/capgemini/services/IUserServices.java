package com.capgemini.services;

import com.capgemini.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserServices {
    /**
     *
     * THIS METHOD READ FORM Data as Model Class
     * @Param user indicate ModelAttributes
     * @return Integer PK
     */

    public Integer saveUser(User user);

    /**
     *
     * @return
     */
    public List<User> getAllUser();
}

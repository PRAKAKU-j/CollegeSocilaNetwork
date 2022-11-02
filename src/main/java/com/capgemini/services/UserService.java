package com.capgemini.services;

import com.capgemini.dto.PageDTO;
import com.capgemini.dto.UserDTO;
import com.capgemini.entity.User;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User getUser(Long id);

    UserDTO getUserById(Long id);

    UserDTO getUserByEmail(String email);

    PageDTO<UserDTO> findAllPageable(Long id, Pageable pageable);

    PageDTO<UserDTO> findAllWithSearch(Long id, String search, Pageable pageable);

    void createUser(UserDTO userDTO);

    void updatePassword(String password, Long id);

    void updateUser(UserDTO userDTO);

    void updateUserImage(UserDTO userDTO, String fileName);

    void makeUserAdmin(Long userId);

    void blockUser(Long userId);
}

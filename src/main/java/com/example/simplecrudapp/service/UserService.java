package com.example.simplecrudapp.service;

import com.example.simplecrudapp.shared.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserDTO createUser(UserDTO user);
    UserDTO getUser(String email);
    UserDTO getUserByUserId(String id);

    UserDTO updateUser(String id, UserDTO userDTO);
    void deleteUser(String id);

    List<UserDTO> getUsers(int page, int limit);

//    UserDTO getUserByUserId(String userId);
}

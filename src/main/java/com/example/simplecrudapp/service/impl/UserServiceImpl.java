package com.example.simplecrudapp.service.impl;

import com.example.simplecrudapp.exceptions.UserServiceException;
import com.example.simplecrudapp.io.repository.UserRepository;
import com.example.simplecrudapp.io.entity.UserEntity;
import com.example.simplecrudapp.service.UserService;
import com.example.simplecrudapp.shared.Utils;
import com.example.simplecrudapp.shared.dto.PositionDTO;
import com.example.simplecrudapp.shared.dto.UserDTO;
import com.example.simplecrudapp.ui.model.response.ErrorMessages;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO createUser(UserDTO user) {

        if (userRepository.findByEmail(user.getEmail()) != null)
            throw new RuntimeException("Record already exists!"); // it doesn't give me my custom exception

        for (int i = 0; i < user.getPreviousPositions().size(); i++) {
            PositionDTO position = user.getPreviousPositions().get(i);
            position.setUserDetails(user);
            position.setPositionId(utils.generatePositionId(20));
            user.getPreviousPositions().set(i, position);
        }
        
        //BeanUtils.copyProperties(user, userEntity);
        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);

        String publicUserId = utils.generateUserId(20);
        userEntity.setUserId(publicUserId);
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        UserEntity storedUserDetails = userRepository.save(userEntity);

        //BeanUtils.copyProperties(storedUserDetails, returnValue);
        UserDTO returnValue = modelMapper.map(storedUserDetails, UserDTO.class);

        return returnValue;
    }

    @Override
    public UserDTO getUser(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);

        if (userEntity == null) throw new UsernameNotFoundException(email);

        UserDTO returnValue = new UserDTO();
        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);

        if (userEntity == null) throw new UsernameNotFoundException(email);

        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }

    @Override
    public UserDTO getUserByUserId(String userId) {
        UserDTO returnValue = new UserDTO();
        UserEntity userEntity = userRepository.findByUserId(userId);
        if (userEntity == null) throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }

    @Override
    public UserDTO updateUser(String id, UserDTO userDTO) {
        UserDTO returnValue = new UserDTO();
        UserEntity userEntity = userRepository.findByUserId(id);
        if (userEntity == null) throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

        // example of business logic (can be any depends on needs)
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());

        UserEntity updatedUserDetails = userRepository.save(userEntity);
        BeanUtils.copyProperties(updatedUserDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteUser(String id) {
        UserEntity userEntity = userRepository.findByUserId(id);
        if (userEntity == null) throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

        userRepository.delete(userEntity);
    }

    @Override
    public List<UserDTO> getUsers(int page, int limit) {
        List<UserDTO> returnValue = new ArrayList<>();
        if(page>0){
            page = page - 1;
        }
        PageRequest pageableRequest = PageRequest.of(page, limit);

        Page<UserEntity> userspage = userRepository.findAll(pageableRequest);
        List<UserEntity> users = userspage.getContent();

        for (UserEntity userEntity: users) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userEntity, userDTO);
            returnValue.add(userDTO);
        }

        return returnValue;
    }

}

package com.example.simplecrudapp.ui.controller;

import com.example.simplecrudapp.exceptions.UserServiceException;
import com.example.simplecrudapp.service.UserService;
import com.example.simplecrudapp.shared.dto.UserDTO;
import com.example.simplecrudapp.ui.model.request.UserRequestModel;
import com.example.simplecrudapp.ui.model.response.ErrorMessages;
import com.example.simplecrudapp.ui.model.response.OperationStatusModel;
import com.example.simplecrudapp.ui.model.response.UserRest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest getUser(@PathVariable String id) {
        UserRest returnValue = new UserRest();
        UserDTO userDTO = userService.getUserByUserId(id);
        BeanUtils.copyProperties(userDTO, returnValue);
        return returnValue;
    }

    @GetMapping (produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<UserRest> getUsers(@RequestParam(value="page", defaultValue = "0") int page, @RequestParam(value = "limit", defaultValue = "15") int limit) {
        List<UserRest> returnValue = new ArrayList<>();
        List<UserDTO> users = userService.getUsers(page, limit);

        for (UserDTO userDTO: users) {
            UserRest userRest = new UserRest();
            BeanUtils.copyProperties(userDTO, userRest);
            returnValue.add(userRest);
        }

        return returnValue;
    }


    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest createUser(@RequestBody UserRequestModel userDetails) throws Exception {
        UserRest returnValue = new UserRest();

        if (userDetails.getFirstName().isEmpty())
            throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

//        UserDTO userDTO = new UserDTO();
//        BeanUtils.copyProperties(userDetails, userDTO);
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(userDetails, UserDTO.class);

        UserDTO createdUser = userService.createUser(userDTO);
        //BeanUtils.copyProperties(createdUser, returnValue);
        returnValue = modelMapper.map(createdUser, UserRest.class);

        return returnValue;
    }

    @PutMapping(path = "/{id}", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser(@PathVariable String id, @RequestBody UserRequestModel userDetails) {
        UserRest returnValue = new UserRest();

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDetails, userDTO);

        UserDTO updatedUser = userService.updateUser(id, userDTO);
        BeanUtils.copyProperties(updatedUser, returnValue);

        return returnValue;
    }

    @DeleteMapping(path = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public OperationStatusModel deleteUser(@PathVariable String id) {
        OperationStatusModel returnValue = new OperationStatusModel();
        returnValue.setOperationName("DELETE");

        userService.deleteUser(id);
        returnValue.setOperationResult("The record for user with id=" + id + " is deleted");

        return returnValue;
    }


}

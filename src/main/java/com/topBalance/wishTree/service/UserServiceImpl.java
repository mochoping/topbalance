package com.topBalance.wishTree.service;

import com.topBalance.wishTree.dto.User;
import com.topBalance.wishTree.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Map<String, Object>> getAllUsers() {
        List<User> userList = userMapper.getAllUsers();
        return userList.stream().map(user -> {
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("userId", user.getUserId());
            /*userMap.put("username", user.getUsername());
            userMap.put("email", user.getEmail());
            userMap.put("birthday", user.getBirthday());
            userMap.put("accountBalance", user.getAccountBalance());
            userMap.put("gender", user.getGender());
            userMap.put("hobbies", user.getHobbies());*/
            return userMap;
        }).collect(Collectors.toList());
    }

    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

}

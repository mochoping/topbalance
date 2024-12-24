package com.topBalance.wishTree.service;

import com.topBalance.wishTree.dto.User;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface UserService {
    // 전체목록 조회
    List<Map<String, Object>> getAllUsers();

    // 회원가입

    // userid로 회원 조회
    User getUserById(String id);
    // 정보수정
    void updateUser(User user);


}

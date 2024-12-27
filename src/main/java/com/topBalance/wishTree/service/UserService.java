package com.topBalance.wishTree.service;

import com.topBalance.wishTree.dto.User;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface UserService {
    // 전체목록 조회
    List<Map<String, Object>> getAllUsers();

    // 회원가입

    // userid로 회원 조회
    User checkPassword(String userId);
    // 정보수정
    User updateUser(String userId);

    void insertUser(User user);

    String findByPassword(String userId, String userPhone);

    String findById(String userName, String userPhone, Date userBirthdate);
}

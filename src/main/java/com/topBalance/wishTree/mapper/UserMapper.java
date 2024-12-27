package com.topBalance.wishTree.mapper;

import com.topBalance.wishTree.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getAllUsers();

    //회원 userID를 통한 조회
    User checkPassword(String userId);

    //유저저장하기
    void insertUser(User user);

    //id 분실시 유저이름과,전화번호/ /이름과 생년월일 성별을 통한 아이디찾기 뒤에서 4자리 가리기
    //String findById(String userName, String userPhone);
    //pw 분실시 id와 이름, 전화번호/ /id와 이름 생년월일 성별을 통한 비밀번호찾기
    //String findByPassword(String userName, String userPhone);
    //회원정보 수정
    User updateUser(String userId);
    //비번찾기 - 아이디,핸드폰번호

    String findByPassword(String userId, String userPhone);

    String findById(String userName, String userPhone, Date userBirthdate);
}



package com.topBalance.wishTree.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;
    private String userPassword;
    private String userName;
    private String userPhone;
    private Date userBirthdate;
    private String userGender;
    private int ranking;
    private int totalScore;
    private Date gameDate;
    private int dailyVisit;
}
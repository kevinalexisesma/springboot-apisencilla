package com.example.apisencilla.apisencilla.Services;

import java.util.List;

import com.example.apisencilla.apisencilla.Models.domain.User;

public interface UserService {

    List<User> findAll();
    User findById(Long id);
}

package com.example.apisencilla.apisencilla.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.apisencilla.apisencilla.Models.domain.User;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users;

    public UserServiceImpl (){
        users = new ArrayList<>();
        users.add(new User(1L, "John", "Maria"));
        users.add(new User(2L, "Andres", "Suarez"));
        users.add(new User(3L, "Maria", "Nicol"));
        users.add(new User(4L, "Josefa", "Ramirez"));
        users.add(new User(5L, "Kevin", "Eslava"));
        users.add(new User(6L, "Leonardo", "Trujillo"));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(Long id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }
}
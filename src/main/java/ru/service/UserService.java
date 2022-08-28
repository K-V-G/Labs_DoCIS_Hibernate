package ru.service;

import ru.models.UserInfo;

import java.util.List;

public interface UserService {
    UserInfo findById(int id);

    UserInfo findByUsername(String username);

    void saveUser(UserInfo userInfo);

    void updateUser(UserInfo userInfo);

    void deleteUserByUserName(String username);

    List<UserInfo> findAllUsers();

    boolean isUserUserNameUnique(Integer id, String username);
}

package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.models.UserInfo;
import ru.repository.UserDAOImpl;

import java.util.List;
@Service
@Transactional
public class UserServiceIpml implements UserService {
    @Autowired
    private UserDAOImpl userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserInfo findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public UserInfo findByUsername(String username) {
        return userDAO.findByUserName(username);
    }

    @Override
    public void saveUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userDAO.save(userInfo);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        UserInfo entityUserInfo = userDAO.findById(userInfo.getId());
        if (entityUserInfo != null) {
            entityUserInfo.setUsername(userInfo.getUsername());
            if(!userInfo.getPassword().equals(entityUserInfo.getPassword())) {
                entityUserInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
            }
            entityUserInfo.setUserProfiles(userInfo.getUserProfiles());
        }
    }

    @Override
    public void deleteUserByUserName(String username) {
        userDAO.deleteByUserName(username);
    }

    @Override
    public List<UserInfo> findAllUsers() {
        return userDAO.findAllUsers();
    }

    @Override
    public boolean isUserUserNameUnique(Integer id, String username) {
        UserInfo userInfo = findByUsername(username);
        return (userInfo == null || ((id != null) && (userInfo.getId() == id)));
    }
}

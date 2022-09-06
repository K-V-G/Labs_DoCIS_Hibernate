/*
package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.models.UserInfo;
import ru.repository.UserDAOImpl;

@Service
@Transactional
public class UserServiceIpml implements UserService {
    @Autowired
    private UserDAOImpl userDAO;

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserInfo findByUsername(String username) {
        return userDAO.findByUserName(username);
    }

    @Override
    public void saveUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfo.setUserProfiles(userProfileService.findByType("USER"));
        userDAO.save(userInfo);
    }
}
*/

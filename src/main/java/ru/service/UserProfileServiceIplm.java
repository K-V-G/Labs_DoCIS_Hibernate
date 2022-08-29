package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.models.UserProfile;
import ru.repository.UserProfileDAO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserProfileServiceIplm implements UserProfileService{

    @Autowired
    UserProfileDAO userProfileDAO;

    @Override
    public UserProfile findById(int id) {
        return userProfileDAO.findById(id);
    }

    @Override
    public UserProfile findByType(String type) {
        return userProfileDAO.findByType(type);
    }


    @Override
    public List<UserProfile> findAll() {
        return userProfileDAO.findAll();
    }
}

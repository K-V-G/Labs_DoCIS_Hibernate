package ru.repository;

import ru.models.UserProfile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface UserProfileDAO {
    List<UserProfile> findAll();

    UserProfile findByType(String type);


    UserProfile findById(int id);

}

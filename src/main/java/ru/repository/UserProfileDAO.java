package ru.repository;

import ru.models.UserProfile;

import java.util.List;

public interface UserProfileDAO {
    List<UserProfile> findAll();

    UserProfile findByType(String type);

    List<UserProfile> findByTypeUser(String type);

    UserProfile findById(int id);

}

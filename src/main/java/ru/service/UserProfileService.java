package ru.service;
import ru.models.UserProfile;
import ru.repository.UserProfileDAO;

import java.util.List;

public interface UserProfileService {

    UserProfile findById(int id);

    UserProfile findByType(String type);

    List<UserProfile> findByTypeUser(String type);

    List<UserProfile> findAll();

}

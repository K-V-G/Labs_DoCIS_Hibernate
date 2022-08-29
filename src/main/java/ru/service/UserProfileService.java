package ru.service;
import ru.models.UserProfile;
import ru.repository.UserProfileDAO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface UserProfileService {

    UserProfile findById(int id);

    UserProfile findByType(String type);

    List<UserProfile> findAll();

}

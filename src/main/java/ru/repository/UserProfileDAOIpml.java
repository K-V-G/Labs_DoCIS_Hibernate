package ru.repository;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.models.UserProfile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserProfileDAOIpml extends AbstractDAO<Integer, UserProfile> implements UserProfileDAO{

    @Override
    @SuppressWarnings("unchecked")
    public List<UserProfile> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("type"));
        return (List<UserProfile>) criteria.list();
    }

    @Override
    public UserProfile findByType(String type) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("type", type));
        return (UserProfile) criteria.uniqueResult();
    }

    @Override
    public UserProfile findById(int id) {
        return getByKey(id);
    }
}

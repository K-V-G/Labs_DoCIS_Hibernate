/*
package ru.repository;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.models.UserInfo;

import java.util.List;

@Repository
public class UserDAOImpl extends AbstractDAO<Integer, UserInfo> implements UserDAO{

    @Override
    public UserInfo findById(int id) {
        UserInfo userInfo = getByKey(id);
        if(userInfo != null) {
            Hibernate.initialize(userInfo.getUserProfiles());
        }
        return userInfo;
    }

    @Override
    public UserInfo findByUserName(String username) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        UserInfo userInfo = (UserInfo) criteria.uniqueResult();
        if (userInfo != null) {
            Hibernate.initialize(userInfo.getUserProfiles());
        }
        return userInfo;
     }

    @Override
    public void save(UserInfo user) {
        persist(user);
    }

    @Override
    public void deleteByUserName(String username) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        UserInfo userInfo = (UserInfo) criteria.uniqueResult();
        delete(userInfo);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UserInfo> findAllUsers() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<UserInfo>) criteria.list();
    }
}
*/

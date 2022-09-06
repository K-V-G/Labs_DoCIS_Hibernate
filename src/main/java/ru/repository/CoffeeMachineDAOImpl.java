package ru.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.models.coffeeMachine;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CoffeeMachineDAOImpl implements coffeeMachineDAO{
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void saveCoffeeMachine(coffeeMachine coffeeMachine) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(coffeeMachine);
    }

    @Override
    public List<coffeeMachine> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<coffeeMachine> coffeeMachineCriteriaQuery =
                criteriaBuilder.createQuery(coffeeMachine.class);
        Root<coffeeMachine> root = coffeeMachineCriteriaQuery.from(coffeeMachine.class);
        coffeeMachineCriteriaQuery.select(root);
        Query query = session.createQuery(coffeeMachineCriteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<coffeeMachine> findAllReqest() {
        Session session = sessionFactory.openSession();
        List result = session.createSQLQuery("SELECT * FROM coffeeMachine4 WHERE sortOfCoffee = 'arabica' OR " +
                        "sortOfCoffee = 'Arabica' AND kindOfMilk = 'soy milk' OR kindOfMilk = 'Soy milk' " +
                        "AND amountOfDrink >= 0.5 AND amountOfDrink <=1.0")
                .addEntity(coffeeMachine.class).list();
        return result;
    }


    @Override
    public coffeeMachine getCoffeeMachine(int id) {
        Session session = sessionFactory.getCurrentSession();
        coffeeMachine coffeeMachine = session.get(coffeeMachine.class, id);
        return coffeeMachine;
    }

    @Override
    public void deleteCoffeeMachine(int id) {
        Session session = sessionFactory.getCurrentSession();
        coffeeMachine coffeeMachine = session.byId(coffeeMachine.class).load(id);
        session.delete(coffeeMachine);
    }

}

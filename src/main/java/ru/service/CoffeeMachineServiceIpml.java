package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.models.coffeeMachine;
import ru.repository.coffeeMachineDAO;

import java.util.List;
@Service
public class CoffeeMachineServiceIpml implements coffeeMachineService{

    @Autowired
    private coffeeMachineDAO coffeeMachineDAO;

    @Override
    @Transactional
    public void saveCoffeeMachine(coffeeMachine coffeeMachine) {
        coffeeMachineDAO.saveCoffeeMachine(coffeeMachine);
    }

    @Override
    @Transactional
    public List<coffeeMachine> findAll() {
        return coffeeMachineDAO.findAll();
    }

    @Override
    @Transactional
    public coffeeMachine getCoffeeMachine(int id) {
        return coffeeMachineDAO.getCoffeeMachine(id);
    }

    @Override
    @Transactional
    public void deleteCoffeeMachine(int id) {
        coffeeMachineDAO.deleteCoffeeMachine(id);
    }

    @Override
    public List<coffeeMachine> findAllReqest() {
        return coffeeMachineDAO.findAllReqest();
    }
}
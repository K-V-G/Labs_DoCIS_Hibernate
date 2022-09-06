package ru.service;

import ru.models.coffeeMachine;

import java.util.List;

public interface coffeeMachineService {
    void saveCoffeeMachine(coffeeMachine coffeeMachine);

    List<coffeeMachine> findAll();

    coffeeMachine getCoffeeMachine(int id);

    void deleteCoffeeMachine(int id);

    List<coffeeMachine> findAllReqest();


}

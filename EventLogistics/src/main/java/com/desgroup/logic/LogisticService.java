package com.desgroup.logic;

import java.util.List;

import com.desgroup.models.Logistic;
import com.desgroup.repositories.LogisticRepository;

public class LogisticService {

    private LogisticRepository repository;

    public LogisticService() {
        repository = new LogisticRepository();
    }

    public List<Logistic> getAllLogistics() {
        return repository.getAll();
    }

    public Logistic getLogisticById(int id) {
        return repository.getById(id);
    }

    public void createLogistic(String name, String email, int phone, String position, String zone, String role,
            String password) {
        Logistic logistic = new Logistic(name, email, phone, position, zone, role, password);
        repository.create(logistic);
    }

    public void updatedLogistic(String name, String email, int phone, String position, String zone, String role,
            String password) {
        Logistic logistic = new Logistic(name, email, phone, position, zone, role, password);
        repository.updated(logistic);
    }

    public void deleteLogistic(int id) {
        repository.delete(id);
    }

    public void recordHoursWorked(int id, int hours) {
        Logistic searchLogistic = repository.getById(id);
        searchLogistic.setWorkingHours(hours);
        repository.updated(searchLogistic);
    }
}

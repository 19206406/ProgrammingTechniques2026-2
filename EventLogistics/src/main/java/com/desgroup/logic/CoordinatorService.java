package com.desgroup.logic;

import java.util.List;

import com.desgroup.interfaces.IStaffSalary;
import com.desgroup.models.EventAssignment;
import com.desgroup.repositories.CoordinatorRepository;
import com.desgroup.repositories.EventAssignmentRepository;

public class CoordinatorService implements IStaffSalary {

    private CoordinatorRepository repository;
    private EventAssignmentRepository assignmentRepository;
    private double priceAssignment;

    public CoordinatorService() {
        repository = new CoordinatorRepository();
        assignmentRepository = new EventAssignmentRepository();
        priceAssignment = 400000.00;
    }

    @Override
    public double calculateSalary(int id) {
        List<EventAssignment> assignments = assignmentRepository.getAllByStaff(id);

        return priceAssignment * assignments.size();
    }

}

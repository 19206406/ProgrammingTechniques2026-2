package com.desgroup.repositories;

import java.util.ArrayList;
import java.util.List;

import com.desgroup.models.Event;
import com.desgroup.models.EventAssignment;

public class EventAssignmentRepository {
    private List<EventAssignment> assignments;
    private int nextId;

    public EventAssignmentRepository() {
        assignments = new ArrayList<>();
        nextId = 0;
    }

    public List<EventAssignment> getAll() {
        return new ArrayList<>(assignments);
    }

    public EventAssignment getById(int id) {
        for (EventAssignment assignment : assignments) {
            if (assignment.getIdEvent() == id) {
                return assignment;
            }
        }

        return null;
    }

    public List<EventAssignment> getAllByStaff(int staffId) {
        List<EventAssignment> assignmentsByStaffId = new ArrayList<>();

        for (EventAssignment assignment : assignments) {
            if (assignment.getIdStaff() == staffId) {
                assignmentsByStaffId.add(assignment);
            }
        }

        return assignmentsByStaffId;
    }

    public void create(EventAssignment assignment) {
        assignment.setIdEvent(nextId++); // agregar id antes de agregar
        assignments.add(assignment); // agregar
    }

    public void updated(EventAssignment assignment) {
        for (int i = 0; i < assignments.size(); i++) {
            if (assignments.get(i).getIdEvent() == assignment.getIdEvent()) {
                assignments.set(i, assignment);
                return;
            }
        }
    }

    public void delete(int id) {
        assignments.removeIf(l -> l.getIdAssignment() == id);
    }
}

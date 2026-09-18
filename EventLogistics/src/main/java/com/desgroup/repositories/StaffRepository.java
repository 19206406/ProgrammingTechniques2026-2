/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desgroup.repositories;

import com.desgroup.models.Staff;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author urreg
 */
public class StaffRepository {
    private List<Staff> staffs;
    private int staffId;

    public StaffRepository() {
        staffs = new ArrayList<>();
        staffId = 1;
    }

    public List<Staff> getAllStaff() {
        return new ArrayList<>(staffs);
    }

    public Staff getStaffById(int id) {
        for (Staff staff : staffs) {
            if (staff.getIdStaff() == id) {
                return staff;
            }
        }

        return null;
    }

}

package DAO;

import Models.Department;
import Models.Doctor;
import Models.Hospital;

import java.util.List;

public interface DoctorDAO<T> {
    void add(T o1, Doctor o2);
    void delete(int index1, T index2);
    void update(T index1, Integer index2, Doctor o);
    Hospital get(int n);
    List<Hospital> getAll();
}

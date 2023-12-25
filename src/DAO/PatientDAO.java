package DAO;

import Models.Department;
import Models.Hospital;
import Models.Patient;

import java.util.List;

public interface PatientDAO<T> {
    Hospital get(int n);
    List<Hospital> getAll();
    void add(int o1, Patient o2);
    void delete(int index1, int index2);
    void update(int index1, Integer index2, Patient o);
}

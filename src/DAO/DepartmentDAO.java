package DAO;

import Models.Department;
import Models.Hospital;

import java.util.List;

public interface DepartmentDAO<T> {
    Hospital get(int n);
    List<Hospital> getAll();
    void add(T o1, Department o2);
    void delete(int index1, T index2);
    void update(T index1, Integer index2, Department o);

}

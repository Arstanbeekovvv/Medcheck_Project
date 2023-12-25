package DAO;

import Models.Hospital;

import java.util.List;

public interface HospitalDAO<Hospital> {
    Hospital get(int n);
    List<Hospital> getAll();
    boolean add(Models.Hospital o);
    void delete(int index);

}

package DAO.Impl;

import DAO.DoctorDAO;
import DataBase.DB;
import Models.Department;
import Models.Doctor;
import Models.Gnrted;
import Models.Hospital;

import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {
    DB db;

    public DoctorDAOImpl() {
    }

    public DoctorDAOImpl(DB db) {
        this.db = db;
    }

    @Override
    public void add(Object o1, Doctor o2) {
        o2.setId(Gnrted.uniqueId());
        db.getHospitals().get((int)o1).getDoctors().add(o2);
    }

    @Override
    public void delete(int index1, Object index2) {
        db.getHospitals().get(index1).getDoctors().remove(index2);
    }

    @Override
    public void update(Object index1, Integer index2, Doctor o) {
        o.setId(Gnrted.uniqueId());
        db.getHospitals().get((Integer)index1).getDoctors().set(index2, o);
    }

    @Override
    public Hospital get(int n) {
        return db.getHospitals().get(n);
    }

    @Override
    public List<Hospital> getAll() {
        return db.getHospitals();
    }

}

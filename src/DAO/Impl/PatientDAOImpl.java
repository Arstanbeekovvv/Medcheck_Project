package DAO.Impl;

import DAO.PatientDAO;
import DataBase.DB;
import Models.Gnrted;
import Models.Hospital;
import Models.Patient;

import java.util.List;

public class PatientDAOImpl implements PatientDAO {
    DB db;

    public PatientDAOImpl(DB db) {
        this.db = db;
    }

    public PatientDAOImpl() {
    }


    @Override
    public Hospital get(int n) {
        return db.getHospitals().get(n);
    }

    @Override
    public List<Hospital> getAll() {
        return db.getHospitals();
    }

    @Override
    public void add(int o1, Patient o2) {
        o2.setId(Gnrted.uniqueId());
        db.getHospitals().get(o1).getPatients().add(o2);
    }

    @Override
    public void delete(int index1, int index2) {
        db.getHospitals().get(index1).getPatients().remove(index2);
    }

    @Override
    public void update(int index1, Integer index2, Patient o) {
        o.setId(Gnrted.uniqueId());
        db.getHospitals().get((Integer)index1).getPatients().set(index2, o);
    }
}

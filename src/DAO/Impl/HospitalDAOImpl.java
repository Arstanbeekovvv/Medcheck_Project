package DAO.Impl;

import DAO.HospitalDAO;
import DataBase.DB;
import Models.Gnrted;
import Models.Hospital;

import java.util.List;

public class HospitalDAOImpl implements HospitalDAO {
    DB db;

    public HospitalDAOImpl(DB db) {
        this.db = db;
    }

    public HospitalDAOImpl() {
    }


    @Override
    public Hospital get(int index) {
        return db.getHospitals().get(index);
    }

    @Override
    public List<Hospital> getAll() {
        return db.getHospitals();
    }

    @Override
    public boolean add(Hospital o) {
        o.setId(Gnrted.uniqueId());
        return db.getHospitals().add(o);
    }

    @Override
    public void delete(int index) {
        db.getHospitals().remove(index);
    }


}

package DAO.Impl;

import DAO.DepartmentDAO;
import DataBase.DB;
import Models.Department;
import Models.Doctor;
import Models.Gnrted;
import Models.Hospital;

import javax.annotation.processing.Generated;
import java.lang.module.FindException;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    DB db;

    public DepartmentDAOImpl() {
    }

    public DepartmentDAOImpl(DB db) {
        this.db = db;
    }

    @Override
    public void add(Object o1, Department o2) {
        o2.setId(Gnrted.uniqueId());
        db.getHospitals().get((int)o1).getDepartments().add(o2);
    }

    @Override
    public void delete(int index1, Object index2) {
        db.getHospitals().get(index1).getDepartments().remove(index2);
    }

    @Override
    public void update(Object index1, Integer index2, Department o) {
        o.setId(Gnrted.uniqueId());
        db.getHospitals().get((Integer)index1).getDepartments().set(index2, o);
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

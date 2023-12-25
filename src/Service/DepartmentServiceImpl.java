package Service;

import DAO.Impl.DepartmentDAOImpl;
import DAO.Impl.HospitalDAOImpl;
import Models.Department;
import Models.Hospital;

import java.util.List;

public class DepartmentServiceImpl implements ZDepartmentService{
    DepartmentDAOImpl departmentDAO;
//**********************************************************************************************************************
    public DepartmentServiceImpl(DepartmentDAOImpl departmentDAO) {
        this.departmentDAO = departmentDAO;
    }
//**********************************************************************************************************************
    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        try {
            List<Hospital> all = departmentDAO.getAll();
            for (int i = 0; i < all.size(); i++) {
                if (all.get(i).getId().equals(id)) {
                    System.out.println("Successful get all Department by hospital ✅");
                    return departmentDAO.get(i).getDepartments();
                }
            }
            throw new NullPointerException();
        }catch (NullPointerException npe){
            System.out.println("List hospital is null! ");
        }
        System.out.println("Not successful get all Department by hospital !");
        return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        for (int i = 0; i < departmentDAO.getAll().size(); i++) {
            for (int i1 = 0; i1 < departmentDAO.get(i).getDepartments().size(); i1++) {
                for (Department department : departmentDAO.get(i).getDepartments()) {
                    if(department.getDepartmentName().equalsIgnoreCase(name)){
                        System.out.println("Successful find department by Name ✅");
                        return department;
                    }
                }
            }
        }
        System.out.println("Not successful find department by name ❗");
        return null;
    }

    @Override
    public String add(Long hospitalId, Department o) {
        for (int i = 0; i < departmentDAO.getAll().size(); i++) {
            if(departmentDAO.get(i).getId().equals(hospitalId)){
                departmentDAO.add(i, o);
                return ("Successful add department ✅");
            }
        }
        return "Not successful add department !";
    }

    @Override
    public void removeById(Long id) {
        for (int i = 0; i < departmentDAO.getAll().size(); i++) {
            for (int i1 = 0; i1 < departmentDAO.get(i).getDepartments().size(); i1++) {
                if(departmentDAO.get(i).getDepartments().get(i1).getId().equals(id)){
                    departmentDAO.delete(i, i1);
                    System.out.println("Successful remove department ✅");
                    return;
                }
            }
        }
        System.out.println("Not successful add department !");
    }

    @Override
    public String updateById(Long id, Department o) {
        for (int i = 0; i < departmentDAO.getAll().size(); i++) {
            for (int i1 = 0; i1 < departmentDAO.get(i).getDepartments().size(); i1++) {
                if(departmentDAO.get(i).getDepartments().get(i1).getId().equals(id)){
                    departmentDAO.update(i, i1, o);
                    return ("Successful update by id department ✅");
                }
            }
        }
        return "Not successful add department !";
    }
}

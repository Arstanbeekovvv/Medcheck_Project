package Service;

import Models.Department;

import java.util.List;

public interface ZDepartmentService extends ZGenericService<Department>{
    List<Department> getAllDepartmentByHospital(Long id);
    Department findDepartmentByName(String name);
}

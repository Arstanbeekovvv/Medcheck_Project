package Models;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private Long id;
    private String departmentName;
    private List<Doctor> doctors = new ArrayList<>();
//**********************************************************************************************************************
    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
    public Department() {
    }
//**********************************************************************************************************************
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public List<Doctor> getDoctors() {
        return doctors;
    }
    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
//**********************************************************************************************************************
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", doctors=" + doctors +
                '}';
    }
//**********************************************************************************************************************

}

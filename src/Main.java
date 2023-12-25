import DAO.Impl.DepartmentDAOImpl;
import DAO.Impl.DoctorDAOImpl;
import DAO.Impl.HospitalDAOImpl;
import DAO.Impl.PatientDAOImpl;
import DataBase.DB;
import Enums.Gender;
import Models.Department;
import Models.Doctor;
import Models.Hospital;
import Models.Patient;
import Service.DepartmentServiceImpl;
import Service.DoctorServiceImpl;
import Service.HospitalServiceImpl;
import Service.PatientServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.lang.StringTemplate.STR;

public class Main {
    public static void main(String[] args) {
        DB db = new DB();

        DepartmentServiceImpl dsi = new DepartmentServiceImpl(new DepartmentDAOImpl(db));
        DoctorServiceImpl dsi2 = new DoctorServiceImpl(new DoctorDAOImpl(db));
        HospitalServiceImpl hsi = new HospitalServiceImpl(new HospitalDAOImpl(db));
        PatientServiceImpl psi = new PatientServiceImpl(new PatientDAOImpl(db));
        myCommand(dsi, dsi2, hsi, psi);
    }
    public static void myCommand( DepartmentServiceImpl dsi, DoctorServiceImpl dsi2, HospitalServiceImpl hsi, PatientServiceImpl psi){
        int n = 0;
        while (true) {
            System.out.print("""
                            Hospital Service                                        DepartmentService:          *
                *   "1" -> addHospital;                      *           "11" -> add;                           *
                *   "2" -> findHospitalById;                 *           "12" -> removeById;                    *
                *   "3" -> getAllHospital;                   *           "13" -> updateById;                    *
                *   "4" -> getAllPatientFromHospital;        *           "14" -> getAllDepartmentByHospital;    *
                *   "5" -> deleteHospitalById;               *           "15" -> findDepartmentByName;          *
                *   "6" -> getAllHospitalByAddress;          *                                                  *
                *   "0" -> {return;}                         *                                                  *
                * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
                *          DoctorService:                    *                       PatientService:            *
                *   "21" -> add();                           *          "31" -> add();                          *
                *   "22" -> removeById();                    *          "32" -> removeById();                   *
                *   "23" -> updateById();                    *          "33" -> updateById();                   *
                *   "24" -> findDoctorById();                *          "34" -> addPatientsToHospital();        *
                *   "25" -> assignDoctorToDepartment();      *          "35" -> getPatientById();               *
                *   "26" -> getAllDoctorsByHospitalId();     *          "36" -> getPatientByAge();              *
                *   "27" -> getAllDoctorsByDepartmentId();   *          "37" -> sortPatientsByAge();            *
                       Your Choice: ->""");
            switch (new Scanner(System.in).nextLine()) {
                //HospitalService :
                case "1" -> System.out.println(hsi.addHospital(new Hospital("1", "Grazhdanskaya 119")));
                case "2" -> {
                    Hospital hospitalById = hsi.findHospitalById(1L);
                    if(hospitalById != null) System.out.println(hospitalById + "Successful find hospital by id ✅");
                }
                case "3" -> {
                    List<Hospital> allHospital = hsi.getAllHospital();
                    if(allHospital != null) System.out.println(allHospital + "Successful get all hospital ✅");
                }
                case "4" -> {
                    List<Patient> allPatientFromHospital = hsi.getAllPatientFromHospital(1L);
                    if(allPatientFromHospital != null) System.out.println(allPatientFromHospital + "\nSuccessful get all patient by hospital id ✅");
                    else System.out.println("List patient is null!!!");
                }
                case "5" -> System.out.println(hsi.deleteHospitalById(1L));
                case "6" -> {
                    try {
                        Map<String, Hospital> allHospitalByAddress = hsi.getAllHospitalByAddress("Grazhdanskaya 119");
                        System.out.println(allHospitalByAddress + "\nSuccessful get all hospital by address ✅");
                    }catch (NullPointerException npe){
                        System.out.println("Null point exception! ");
                    }
                }
                case "0" -> {
                    return;
                }

                //DepartmentService:
                case "11" -> System.out.println(dsi.add(1L, new Department(STR."\{n++}")));
                case "12" -> dsi.removeById(3L);
                case "13" -> System.out.println(dsi.updateById(3L, new Department("New Department")));
                case "14" -> System.out.println(dsi.getAllDepartmentByHospital(1L));
                case "15" -> System.out.println(dsi.findDepartmentByName("New Department"));

                //DoctorService:
                case "21" -> System.out.println(dsi2.add(1L, new Doctor()));
                case "22" -> dsi2.removeById(1L);
                case "23" -> System.out.println(dsi2.updateById(1L, new Doctor()));
                case "24" -> System.out.println(dsi2.findDoctorById(1L));
                case "25" -> dsi2.assignDoctorToDepartment(1L, new ArrayList<>());
                case "26" -> System.out.println(dsi2.getAllDoctorsByHospitalId(1L));
                case "27" -> System.out.println(dsi2.getAllDoctorsByDepartmentId(1L));


                //PatientService:
                case "31" -> System.out.println(psi.add(1L, new Patient("Mirlan", "Arstanbekov", 21,Gender.MALE)));
                case "32" -> psi.removeById(1L);
                case "33" -> System.out.println(psi.updateById(1L, new Patient()));
                case "34" -> System.out.println(psi.addPatientsToHospital(1L, new ArrayList<>(List.of(new Patient(), new Patient()))));
                case "35" -> System.out.println(psi.getPatientById(1L));
                case "36" -> System.out.println(psi.getPatientByAge());
                case "37" -> System.out.println(psi.sortPatientsByAge("desc"));
                default -> System.out.println("Siz bizde jok commandany terdiniz!");
            }
        }
    }
}
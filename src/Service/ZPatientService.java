package Service;
import Models.Hospital;
import Models.Patient;

import java.util.List;
import java.util.Map;
public interface ZPatientService extends ZGenericService<Patient> {
    String addPatientsToHospital(Long id,List<Patient> patients);
    Patient getPatientById(Long id);
    Map<Integer, List<Patient>> getPatientByAge();
    List<Patient> sortPatientsByAge(String ascOrDesc);
}

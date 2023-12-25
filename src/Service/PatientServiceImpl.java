package Service;

import DAO.Impl.PatientDAOImpl;
import Models.Hospital;
import Models.Patient;

import java.util.*;

public class PatientServiceImpl implements ZPatientService{
    private final PatientDAOImpl patientDAO;

    public PatientServiceImpl(PatientDAOImpl patientDAO) {
        this.patientDAO = patientDAO;
    }

    //**********************************************************************************************************************


    @Override
    public String add(Long hospitalId, Patient patient) {
        System.out.println(patientDAO.get(0));
        for (int i = 0; i < patientDAO.getAll().size(); i++) {
            if(patientDAO.get(i).getId().equals(hospitalId)){
                patientDAO.add(i, patient);
                return "Successful add patient ✅";
            }
        }
        return "Not successful add patient !";
    }

    @Override
    public String updateById(Long id, Patient patient) {
        for (int i = 0; i < patientDAO.getAll().size(); i++) {
            for (int i1 = 0; i1 < patientDAO.get(i).getPatients().size(); i1++) {
                if(patientDAO.get(i).getPatients().get(i1).getId().equals(id)){
                    patientDAO.update(i, i1, patient);
                    return "Successful update by id ✅";
                }
            }
        }
        return "Not find patient by id !!!";
    }

    @Override
    public void removeById(Long id) {
        for (int i = 0; i < patientDAO.getAll().size(); i++) {
            for (int i1 = 0; i1 < patientDAO.get(i).getPatients().size(); i1++) {
                if(patientDAO.get(i).getPatients().get(i1).getId().equals(id)){
                    patientDAO.delete(i, i1);
                    System.out.println("Successful remove by id ✅");
                    return;
                }
            }
        }
        System.out.println("Not successful remove by id !!!");
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        for (int i = 0; i < patientDAO.getAll().size(); i++) {
            if(patientDAO.get(i).getId().equals(id)){
                for (Patient patient : patients) {
                    patientDAO.add(i, patient);
                }
                return ("Successful add patients to hospital ✅");
            }
        }
        return "NOT successful ad patents to hospital !";
    }

    @Override
    public Patient getPatientById(Long id) {
        for (Hospital hospital : patientDAO.getAll()) {
            for (Patient patient : hospital.getPatients()) {
                if(patient.getId().equals(id)){
                    System.out.println("Successful get patient by id ✅");
                    return patient;
                }
            }
        }
        System.out.println("Not successful get patient by id !!!");
        return null;
    }

    @Override
    public Map<Integer, List<Patient>> getPatientByAge() {
        List<Patient> patients = new ArrayList<>();
        for (Hospital hospital : patientDAO.getAll()) {
            patients.addAll(hospital.getPatients());
        }

        Map<Integer, Patient> treeMap = new TreeMap<>();
        for (Patient st : patients) {
            treeMap.put(st.getAge(), st);
        }

        Map<Integer, List<Patient>> sort = new HashMap<>();
        for (int i = 0; i < patients.size(); i++) {
            List<Patient> names = new ArrayList<>();
            names.add(patients.get(i));
            for (int j = i+1; j < patients.size(); j++) {
                if (patients.get(i).getAge() == patients.get(j).getAge()) {
                    names.add(patients.get(j));
                }
            }
            if(!sort.containsKey(patients.get(i).getAge())){
                sort.put(patients.get(i).getAge(), names);
            }
        }
        System.out.println("Successful get patient by age ✅");
        return sort;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        List<Patient> patients = new ArrayList<>();
        for (Hospital hospital : patientDAO.getAll()) {
            patients.addAll(hospital.getPatients());
        }
        if(ascOrDesc.equalsIgnoreCase("asc")){
            patients.sort(sortPatientsByAge);
            System.out.println("Successful sort patients by age to ASC ✅");
            return patients;
        } else if (ascOrDesc.equalsIgnoreCase("desc")) {
            patients.sort(sortPatientsByAge.reversed());
            System.out.println("Successful sort patients by age to DESC ✅");
            return patients;
        }
        System.out.println("Not successful sot patients by age !!!");
        return null;
    }
    public static Comparator<Patient> sortPatientsByAge = ((o1, o2) -> o1.getAge() - o2.getAge());
}

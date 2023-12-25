package Service;

import DAO.Impl.HospitalDAOImpl;
import Models.Hospital;
import Models.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements ZHospitalService{
    private final HospitalDAOImpl DAOHospital;

    public HospitalServiceImpl(HospitalDAOImpl daoHospital) {
        DAOHospital = daoHospital;
    }

    @Override
    public String addHospital(Hospital hospital) {
        boolean add = DAOHospital.add(hospital);
        if(add){
            return "Successful add hospital ✅";
        }
        System.out.println(DAOHospital.getAll());
        return "Not successful add hospital !";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        List<Hospital> all = DAOHospital.getAll();
        for (int i = 0; i < all.size(); i++) {
            if(all.get(i).getId().equals(id)){
                return DAOHospital.get(i);
            }
        }
        System.out.println("Not find hospital by id !");
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return DAOHospital.getAll();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        try {
            List<Hospital> all = DAOHospital.getAll();
            for (Hospital hospital : all) {
                if (hospital.getId().equals(id)) {
                    return hospital.getPatients();
                }
            }
        }catch (NullPointerException npe){
            System.out.println("Null point Exception");
        }
        System.out.println("Not find hospital by id, for get all patient from Hospital !!!");
        return null;
    }

    @Override
    public String deleteHospitalById(Long id) {
        List<Hospital> all = DAOHospital.getAll();
        for (int i = 0; i < all.size(); i++) {
            if(all.get(i).getId().equals(id)){
                DAOHospital.delete(i);
                return "Successful delete hospital by id ✅";
            }
        }
        return "Not successful delete hospital by id ❗";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String, Hospital> hospitalMap = new HashMap<>();
        for (Hospital hospital : DAOHospital.getAll()) {
            if(hospital.getAddress().equalsIgnoreCase(address)){
                hospitalMap.put(address, hospital);
            }
        }
        return hospitalMap;
    }
}

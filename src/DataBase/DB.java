package DataBase;

import Models.Hospital;

import java.util.ArrayList;
import java.util.List;

public class DB {
    private List<Hospital> hospitals = new ArrayList<>();
//**********************************************************************************************************************
    public List<Hospital> getHospitals() {
        return hospitals;
    }
    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }
//**********************************************************************************************************************
    public DB() {
    }
    public DB(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }
//**********************************************************************************************************************

}

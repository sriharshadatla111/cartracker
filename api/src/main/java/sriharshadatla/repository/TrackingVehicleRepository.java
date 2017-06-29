package sriharshadatla.repository;

import sriharshadatla.entity.Reading;
import sriharshadatla.entity.Vehicle;

import java.util.List;


public interface TrackingVehicleRepository {



    //this is to do the operation on vehicle entity
    Vehicle createVehicle(Vehicle vehicle);
    Vehicle findOneVehicle(String vinid);
    List<Vehicle> findAllVehicles();
    Vehicle updateVehicle(Vehicle vehicle);
    void deleteVehicle(Vehicle vehicle);

}

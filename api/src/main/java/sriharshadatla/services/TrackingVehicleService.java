package sriharshadatla.services;

import sriharshadatla.entity.Reading;
import org.springframework.stereotype.Component;
import sriharshadatla.entity.Vehicle;

import java.util.List;

@Component
public interface TrackingVehicleService {

   //this is to do the operation on vehicle entity
    Vehicle createVehicle(Vehicle vehicle);
    Vehicle findOneVehicle(String vinid);
    List<Vehicle> findAllVehicles();
    List<Vehicle> updateVehicle(List<Vehicle> vehicles);
    void deleteVehicle(String vinid);

}

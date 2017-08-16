package sriharshadatla.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sriharshadatla.entity.Vehicle;
import sriharshadatla.exception.BadRequestException;
import sriharshadatla.exception.ResourceNotFoundException;
import sriharshadatla.repository.TrackingVehicleRepository;

import java.util.List;

@Service
public class TrackingVehicleServiceImpl implements TrackingVehicleService {

    @Autowired
    TrackingVehicleRepository trackingRepository;

    @Transactional
    public Vehicle createVehicle(Vehicle vehicle) {
        Vehicle exist = trackingRepository.findOneVehicle(vehicle.getVin());
        if(exist == null)
        {
            return trackingRepository.createVehicle(vehicle);
        }
        else
        {
           throw new BadRequestException("vehicle already present");
        }
    }

    public Vehicle findOneVehicle(String vinid) {
        Vehicle exist = trackingRepository.findOneVehicle(vinid);
        if(exist!=null)
        {
            return exist;
        }
        else
        {
            throw new ResourceNotFoundException("Vehicle not present");
        }
    }

    public List<Vehicle> findAllVehicles() {
        List<Vehicle> allvehicles = trackingRepository.findAllVehicles();
        if(allvehicles.size()!=0)
        return allvehicles;
        else
            throw new ResourceNotFoundException("No Vehicle is present in the database");
    }

    @Transactional
    public List<Vehicle> updateVehicle(List<Vehicle> vehicles) {

        for(Vehicle vehicle : vehicles)
        {
            Vehicle exist = trackingRepository.findOneVehicle(vehicle.getVin());
            if(exist == null)
            {
                trackingRepository.createVehicle(vehicle);
            }
            else
            {
                trackingRepository.updateVehicle(vehicle);
            }
        }

        return vehicles;
    }

    @Transactional
    public void deleteVehicle(String vinid) {
        Vehicle exist = trackingRepository.findOneVehicle(vinid);
        if(exist==null)
        {
            throw  new BadRequestException("Requested resource is not found to delete.");
        }
        else
        trackingRepository.deleteVehicle(exist);
    }
}

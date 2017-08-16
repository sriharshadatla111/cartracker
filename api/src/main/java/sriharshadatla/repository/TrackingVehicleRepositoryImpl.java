package sriharshadatla.repository;

import sriharshadatla.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TrackingVehicleRepositoryImpl implements TrackingVehicleRepository {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    TrackingVehicleRepository trackingRepository;

    public Vehicle createVehicle(Vehicle vehicle) {
       System.out.println("enterd trackingrepository implementation");
        em.persist(vehicle);
        return vehicle;
    }

    public Vehicle findOneVehicle(String vinid) {


        TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.findone",Vehicle.class);
        query.setParameter("paramVin",vinid);

        List<Vehicle> listofvehicles = query.getResultList();

        if(listofvehicles.size()==1)
        {
            return listofvehicles.get(0);
        }
        else
        {
            return null;
        }
    }

    public List<Vehicle> findAllVehicles() {
        TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.findAll",Vehicle.class);
        List<Vehicle> allvehicles = query.getResultList();
        return allvehicles;
    }

    public Vehicle updateVehicle(Vehicle vehicle) {
        em.merge(vehicle);
        return vehicle;
    }

    public void deleteVehicle(Vehicle v) {
        em.remove(v);
    }
}

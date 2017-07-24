package sriharshadatla.repository;


import org.springframework.stereotype.Repository;
import sriharshadatla.entity.Alert;
import sriharshadatla.entity.VinAlertsStatistics;
import sriharshadatla.exception.ResourceNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class AlertRepositoryImpl implements AlertsRepository {

    @PersistenceContext
    EntityManager em;

    public Alert createAlert(Alert t) {
        em.persist(t);
        return t;
    }

    public List<Alert> getAllAlerts() {

        //variable to store the value of the currenttimestamp
        Timestamp ts = new Timestamp(System.currentTimeMillis()-7200000);
        TypedQuery<Alert> query = em.createNamedQuery("Alert.findAllHighAlerts",Alert.class);
        query.setParameter("paramalertTimeStamp",ts);
        List<Alert> list = query.getResultList();
        if(list!=null)
        {
         return list;
        }
        else
        {
            throw new ResourceNotFoundException("No Alerts are present in the database");
        }
    }

    public Alert getOneAlert(String alertID) {
        /*
        TypedQuery<Alert> query = em.createNamedQuery("Alert.findOne",Alert.class);
        query.setParameter("paramalertID",alertID);
        List<Alert> list = query.getResultList();

        if(list.size()==1 && list!=null)
        {
            return list.get(0);
        }
        else
        {
            return null;
        }*/
        return null;
    }


    public List<Alert> getAllAlertsByVin(String vin) {

        TypedQuery<Alert> query = em.createNamedQuery("Alert.findAllByVin",Alert.class);
        query.setParameter("alertparamVin",vin);

        List<Alert> list = query.getResultList();

        return list!=null?list:null;

    }
}

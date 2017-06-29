package sriharshadatla.repository;


import org.springframework.stereotype.Repository;
import sriharshadatla.entity.Alert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
        /*
        TypedQuery<Alert> query = em.createNamedQuery("Alert.findAll",Alert.class);
        List<Alert> list = query.getResultList();
        if(list!=null)
        {
         return list;
        }
        else
        {
            return null;
        }
        */
        return null;
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
}

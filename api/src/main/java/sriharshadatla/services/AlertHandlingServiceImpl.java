package sriharshadatla.services;


import org.springframework.beans.factory.annotation.Autowired;
import sriharshadatla.entity.Alert;
import sriharshadatla.repository.AlertsRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlertHandlingServiceImpl implements AlertHandlingService {

    @Autowired
    AlertsRepository alertsRepository;

    public Alert createAlert(Alert t) {
       return alertsRepository.createAlert(t);
    }

    public List<Alert> getAllAlerts() {

        List<Alert> list = alertsRepository.getAllAlerts();
        if(list!=null)
        {
            return list;
        }
        else
        {
            return null;
        }
    }

    public Alert getOneAlert(String alertID) {
        Alert alert = alertsRepository.getOneAlert(alertID);

        if(alert!=null)
        {
            return alert;
        }
        else
        {
            return null;
        }
    }



}

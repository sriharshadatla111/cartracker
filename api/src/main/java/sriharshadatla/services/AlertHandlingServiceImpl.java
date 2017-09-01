package sriharshadatla.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sriharshadatla.entity.Alert;
import sriharshadatla.repository.AlertsRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class AlertHandlingServiceImpl implements AlertHandlingService {

    @Autowired
    AlertsRepository alertsRepository;

    public Alert createAlert(Alert t) {
       return alertsRepository.createAlert(t);
    }

    public List<Alert> getAllAlerts() {

        List<Alert> list = alertsRepository.getAllAlerts();
       return list!=null?list:null;
    }


    public List<Alert> getAllAlertsByVin(String vin){
        List<Alert> list = alertsRepository.getAllAlertsByVin(vin);
        return list!=null?list:null;
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

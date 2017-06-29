package sriharshadatla.repository;


import sriharshadatla.entity.Alert;

import java.util.List;

public interface AlertsRepository {

    Alert createAlert(Alert t);


    //These methods are not implemented correctly, saved the task for the front end
    List<Alert> getAllAlerts();

    Alert getOneAlert(String alertID);


}

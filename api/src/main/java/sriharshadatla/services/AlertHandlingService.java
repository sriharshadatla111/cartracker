package sriharshadatla.services;


import sriharshadatla.entity.Alert;

import java.util.List;

public interface AlertHandlingService {


    Alert createAlert(Alert t);

    List<Alert> getAllAlerts();

    Alert getOneAlert(String alertID);


}

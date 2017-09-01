package sriharshadatla.repository;


import sriharshadatla.entity.Alert;
import java.util.List;

public interface AlertsRepository {

    Alert createAlert(Alert t);
    List<Alert> getAllAlerts();
    List<Alert> getAllAlertsByVin(String vin);
    Alert getOneAlert(String alertID);


}

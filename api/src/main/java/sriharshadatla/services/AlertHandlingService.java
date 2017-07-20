package sriharshadatla.services;


import org.springframework.stereotype.Component;
import sriharshadatla.entity.Alert;

import java.util.List;
@Component
public interface AlertHandlingService {


    Alert createAlert(Alert t);

    List<Alert> getAllAlerts();

    Alert getOneAlert(String alertID);


}

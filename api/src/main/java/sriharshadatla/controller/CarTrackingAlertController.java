package sriharshadatla.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sriharshadatla.entity.Alert;
import sriharshadatla.entity.Reading;
import sriharshadatla.services.AlertHandlingService;

import java.util.List;

@RestController
//@CrossOrigin(origins="http://localhost:3000",maxAge=3600)
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RequestMapping("/alerts")
public class CarTrackingAlertController {

    @Autowired
    AlertHandlingService alertHandlingService;
    @RequestMapping(method= RequestMethod.GET,value="/all/HIGH")
    public List<Alert> findAllAlerts(){
        return alertHandlingService.getAllAlerts();
    }
}

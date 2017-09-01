package sriharshadatla.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sriharshadatla.entity.Alert;
import sriharshadatla.entity.Reading;
import sriharshadatla.entity.Vehicle;
import sriharshadatla.exception.BadRequestException;
import sriharshadatla.exception.ResourceNotFoundException;
import sriharshadatla.services.AlertHandlingService;
import sriharshadatla.services.TrackingVehicleService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins={"http://localhost:3000","http://mocker.egen.io"},maxAge=3600)
@RequestMapping("/alerts")
public class CarTrackingAlertController {

    @Autowired
    AlertHandlingService alertHandlingService;

    @Autowired
    TrackingVehicleService trackingVehicleService;

    @RequestMapping(method= RequestMethod.GET,value="/HIGH/two_hours/all")
    public List<VinAlertsStatistics> findAllAlerts(){
        List<Alert> alerts = alertHandlingService.getAllAlerts();
        List<VinAlertsStatistics> resultlist=new ArrayList<VinAlertsStatistics>();
        for(Alert alert:alerts)
        {
            resultlist.add(new VinAlertsStatistics(alert.getVin(),alert.getCount()));
        }
       return resultlist;
    }

    @RequestMapping(method= RequestMethod.GET,value="/all/{vin}")
    public List<Alert> findAllAlertsByVin(@PathVariable("vin")String vin) {
        Vehicle v = trackingVehicleService.findOneVehicle(vin);
        if (v != null) {
            List<Alert> list = alertHandlingService.getAllAlertsByVin(vin);
            if (list != null)
                return list;
            else
                throw new ResourceNotFoundException("There are no alerts for this vehicle ");
        }
        else
            throw new BadRequestException("There is no vin in the database");
    }
}

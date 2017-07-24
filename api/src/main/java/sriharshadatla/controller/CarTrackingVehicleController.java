package sriharshadatla.controller;


import sriharshadatla.services.TrackingVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sriharshadatla.entity.Vehicle;

import java.util.List;

@CrossOrigin(origins={"http://localhost:3000","http://mocker.egen.io"},maxAge=3600)
@RestController
@RequestMapping("/vehicles")
public class CarTrackingVehicleController {

    @Autowired
    TrackingVehicleService trackingVehicleService;

    //this is to do the operation on vehicle entity
    @RequestMapping(method = RequestMethod.POST)
    public Vehicle createVehicle(@RequestBody Vehicle vehicle){
        return trackingVehicleService.createVehicle(vehicle);
    }

    @RequestMapping(method = RequestMethod.GET,value="/{vinid}")
    public Vehicle findOneVehicle(@PathVariable("vinid")String vinid){
        return trackingVehicleService.findOneVehicle(vinid);
    }

    /*This method is to handle GET Request to get all the vehicles*/
    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAllVehicles(){
        return trackingVehicleService.findAllVehicles();
    }

    /*This method is to put the vehicles details. (Here it does the operation of upsert ->Update is exists or Insert)*/
    @RequestMapping(method = RequestMethod.PUT)
    public List<Vehicle> updateVehicle(@RequestBody List<Vehicle> vehicles){
    return trackingVehicleService.updateVehicle(vehicles);
    }

    /*This method is to delete any vehicle details using VinId*/
    @RequestMapping(method = RequestMethod.DELETE,value="/{vinid}")
    public void deleteVehicle(@PathVariable("vinid") String vinid){
        trackingVehicleService.deleteVehicle(vinid);
    }

}

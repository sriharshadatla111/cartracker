package sriharshadatla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sriharshadatla.entity.Reading;
import sriharshadatla.entity.Tires;
import sriharshadatla.services.TrackingReadingService;
import sriharshadatla.services.TrackingVehicleService;

import java.util.List;

@CrossOrigin(origins={"http://localhost:3000","http://mocker.egen.io"},maxAge=3600)
@RestController
@RequestMapping("/readings")
public class CarTrackingReadingController {

    @Autowired
    TrackingReadingService trackingReadingService;

    /*This method is to insert the details of readings in the database*/
    @RequestMapping(method = RequestMethod.POST)
    public Reading createReading(@RequestBody Reading reading)
    {
        return trackingReadingService.createReading(reading);
    }

    /*This method is to insert the details of readings in the database*/
    @RequestMapping(method = RequestMethod.GET,value="/{readingID}")
    public Reading findOneReading(@PathVariable("readingID")String readingID)
    {
        return trackingReadingService.findOneReading(readingID);
    }

    /*This method is to get all the readings present in the database*/
    @RequestMapping(method = RequestMethod.GET)
    public List<Reading> findAllReading(){
        return trackingReadingService.findAllReading();
    }


    @RequestMapping(method = RequestMethod.PUT,value="/{id}")
    public Reading updateReading(String readingid,Reading reading){
        return trackingReadingService.updateReading(readingid,reading);
    }


    @RequestMapping(method = RequestMethod.DELETE,value="/{id}")
    public void deleteReading(@PathVariable("id")String readingID){
        trackingReadingService.deleteReading(readingID);
    }

}

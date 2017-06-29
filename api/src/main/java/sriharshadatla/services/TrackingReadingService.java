package sriharshadatla.services;

import org.springframework.stereotype.Component;
import sriharshadatla.entity.Reading;

import java.util.List;

@Component
public interface TrackingReadingService {

    //this is to do the operation on reading entity
    Reading createReading(Reading reading);
    Reading findOneReading(String vinid);
    List<Reading> findAllReading();
    Reading updateReading(String readingid,Reading reading);
    void deleteReading(String vinid);

}

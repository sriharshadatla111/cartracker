package sriharshadatla.repository;


import sriharshadatla.entity.Reading;

import java.util.List;

public interface TrackingReadingRepository {

    Reading createReading(Reading reading);
    Reading findOneReading(String readingID);
    List<Reading> findAllReading();
    Reading updateReading(Reading reading);
    void deleteReading(Reading reading);


}

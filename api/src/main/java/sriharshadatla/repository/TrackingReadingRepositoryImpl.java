package sriharshadatla.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sriharshadatla.entity.Reading;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TrackingReadingRepositoryImpl implements TrackingReadingRepository {


    @PersistenceContext
    private EntityManager em;


public Reading createReading(Reading reading) {
        em.persist(reading);
        return reading;
    }

    public Reading findOneReading(String readingID) {
        TypedQuery<Reading> query = em.createNamedQuery("Reading.findOneById",Reading.class);
        query.setParameter("paramReadingID",readingID);

        List<Reading> listofreadings = query.getResultList();

        if(listofreadings.size()!=0 && listofreadings.size()==1)
        {
            return listofreadings.get(0);
        }
        else
            return  null;
    }

    public List<Reading> findAllReading() {
        TypedQuery<Reading> query = em.createNamedQuery("Reading.findAll",Reading.class);
        List<Reading> listofreadings = query.getResultList();

        if(listofreadings.size()!=0)
        {
            return listofreadings;
        }
        else
            return  null;
    }

    public Reading updateReading(Reading reading) {
        return em.merge(reading);
    }

    public void deleteReading(Reading reading) {
        em.remove(reading);
    }







}

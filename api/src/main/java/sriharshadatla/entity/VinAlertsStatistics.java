package sriharshadatla.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;



public class VinAlertsStatistics {
    @JsonProperty("VIN")
    private String vin;
    @JsonProperty("highalertcount")
    private long count;

    public VinAlertsStatistics(String vin,long count){
        this.vin=vin;
        this.count=count;
    }


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}

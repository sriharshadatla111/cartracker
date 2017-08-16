package sriharshadatla.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;



@Entity
@NamedQueries({
        @NamedQuery(query = "select new sriharshadatla.entity.Alert(a.vin,count(a.alertLevel))from Alert a where a.alertLevel='HIGH' and a.alertTime>:paramalertTimeStamp group by a.vin",name = "Alert.findAllHighAlerts"),
        @NamedQuery(query = "select a from Alert a where a.vin=:alertparamVin order by a.alertTime desc ",name = "Alert.findAllByVin")
})
public class Alert {

    @Id
    private String alertID;
    public Alert() {
        this.alertID = UUID.randomUUID().toString();
    }
    private String vin;
    private String reason;
    private String alertLevel;
    @JsonProperty("alertTime")
    //@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss.sss")
    private Timestamp alertTime;//the datatype is not yet finalized, proceeding with the draft version
    private String useremail;

    @JsonIgnore
    @Transient
    private long count;


    public Alert(String vin, long count){
        this.vin=vin;
        this.count=count;
    }


    public String getAlertID() {
        return alertID;
    }


    public void setAlertID(String alertID) {
        this.alertID = alertID;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAlertLevel() {
        return alertLevel;
    }

    public void setAlertLevel(String alertLevel) {
        this.alertLevel = alertLevel;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss.sss'Z'")
    public Timestamp getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(Timestamp alertTime) {
        this.alertTime = alertTime;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}

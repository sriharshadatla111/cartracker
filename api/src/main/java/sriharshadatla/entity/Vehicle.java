package sriharshadatla.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "Vehicle.findAll",query = "select v from Vehicle v order by v.vin desc"),
        @NamedQuery(name = "Vehicle.findone",query = "select v from Vehicle v where v.vin=:paramVin"),
})
public class Vehicle {

        @Id
        private String vin;
        private String make;
        private String model;
        private short year;
        private int redlineRpm;
        private int maxFuelVolume;
        @JsonProperty("lastServiceDate")
        private Timestamp lastServiceDate;


        public String getVin() {
                return vin;
        }

        public void setVin(String vin) {
                this.vin = vin;
        }

        public String getMake() {
                return make;
        }

        public void setMake(String make) {
                this.make = make;
        }

        public String getModel() {
                return model;
        }

        public void setModel(String model) {
                this.model = model;
        }

        public short getYear() {
                return year;
        }

        public void setYear(short year) {
                this.year = year;
        }

        public int getRedlineRpm() {
                return redlineRpm;
        }

        public void setRedlineRpm(int redlineRpm) {
                this.redlineRpm = redlineRpm;
        }

        public int getMaxFuelVolume() {
                return maxFuelVolume;
        }

        public void setMaxFuelVolume(int maxFuelVolume) {
                this.maxFuelVolume = maxFuelVolume;
        }
        @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss.sss'Z'")
        public Timestamp getLastServiceDate() {
                return lastServiceDate;
        }

        public void setLastServiceDate(Timestamp lastServiceDate) {
                this.lastServiceDate = lastServiceDate;
        }



        @Override
        public String toString() {
                return "Vehicle{" +
                        "vin='" + vin + '\'' +
                        ", make='" + make + '\'' +
                        ", model='" + model + '\'' +
                        ", year=" + year +
                        ", redlineRpm=" + redlineRpm +
                        ", maxFuelVolume=" + maxFuelVolume +
                        ", lastServiceDate=" + lastServiceDate.toString() +
                        '}';
        }
}

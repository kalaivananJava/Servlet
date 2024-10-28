package com.mkyong.web;

import java.sql.Date;
// import java.time.LocalDate;

// import com.opencsv.bean.CsvBindByPosition;

public class Bus {
    
    
    private Date availdate;
    private int busNo;
    private String busName;
    private int availableSeats;
    private String custome_name;
    
    
    
    public Date getAvaildate() {
        return availdate;
    }

    public void setAvaildate(Date availdate) {
        this.availdate = availdate;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getCustome_name() {
        return custome_name;
    }

    public void setCustome_name(String custome_name) {
        this.custome_name = custome_name;
    }

    @Override
    public String toString() {
        return "Bus [Availdate=" + availdate + ", busNo=" + busNo + ", busName=" + busName + ", availableSeats="
                + availableSeats + ", custome_name=" + custome_name + "]";
    }
 

    
    

    

}

package com.cybernetic;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Getter @Data
public class CyberneticOrgan {
    private String id;
    private String type;
    private String model;
    private int powerLevel;
    private double compatibilityScore;
    private LocalDate manufactureDate;
    private String status;
    private String manufacturer;

    public CyberneticOrgan(String id, String type, String model, int powerLevel, double compatibilityScore, LocalDate manufactureDate, String status, String manufacturer) {
        this.id =id;
        this.type =type;
        this.model =model;
        this.powerLevel =powerLevel;
        this.compatibilityScore =compatibilityScore;
        this.manufactureDate =manufactureDate;
        this.status =status;
        this.manufacturer = manufacturer;

    }


}
package com.milos.fleetapp.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class VehicleMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "vehicleid", insertable = false, updatable = false)
    private Vehicle vehicle;
    private Integer vehicleid;

    @ManyToOne
    @JoinColumn(name = "locationid", insertable = false, updatable = false)
    private Location location;
    private Integer locationid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date1;

    @ManyToOne
    @JoinColumn(name = "locationid2", insertable = false, updatable = false)
    private Location location2;
    private int locationid2;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date2;

    private String remarks;
}

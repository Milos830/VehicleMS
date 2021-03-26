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
    @JoinColumn(name = "startlocationid", insertable = false, updatable = false)
    private Location startlocation;
    private Integer startlocationid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date1;

    @ManyToOne
    @JoinColumn(name = "endlocationid", insertable = false, updatable = false)
    private Location endlocation;
    private int endlocationid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date2;

    private String remarks;
}

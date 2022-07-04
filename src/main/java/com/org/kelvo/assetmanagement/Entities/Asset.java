package com.org.kelvo.assetmanagement.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long AssetId;

    private String AssetName;
    private String SerialNo;
    private String Model;
    private String AssetType;
    private String AssetValue;
    private String AssetCode;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "location_id",referencedColumnName ="LocationId",insertable = false,updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Transient
    private Location Location;
    private Long locationId;
 //   @Column(name = "department")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "department_id",referencedColumnName ="DepartmentId",insertable = false,updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Transient
    private Department department;
  //  @Column(name = "department")
    private Long departmentId;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "custodian_id",referencedColumnName ="CustodianId",insertable = false,updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Transient
    private Custodian custodian;
    private Long custodianId;


}

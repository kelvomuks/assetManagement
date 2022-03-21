package com.org.kelvo.assetmanagement.Entities;

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
public class Custodian {

    @Id
    @GeneratedValue
    private Long custodianId;
    private String firstName;
    private String lastName;
    private String email;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "location_id",referencedColumnName ="LocationId",insertable = false,updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Transient
    private Location Location;
    private Long locationId;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "department_id",referencedColumnName ="DepartmentId",insertable = false,updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Transient
    private Department department;
    private Long departmentId;




}

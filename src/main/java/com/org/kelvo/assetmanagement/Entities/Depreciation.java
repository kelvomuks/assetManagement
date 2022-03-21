package com.org.kelvo.assetmanagement.Entities;

import com.org.kelvo.assetmanagement.Enums.DepreciationTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Depreciation {

    @Id
    @GeneratedValue
    private Long depreciatinId;
    private String depreciationName;
    private Double depreciationvalue;
}

package com.org.kelvo.assetmanagement.Repositories;

import com.org.kelvo.assetmanagement.Entities.Custodian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustodianRepository extends JpaRepository<Custodian,Long> {
}

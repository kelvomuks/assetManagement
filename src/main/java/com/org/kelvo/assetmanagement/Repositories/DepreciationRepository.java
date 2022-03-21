package com.org.kelvo.assetmanagement.Repositories;

import com.org.kelvo.assetmanagement.Entities.Depreciation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepreciationRepository extends JpaRepository<Depreciation,Long> {
}

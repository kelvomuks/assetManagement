package com.org.kelvo.assetmanagement.Repositories;

import com.org.kelvo.assetmanagement.Entities.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public interface AssetRepository extends JpaRepository<Asset,Long> {
}

package com.org.kelvo.assetmanagement.Repositories;

import com.org.kelvo.assetmanagement.Entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
}

package org.ptvinh203.bcserver.repository;

import org.ptvinh203.bcserver.entity.AllCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AllCodeRepository extends JpaRepository<AllCode, UUID> {
    List<AllCode> findByType(String type);

    Optional<AllCode> findByKey(String key);
}

package org.ptvinh203.bcserver.repository;

import org.ptvinh203.bcserver.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpecialtyRepository extends JpaRepository<Specialty, UUID> {
}

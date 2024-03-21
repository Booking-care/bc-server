package org.ptvinh203.bcserver.repository;

import org.ptvinh203.bcserver.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClinicRepository extends JpaRepository<Clinic, UUID> {
}

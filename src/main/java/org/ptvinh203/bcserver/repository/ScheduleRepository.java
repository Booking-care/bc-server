package org.ptvinh203.bcserver.repository;

import org.ptvinh203.bcserver.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScheduleRepository extends JpaRepository<Schedule, UUID> {
}

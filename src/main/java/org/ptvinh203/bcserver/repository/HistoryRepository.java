package org.ptvinh203.bcserver.repository;

import org.ptvinh203.bcserver.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HistoryRepository extends JpaRepository<History, UUID> {
}

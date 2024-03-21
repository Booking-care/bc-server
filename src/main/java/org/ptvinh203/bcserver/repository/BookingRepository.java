package org.ptvinh203.bcserver.repository;

import org.ptvinh203.bcserver.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {
}

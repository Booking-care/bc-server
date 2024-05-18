package org.ptvinh203.bcserver.entity;

import jakarta.persistence.*;
import lombok.*;
import org.ptvinh203.bcserver.util.model.AbstractEntity;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "bookings")
public class Booking extends AbstractEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String statusId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private User doctor;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private User patient;
    private Timestamp date;
    private String timeType;
}

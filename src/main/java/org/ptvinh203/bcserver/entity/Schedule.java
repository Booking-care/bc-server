package org.ptvinh203.bcserver.entity;

import jakarta.persistence.*;
import lombok.*;
import org.ptvinh203.bcserver.util.entity.AbstractEntity;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "schedules")
public class Schedule extends AbstractEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private int currentNumber;
    private int maxNumber;
    private Timestamp date;
    private String timeType;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private User doctor;
}

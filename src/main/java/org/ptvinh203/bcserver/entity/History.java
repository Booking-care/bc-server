package org.ptvinh203.bcserver.entity;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;
import org.ptvinh203.bcserver.util.entity.AbstractEntity;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "histories")
public class History extends AbstractEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private User patient;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private User doctor;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Type(ListArrayType.class)
    @Column(columnDefinition = "TEXT[]")
    private List<String> files;
}

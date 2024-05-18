package org.ptvinh203.bcserver.entity;

import jakarta.persistence.*;
import lombok.*;
import org.ptvinh203.bcserver.util.model.AbstractEntity;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clinics")
public class Clinic extends AbstractEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String address;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String image;
    private String name;
}

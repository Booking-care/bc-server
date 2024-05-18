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
@Table(name = "specialties")
public class Specialty extends AbstractEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String image;
    private String name;
}

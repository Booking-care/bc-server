package org.ptvinh203.bcserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.ptvinh203.bcserver.util.entity.AbstractEntity;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "all_codes")
public class AllCode extends AbstractEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String key;
    private String type;
    private String valueEn;
    private String valueVi;
}

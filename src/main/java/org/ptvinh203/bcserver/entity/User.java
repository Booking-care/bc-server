package org.ptvinh203.bcserver.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends AbstractEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String address;
    private boolean gender;
    private String phoneNumber;
    private String image;
    private Timestamp deletedAt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id")
    private AllCode position;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private AllCode role;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;
}

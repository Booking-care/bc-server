package org.ptvinh203.bcserver.config;

import lombok.RequiredArgsConstructor;
import org.ptvinh203.bcserver.entity.AllCode;
import org.ptvinh203.bcserver.entity.User;
import org.ptvinh203.bcserver.repository.AllCodeRepository;
import org.ptvinh203.bcserver.repository.UserRepository;
import org.ptvinh203.bcserver.util.enums.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitialDatabase implements CommandLineRunner {
    private final AllCodeRepository allCodeRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // All code data
        if (allCodeRepository.findAll().isEmpty()) {
            allCodeRepository.saveAll(List.of(
                    // Role
                    AllCode.builder().key("R1").type("ROLE").valueEn(Role.ADMIN.name()).valueVi("QUẢN TRỊ VIÊN").build(),
                    AllCode.builder().key("R2").type("ROLE").valueEn(Role.DOCTOR.name()).valueVi("BÁC SĨ").build(),
                    AllCode.builder().key("R3").type("ROLE").valueEn(Role.PATIENT.name()).valueVi("BỆNH NHÂN").build(),
                    // Status
                    AllCode.builder().key("S1").type("STATUS").valueEn("NEW").valueVi("MỚI").build(),
                    AllCode.builder().key("S2").type("STATUS").valueEn("CONFIRMED").valueVi("XÁC NHẬN").build(),
                    AllCode.builder().key("S3").type("STATUS").valueEn("DONE").valueVi("HOÀN THÀNH").build(),
                    AllCode.builder().key("S4").type("STATUS").valueEn("CANCEL").valueVi("BỊ HỦY").build(),
                    // Time
                    AllCode.builder().key("T1").type("TIME").valueEn("8:00 - 9:00").valueVi("8:00 - 9:00").build(),
                    AllCode.builder().key("T2").type("TIME").valueEn("9:00 - 10:00").valueVi("9:00 - 10:00").build(),
                    AllCode.builder().key("T3").type("TIME").valueEn("10:00 - 11:00").valueVi("10:00 - 11:00").build(),
                    AllCode.builder().key("T4").type("TIME").valueEn("11:00 - 12:00").valueVi("11:00 - 12:00").build(),
                    AllCode.builder().key("T5").type("TIME").valueEn("13:00 - 14:00").valueVi("13:00 - 14:00").build(),
                    AllCode.builder().key("T6").type("TIME").valueEn("14:00 - 15:00").valueVi("14:00 - 15:00").build(),
                    AllCode.builder().key("T7").type("TIME").valueEn("15:00 - 16:00").valueVi("15:00 - 16:00").build(),
                    AllCode.builder().key("T8").type("TIME").valueEn("16:00 - 17:00").valueVi("16:00 - 17:00").build(),
                    // Position
                    AllCode.builder().key("P0").type("POSITION").valueEn("NONE").valueVi("BÁC SĨ").build(),
                    AllCode.builder().key("P1").type("POSITION").valueEn("MASTER").valueVi("THẠC SĨ").build(),
                    AllCode.builder().key("P2").type("POSITION").valueEn("DOCTOR").valueVi("TIẾN SĨ").build(),
                    AllCode.builder().key("P3").type("POSITION").valueEn("ASSOCIATE PROFESSOR").valueVi("PHÓ GIÁO SƯ").build(),
                    AllCode.builder().key("P4").type("POSITION").valueEn("PROFESSOR").valueVi("GIÁO SƯ").build()
            ));
        }
        AllCode adminRole = allCodeRepository.findByKey("R1").orElseThrow();
        AllCode doctorRole = allCodeRepository.findByKey("R1").orElseThrow();
        AllCode patientRole = allCodeRepository.findByKey("R1").orElseThrow();
        // User data
        if (userRepository.findAll().isEmpty()) {
            userRepository.saveAll(List.of(
                    // Admin
                    User.builder().role(adminRole).email("admin@gmail.com").password(passwordEncoder.encode("123456Aa")).firstName("Nguyen").lastName("A").address("Da Nang").gender(true).build(),
                    // Doctor
                    User.builder().role(doctorRole).email("doctor@gmail.com").password(passwordEncoder.encode("123456Aa")).firstName("Nguyen").lastName("A").address("Da Nang").gender(true).build(),
                    // Patient
                    User.builder().role(patientRole).email("patient@gmail.com").password(passwordEncoder.encode("123456Aa")).firstName("Nguyen").lastName("A").address("Da Nang").gender(true).build()
            ));
        }
    }
}

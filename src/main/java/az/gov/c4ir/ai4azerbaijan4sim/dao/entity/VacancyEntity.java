package az.gov.c4ir.ai4azerbaijan4sim.dao.entity;

import az.gov.c4ir.ai4azerbaijan4sim.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "vacancy")
@Data
@AllArgsConstructor
public class VacancyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String vacancyCode;
    private String name;
    private LocalDateTime createdDate;
    private LocalDate endDate;
    private String institution;
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    private String author;

    public VacancyEntity() {
        this.createdDate = LocalDateTime.now();
        this.vacancyCode = generateVacancyCode();
    }

    private String generateVacancyCode() {
        return UUID.randomUUID().toString();
    }
}

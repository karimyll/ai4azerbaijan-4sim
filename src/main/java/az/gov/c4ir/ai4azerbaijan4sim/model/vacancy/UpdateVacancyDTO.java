package az.gov.c4ir.ai4azerbaijan4sim.model.vacancy;

import az.gov.c4ir.ai4azerbaijan4sim.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateVacancyDTO {
    private String name;
    private LocalDate endDate;
    private String institution;
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
}

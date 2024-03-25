package az.gov.c4ir.ai4azerbaijan4sim.mapper;

import az.gov.c4ir.ai4azerbaijan4sim.dao.entity.VacancyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VacancyRepository extends JpaRepository<VacancyEntity, Long> {
    Optional<VacancyEntity> findByVacancyCode(String vacancyCode);
}

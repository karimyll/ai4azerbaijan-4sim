package az.gov.c4ir.ai4azerbaijan4sim.dao.repository;

import az.gov.c4ir.ai4azerbaijan4sim.dao.entity.SubMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubMenuRepository extends JpaRepository<SubMenuEntity, Long> {
    Optional<SubMenuEntity> findByMenu_Id(Long id);
}

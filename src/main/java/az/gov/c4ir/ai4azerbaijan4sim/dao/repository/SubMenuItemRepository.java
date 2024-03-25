package az.gov.c4ir.ai4azerbaijan4sim.dao.repository;

import az.gov.c4ir.ai4azerbaijan4sim.dao.entity.SubMenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubMenuItemRepository extends JpaRepository<SubMenuItemEntity, Long> {
    Optional<SubMenuItemEntity> findBySubMenuId(Long subMenuId);
    Boolean existsBySubMenuId(Long subMenuId);
}

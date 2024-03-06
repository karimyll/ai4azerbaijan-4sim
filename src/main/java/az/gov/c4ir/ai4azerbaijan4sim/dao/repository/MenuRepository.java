package az.gov.c4ir.ai4azerbaijan4sim.dao.repository;

import az.gov.c4ir.ai4azerbaijan4sim.dao.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
    Optional<MenuEntity> getBySlug(String slug);
}

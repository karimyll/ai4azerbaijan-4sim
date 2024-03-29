package az.gov.c4ir.ai4azerbaijan4sim.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "menu")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String slug;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<SubMenuEntity> subMenu;
}

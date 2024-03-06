package az.gov.c4ir.ai4azerbaijan4sim.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sub_menu")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SubMenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private MenuEntity menu;
}

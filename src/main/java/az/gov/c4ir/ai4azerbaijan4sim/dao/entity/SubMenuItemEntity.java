package az.gov.c4ir.ai4azerbaijan4sim.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sub_menu_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubMenuItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String media_url;
    @OneToOne
    @JoinColumn(name = "sub_menu_id")
    private SubMenuEntity subMenu;
}

package az.gov.c4ir.ai4azerbaijan4sim.model.menu;

import az.gov.c4ir.ai4azerbaijan4sim.model.submenu.SubMenuDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseMenuDTO {
    private Long id;
    private String title;
    private String slug;
    private List<SubMenuDTO> subMenu;
}

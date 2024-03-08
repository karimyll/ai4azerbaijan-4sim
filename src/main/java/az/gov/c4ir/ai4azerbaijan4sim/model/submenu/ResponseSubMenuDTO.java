package az.gov.c4ir.ai4azerbaijan4sim.model.submenu;

import az.gov.c4ir.ai4azerbaijan4sim.model.menu.MenuDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ResponseSubMenuDTO {
    private Long id;
    private String name;
    private MenuDTO menu;
}

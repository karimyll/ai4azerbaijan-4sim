package az.gov.c4ir.ai4azerbaijan4sim.model.submenu;

import az.gov.c4ir.ai4azerbaijan4sim.model.menu.MenuDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.submenuitem.ResponseMenuItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ResponseSubMenuDTO {
    private Long id;
    private String name;
    private ResponseMenuItemDTO subMenuItem;
}

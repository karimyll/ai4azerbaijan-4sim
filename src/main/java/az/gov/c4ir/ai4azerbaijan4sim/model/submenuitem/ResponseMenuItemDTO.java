package az.gov.c4ir.ai4azerbaijan4sim.model.submenuitem;

import az.gov.c4ir.ai4azerbaijan4sim.model.submenu.SubMenuDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMenuItemDTO {
    private Long id;
    private String title;
    private String content;
    private String media_url;
}

package az.gov.c4ir.ai4azerbaijan4sim.model.submenuitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestMenuItemDTO {
    private String title;
    private String content;
    private String media_url;
    private Long subMenuId;
}

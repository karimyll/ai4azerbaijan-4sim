package az.gov.c4ir.ai4azerbaijan4sim.model.menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseMenuDTO {
    private Long id;
    private String title;
    private String slug;
}

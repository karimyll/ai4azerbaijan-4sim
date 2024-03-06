package az.gov.c4ir.ai4azerbaijan4sim.model.menu;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestMenuDTO {
    @NotNull
    private String title;
    @NotNull
    private String slug;
}

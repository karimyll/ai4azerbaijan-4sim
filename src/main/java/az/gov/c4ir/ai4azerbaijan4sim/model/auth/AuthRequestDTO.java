package az.gov.c4ir.ai4azerbaijan4sim.model.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequestDTO {
    @NotBlank(message = "USERNAME_CANNOT_BE_EMPTY")
    private String username;
    @NotBlank(message = "PASSWORD_CANNOT_BE_EMPTY")
    private String password;
}

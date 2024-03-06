package az.gov.c4ir.ai4azerbaijan4sim.controller.auth;

import az.gov.c4ir.ai4azerbaijan4sim.model.auth.AuthRequestDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.auth.AuthenticationDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.auth.UserRegisterRequestDTO;
import az.gov.c4ir.ai4azerbaijan4sim.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/admin/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid UserRegisterRequestDTO requestDto) {
        authService.register(requestDto);
    }

    @PostMapping("/login")
    public AuthenticationDTO login(@RequestBody @Valid AuthRequestDTO authRequestDto) {
        return authService.authenticate(authRequestDto);
    }

    @DeleteMapping("/admin/delete/id/{id}")
    public void delete(@PathVariable Long id){
        authService.deleteUser(id);
    }

}

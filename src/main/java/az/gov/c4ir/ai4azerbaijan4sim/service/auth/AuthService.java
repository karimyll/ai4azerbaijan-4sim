package az.gov.c4ir.ai4azerbaijan4sim.service.auth;

import az.gov.c4ir.ai4azerbaijan4sim.dao.entity.UserEntity;
import az.gov.c4ir.ai4azerbaijan4sim.dao.repository.UserRepository;
import az.gov.c4ir.ai4azerbaijan4sim.mapper.UserMapper;
import az.gov.c4ir.ai4azerbaijan4sim.model.auth.AuthRequestDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.auth.AuthenticationDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.auth.UserRegisterRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    private final UserMapper userMapper;

    public void register(UserRegisterRequestDTO requestDto) {
        var user = UserRegisterRequestDTO.builder()
                .username(requestDto.getUsername())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .roles(requestDto.getRoles())
                .build();

        userRepository.save(userMapper.mapRegisterRequestDtoToEntity(user));
    }

    public AuthenticationDTO authenticate(AuthRequestDTO authRequestDto) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequestDto.getUsername(),
                        authRequestDto.getPassword()
                )
        );
        UserEntity user = userRepository.findUserByUsername(authRequestDto.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationDTO.builder()
                .token(jwtToken)
                .build();
    }

    public void deleteUser(Long userId) {
        log.info("ActionLog.deleteUser.start");
        userRepository.deleteById(userId);
        log.info("ActionLog.deleteUser.end");
    }

}

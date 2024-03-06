package az.gov.c4ir.ai4azerbaijan4sim.mapper;

import az.gov.c4ir.ai4azerbaijan4sim.dao.entity.RoleEntity;
import az.gov.c4ir.ai4azerbaijan4sim.dao.entity.UserEntity;
import az.gov.c4ir.ai4azerbaijan4sim.model.auth.UserRegisterRequestDTO;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    UserEntity mapRegisterRequestDtoToEntity(UserRegisterRequestDTO userRegisterRequestDTO);

//    @AfterMapping
//    default void mapRoles(UserRegisterRequestDTO userRegisterRequestDTO, @MappingTarget UserEntity userEntity) {
//        if (userRegisterRequestDTO.getRoles() != null) {
//            Set<RoleEntity> roleEntities = userRegisterRequestDTO.getRoles().stream()
//                    .map(roleDTO -> {
//                        RoleEntity roleEntity = new RoleEntity();
//                        roleEntity.setId(roleDTO.getId());
//                        return roleEntity;
//                    })
//                    .collect(Collectors.toSet());
//
//            userEntity.setRoles(roleEntities);
//        }
//    }
}


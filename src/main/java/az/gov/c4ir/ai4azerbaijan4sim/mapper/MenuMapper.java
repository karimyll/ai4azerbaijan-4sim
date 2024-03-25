package az.gov.c4ir.ai4azerbaijan4sim.mapper;

import az.gov.c4ir.ai4azerbaijan4sim.dao.entity.MenuEntity;
import az.gov.c4ir.ai4azerbaijan4sim.model.menu.RequestMenuDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.menu.ResponseMenuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MenuMapper {
    MenuEntity mapToEntity(RequestMenuDTO requestMenuDTO);
    ResponseMenuDTO mapToDTO(MenuEntity menuEntity);
    MenuEntity mapToUpdateEntity(@MappingTarget MenuEntity menuEntity, RequestMenuDTO requestMenuDTO);
}

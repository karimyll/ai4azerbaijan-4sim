package az.gov.c4ir.ai4azerbaijan4sim.mapper;

import az.gov.c4ir.ai4azerbaijan4sim.dao.entity.SubMenuEntity;
import az.gov.c4ir.ai4azerbaijan4sim.model.submenu.RequestSubMenuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SubMenuMapper {
    SubMenuEntity mapToEntity(RequestSubMenuDTO requestSubMenuDTO);
}

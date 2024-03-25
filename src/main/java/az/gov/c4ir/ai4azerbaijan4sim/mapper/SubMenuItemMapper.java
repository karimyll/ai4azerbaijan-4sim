package az.gov.c4ir.ai4azerbaijan4sim.mapper;

import az.gov.c4ir.ai4azerbaijan4sim.dao.entity.SubMenuEntity;
import az.gov.c4ir.ai4azerbaijan4sim.dao.entity.SubMenuItemEntity;
import az.gov.c4ir.ai4azerbaijan4sim.model.submenuitem.RequestMenuItemDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.submenuitem.ResponseMenuItemDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SubMenuItemMapper {
    @Mapping(target = "subMenu", source = "subMenuId", qualifiedByName = "toSubMenuEntity")
    SubMenuItemEntity mapToEntity(RequestMenuItemDTO requestMenuItemDTO);
    ResponseMenuItemDTO mapToDTO(SubMenuItemEntity subMenuItem);
    SubMenuItemEntity mapToUpdateEntity(@MappingTarget SubMenuItemEntity subMenuItem, RequestMenuItemDTO requestMenuItemDTO);

    @Named("toSubMenuEntity")
    default SubMenuEntity toSubMenuEntity(Long subMenuId) {
        if (subMenuId == null) {
            return null;
        }
        SubMenuEntity subMenuEntity = new SubMenuEntity();
        subMenuEntity.setId(subMenuId);
        return subMenuEntity;
    }
}

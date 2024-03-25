package az.gov.c4ir.ai4azerbaijan4sim.mapper;

import az.gov.c4ir.ai4azerbaijan4sim.dao.entity.VacancyEntity;
import az.gov.c4ir.ai4azerbaijan4sim.model.vacancy.RequestVacancyDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.vacancy.ResponseAdminDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.vacancy.ResponseUserDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.vacancy.UpdateVacancyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

public interface VacancyMapper {
    VacancyEntity mapToEntity(RequestVacancyDTO requestVacancyDTO);
    VacancyEntity mapToUpdateEntity(@MappingTarget VacancyEntity vacancy, UpdateVacancyDTO updateVacancyDTO);
    ResponseAdminDTO mapToAdminDTO(VacancyEntity vacancy);
    ResponseUserDTO mapToUserDTO(VacancyEntity vacancy);
}

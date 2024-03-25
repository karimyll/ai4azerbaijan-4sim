package az.gov.c4ir.ai4azerbaijan4sim.service.impl;

import az.gov.c4ir.ai4azerbaijan4sim.exception.EntityNotFoundException;
import az.gov.c4ir.ai4azerbaijan4sim.mapper.VacancyMapper;
import az.gov.c4ir.ai4azerbaijan4sim.mapper.VacancyRepository;
import az.gov.c4ir.ai4azerbaijan4sim.model.vacancy.RequestVacancyDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.vacancy.ResponseAdminDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.vacancy.ResponseUserDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.vacancy.UpdateVacancyDTO;
import az.gov.c4ir.ai4azerbaijan4sim.service.interfaces.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {
    private final VacancyRepository repository;
    private final VacancyMapper mapper;
    @Override
    public Page<ResponseAdminDTO> getAllListAdmin(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::mapToAdminDTO);
    }

    @Override
    public Page<ResponseUserDTO> getAllListUser(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::mapToUserDTO);
    }

    @Override
    public ResponseUserDTO getByCode(String vacancyCode) {
         var vacancy = repository.findByVacancyCode(vacancyCode).orElseThrow(
                () -> new EntityNotFoundException("VACANCY_NOT_FOUND")
        );

         return mapper.mapToUserDTO(vacancy);
    }

    @Override
    public void add(RequestVacancyDTO requestVacancyDTO) {
        // set name surname author, status, controller
        repository.save(mapper.mapToEntity(requestVacancyDTO));
    }

    @Override
    public void update(Long id, UpdateVacancyDTO updateVacancyDTO) {
        var vacancy = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("VACANCY_NOT_FOUND")
        );

        repository.save(mapper.mapToUpdateEntity(vacancy, updateVacancyDTO));
    }

    @Override
    public void delete(Long id) {
        var vacancy = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("VACANCY_NOT_FOUND")
        );

        repository.delete(vacancy);
    }
}

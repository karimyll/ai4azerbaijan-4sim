package az.gov.c4ir.ai4azerbaijan4sim.service.impl;

import az.gov.c4ir.ai4azerbaijan4sim.dao.repository.SubMenuItemRepository;
import az.gov.c4ir.ai4azerbaijan4sim.dao.repository.SubMenuRepository;
import az.gov.c4ir.ai4azerbaijan4sim.exception.EntityExistException;
import az.gov.c4ir.ai4azerbaijan4sim.exception.EntityNotFoundException;
import az.gov.c4ir.ai4azerbaijan4sim.mapper.SubMenuItemMapper;
import az.gov.c4ir.ai4azerbaijan4sim.model.submenuitem.RequestMenuItemDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.submenuitem.ResponseMenuItemDTO;
import az.gov.c4ir.ai4azerbaijan4sim.service.interfaces.SubMenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubMenuItemServiceImpl implements SubMenuItemService {
    private final SubMenuItemRepository repository;
    private final SubMenuItemMapper mapper;
    private final SubMenuRepository subMenuRepository;

    @Override
    public Page<ResponseMenuItemDTO> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::mapToDTO);
    }

    @Override
    public ResponseMenuItemDTO getItem(Long subMenuId) {
        var item = repository.findBySubMenuId(subMenuId).orElseThrow(
                () -> new EntityNotFoundException("SUB_MENU_POST_NOT_FOUND")
        );

        return mapper.mapToDTO(item);
    }

    @Override
    public void add(RequestMenuItemDTO requestMenuItemDTO) {
        var check = repository.existsBySubMenuId(requestMenuItemDTO.getSubMenuId());
        var submenu = subMenuRepository.existsById(requestMenuItemDTO.getSubMenuId());
        if (check){
            throw new EntityExistException("SUB_MENU_POST_EXISTS");
        } else if (!submenu) {
            throw new EntityNotFoundException("SUB_MENU_NOT_FOUND");
        } else {
            repository.save(mapper.mapToEntity(requestMenuItemDTO));
        }
    }

    @Override
    public void update(Long id, RequestMenuItemDTO requestMenuItemDTO) {
        var item = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("SUB_MENU_POST_NOT_FOUND")
        );

        repository.save(mapper.mapToUpdateEntity(item, requestMenuItemDTO));
    }

    @Override
    public void delete(Long id) {
        if (repository.findById(id).isEmpty()){
            throw new EntityNotFoundException("SUB_MENU_POST_NOT_FOUND");
        }

        repository.deleteById(id);
    }
}

package az.gov.c4ir.ai4azerbaijan4sim.service.impl;

import az.gov.c4ir.ai4azerbaijan4sim.dao.entity.SubMenuEntity;
import az.gov.c4ir.ai4azerbaijan4sim.dao.repository.MenuRepository;
import az.gov.c4ir.ai4azerbaijan4sim.dao.repository.SubMenuRepository;
import az.gov.c4ir.ai4azerbaijan4sim.exception.EntityNotFoundException;
import az.gov.c4ir.ai4azerbaijan4sim.mapper.SubMenuMapper;
import az.gov.c4ir.ai4azerbaijan4sim.model.submenu.RequestSubMenuDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.submenu.ResponseSubMenuDTO;
import az.gov.c4ir.ai4azerbaijan4sim.service.interfaces.SubMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubMenuServiceImpl implements SubMenuService {
    private final SubMenuRepository repository;
    private final MenuRepository menuRepository;
    private final SubMenuMapper mapper;
    @Override
    public Page<ResponseSubMenuDTO> getAllSubMenu(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::mapToDTO);
    }

    @Override
    public ResponseSubMenuDTO getSubMenuByMenuId(Long id) {
        var submenu = repository.findByMenu_Id(id).orElseThrow(
                () -> new EntityNotFoundException("MENU_NOT_FOUND")
        );
        return mapper.mapToDTO(submenu);
    }

    @Override
    public void add(RequestSubMenuDTO requestSubMenuDTO) {
        var menu = menuRepository.findById(requestSubMenuDTO.getMenuId()).orElseThrow(
                () -> new EntityNotFoundException("MENU_NOT_FOUND")
        );
        SubMenuEntity subMenuEntity = new SubMenuEntity();
        subMenuEntity.setMenu(menu);
        subMenuEntity.setName(requestSubMenuDTO.getName());

        repository.save(subMenuEntity);
    }

    @Override
    public void update(Long id, RequestSubMenuDTO requestSubMenuDTO) {

    }

    @Override
    public void deleteById(Long id) {

    }
}

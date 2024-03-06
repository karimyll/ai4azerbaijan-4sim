package az.gov.c4ir.ai4azerbaijan4sim.service.impl;

import az.gov.c4ir.ai4azerbaijan4sim.dao.repository.MenuRepository;
import az.gov.c4ir.ai4azerbaijan4sim.exception.EntityExistException;
import az.gov.c4ir.ai4azerbaijan4sim.mapper.MenuMapper;
import az.gov.c4ir.ai4azerbaijan4sim.model.menu.RequestMenuDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.menu.ResponseMenuDTO;
import az.gov.c4ir.ai4azerbaijan4sim.service.interfaces.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    @Override
    public Page<ResponseMenuDTO> getAllMenu(Pageable pageable) {
        return menuRepository.findAll(pageable).map(menuMapper::mapToDTO);
    }

    @Override
    public void add(RequestMenuDTO requestMenuDTO) {
        var menu = menuRepository.getBySlug(requestMenuDTO.getSlug());
        if (menu.isPresent()){
            throw new EntityExistException("MENU_SLUG_EXIST");
        }else {
            menuRepository.save(menuMapper.mapToEntity(requestMenuDTO));
        }
    }

    @Override
    public void update(RequestMenuDTO requestMenuDTO) {

    }

    @Override
    public void deleteById(Long id) {

    }
}

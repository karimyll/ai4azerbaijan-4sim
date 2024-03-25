package az.gov.c4ir.ai4azerbaijan4sim.service.interfaces;

import az.gov.c4ir.ai4azerbaijan4sim.model.submenu.RequestSubMenuDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.submenu.ResponseSubMenuDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubMenuService {
    Page<ResponseSubMenuDTO> getAllSubMenu(Pageable pageable);
    ResponseSubMenuDTO getById(Long id);
    void add(RequestSubMenuDTO requestSubMenuDTO);
    void update(Long id, RequestSubMenuDTO requestSubMenuDTO);
    void deleteById(Long id);

}

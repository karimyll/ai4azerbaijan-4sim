package az.gov.c4ir.ai4azerbaijan4sim.service.interfaces;

import az.gov.c4ir.ai4azerbaijan4sim.model.menu.RequestMenuDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.menu.ResponseMenuDTO;
import org.springframework.data.domain.Page;

public interface MenuService {
    Page<ResponseMenuDTO> getAllMenu();
    void add(RequestMenuDTO requestMenuDTO);
    void update(RequestMenuDTO requestMenuDTO);
    void deleteById(Long id);
}

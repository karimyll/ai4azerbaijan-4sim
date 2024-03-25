package az.gov.c4ir.ai4azerbaijan4sim.service.interfaces;

import az.gov.c4ir.ai4azerbaijan4sim.model.menu.RequestMenuDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.menu.ResponseMenuDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MenuService {
    Page<ResponseMenuDTO> getAllMenu(Pageable pageable);
    void add(RequestMenuDTO requestMenuDTO);
    void update(Long id, RequestMenuDTO requestMenuDTO);
    void deleteById(Long id);
}

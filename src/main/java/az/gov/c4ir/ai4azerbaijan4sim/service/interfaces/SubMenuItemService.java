package az.gov.c4ir.ai4azerbaijan4sim.service.interfaces;

import az.gov.c4ir.ai4azerbaijan4sim.model.submenuitem.RequestMenuItemDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.submenuitem.ResponseMenuItemDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubMenuItemService {
    Page<ResponseMenuItemDTO> getAll(Pageable pageable);
    ResponseMenuItemDTO getItem(Long subMenuId);
    void add(RequestMenuItemDTO requestMenuItemDTO);
    void update(Long id, RequestMenuItemDTO requestMenuItemDTO);
    void delete(Long id);
}

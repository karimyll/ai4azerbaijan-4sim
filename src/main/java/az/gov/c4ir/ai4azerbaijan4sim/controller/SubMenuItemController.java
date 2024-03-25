package az.gov.c4ir.ai4azerbaijan4sim.controller;

import az.gov.c4ir.ai4azerbaijan4sim.model.submenuitem.RequestMenuItemDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.submenuitem.ResponseMenuItemDTO;
import az.gov.c4ir.ai4azerbaijan4sim.service.interfaces.SubMenuItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/submenuitem")
@RequiredArgsConstructor
public class SubMenuItemController {
    private final SubMenuItemService service;

    @GetMapping
    public Page<ResponseMenuItemDTO> getAll(Pageable pageable){
        return service.getAll(pageable);
    }

    @GetMapping("/{subMenuId}")
    public ResponseMenuItemDTO getItem(@PathVariable Long subMenuId){
        return service.getItem(subMenuId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid RequestMenuItemDTO requestMenuItemDTO){
        service.add(requestMenuItemDTO);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, RequestMenuItemDTO requestMenuItemDTO){
        service.update(id, requestMenuItemDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}

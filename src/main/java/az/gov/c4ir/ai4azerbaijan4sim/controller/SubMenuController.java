package az.gov.c4ir.ai4azerbaijan4sim.controller;

import az.gov.c4ir.ai4azerbaijan4sim.model.submenu.RequestSubMenuDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.submenu.ResponseSubMenuDTO;
import az.gov.c4ir.ai4azerbaijan4sim.service.interfaces.SubMenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/submenu")
@RequiredArgsConstructor
public class SubMenuController {
    private final SubMenuService service;

    @GetMapping
    public Page<ResponseSubMenuDTO> getAll(Pageable pageable){
        return service.getAllSubMenu(pageable);
    }

    @PostMapping
    public void add(@RequestBody @Valid RequestSubMenuDTO requestSubMenuDTO){
        service.add(requestSubMenuDTO);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody RequestSubMenuDTO requestSubMenuDTO) {
        service.update(id, requestSubMenuDTO);
    }
}

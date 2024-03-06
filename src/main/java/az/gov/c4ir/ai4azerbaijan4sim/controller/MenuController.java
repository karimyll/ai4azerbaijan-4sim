package az.gov.c4ir.ai4azerbaijan4sim.controller;


import az.gov.c4ir.ai4azerbaijan4sim.model.menu.RequestMenuDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.menu.ResponseMenuDTO;
import az.gov.c4ir.ai4azerbaijan4sim.service.interfaces.MenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/menu")
public class MenuController {

    private final MenuService menuService;

    @GetMapping
    public Page<ResponseMenuDTO> getAllMenu(Pageable pageable){
        return menuService.getAllMenu(pageable);
    }

    @PostMapping
    public void addMenu(@RequestBody @Valid RequestMenuDTO requestMenuDTO){
        menuService.add(requestMenuDTO);
    }
}

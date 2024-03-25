package az.gov.c4ir.ai4azerbaijan4sim.controller;


import az.gov.c4ir.ai4azerbaijan4sim.model.menu.RequestMenuDTO;
import az.gov.c4ir.ai4azerbaijan4sim.model.menu.ResponseMenuDTO;
import az.gov.c4ir.ai4azerbaijan4sim.service.interfaces.MenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid RequestMenuDTO requestMenuDTO){
        menuService.add(requestMenuDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, RequestMenuDTO requestMenuDTO){
        menuService.update(id, requestMenuDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        menuService.deleteById(id);
    }

}

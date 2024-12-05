package lu.ethoswarrior.bandwarrior.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lu.ethoswarrior.bandwarrior.api.model.Band;
import lu.ethoswarrior.bandwarrior.api.service.BandService;

@RestController
@RequestMapping("/api/bands")
public class BandController {

    @Autowired
    private BandService bandService;

    // Endpoint para criar uma nova banda
    @PostMapping("/create")
    public Band createBand(@RequestBody Band band) {
        return bandService.createBand(band.getResponsible().getId(), band.getName(), band.getDescription());
    }

    // Endpoint para editar os detalhes da banda
    @PutMapping("/edit/{bandId}")
    public Band editBand(@PathVariable Long bandId, @RequestBody Band band) {
        return bandService.updateBand(bandId, band.getName(), band.getDescription());
    }

    // Endpoint para remover uma banda
    @DeleteMapping("/remove/{bandId}")
    public void removeBand(@PathVariable Long bandId) {
        bandService.deleteBand(bandId);
    }

    // Endpoint para obter detalhes da banda
    @GetMapping("/{bandId}")
    public Band getBandDetails(@PathVariable Long bandId) {
        return bandService.bandDetails(bandId);
    }

    // Endpoint para pesquisar bandas
    @GetMapping("/search/all")
    public List<Band> searchBands() {
        return bandService.searchBands();
    }
}

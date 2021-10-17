package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.rescuer.RescuerDto;
import ua.lviv.iot.mappers.RescuerMapper;
import ua.lviv.iot.model.Rescuer;
import ua.lviv.iot.service.RescuerService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static ua.lviv.iot.mappers.RescuerMapper.mapRescuerToRescuerDto;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rescuer")
public class RescuerController {

    private final RescuerService rescuerService;

    @PostMapping
    RescuerDto createRescuer(final @Valid @RequestBody Rescuer rescuer) {
        return mapRescuerToRescuerDto(rescuerService.createRescuer(rescuer));
    }

    @GetMapping
    List<RescuerDto> getAllRescuers() {
        return rescuerService.getAllRescuers().stream()
                .map(RescuerMapper::mapRescuerToRescuerDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    RescuerDto getRescuerById(final @PathVariable("id") Integer id) {
        return mapRescuerToRescuerDto(rescuerService.getRescuerById(id));
    }
}

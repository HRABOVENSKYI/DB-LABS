package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.dto.injury.InjuryDto;
import ua.lviv.iot.mappers.InjuryMapper;
import ua.lviv.iot.service.InjuryService;

import java.util.List;
import java.util.stream.Collectors;

import static ua.lviv.iot.mappers.InjuryMapper.mapInjuryToInjuryDto;

@RestController
@AllArgsConstructor
@RequestMapping("/api/injury")
public class InjuryController {

    private final InjuryService injuryService;

    @GetMapping
    List<InjuryDto> getAllInjuries() {
        return injuryService.getAllInjuries().stream()
                .map(InjuryMapper::mapInjuryToInjuryDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    InjuryDto getInjuryById(final @PathVariable("id") Integer id) {
        return mapInjuryToInjuryDto(injuryService.getInjuryById(id));
    }
}

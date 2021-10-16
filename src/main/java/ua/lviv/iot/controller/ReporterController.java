package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.dto.reporter.ReporterDto;
import ua.lviv.iot.mappers.ReporterMapper;
import ua.lviv.iot.service.ReporterService;

import java.util.List;
import java.util.stream.Collectors;

import static ua.lviv.iot.mappers.ReporterMapper.mapReporterToReporterDto;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reporter")
public class ReporterController {

    private final ReporterService reporterService;

    @GetMapping
    List<ReporterDto> getAllReporters() {
        return reporterService.getAllReporters().stream()
                .map(ReporterMapper::mapReporterToReporterDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    ReporterDto getReporterById(final @PathVariable("id") String phoneNumber) {
        return mapReporterToReporterDto(reporterService.getReporterById(phoneNumber));
    }
}

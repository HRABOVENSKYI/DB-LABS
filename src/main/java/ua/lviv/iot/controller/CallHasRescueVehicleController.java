package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.callhasrescuevehicle.CallHasRescueVehicleDto;
import ua.lviv.iot.mappers.CallHasRescueVehicleMapper;
import ua.lviv.iot.model.CallHasRescueVehicle;
import ua.lviv.iot.service.CallHasRescueVehicleService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static ua.lviv.iot.mappers.CallHasRescueVehicleMapper.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/call-has-rescue-vehicle")
public class CallHasRescueVehicleController {

    private final CallHasRescueVehicleService rescueVehicleService;

    @PostMapping
    CallHasRescueVehicleDto createCallHasRescueVehicle(final @Valid @RequestBody CallHasRescueVehicleDto rescueVehicleDto) {
        return mapCallHasRescueVehicleToCallHasRescueVehicleDto(
                rescueVehicleService.createCallHasRescueVehicle(rescueVehicleDto));
    }

    @GetMapping
    List<CallHasRescueVehicleDto> getAllCallHasRescueVehicles() {
        return rescueVehicleService.getAllCallHasRescueVehicles().stream()
                .map(CallHasRescueVehicleMapper::mapCallHasRescueVehicleToCallHasRescueVehicleDto)
                .collect(Collectors.toList());
    }


    @PutMapping
    CallHasRescueVehicleDto updateCallHasRescueVehicle(final @Valid @RequestBody CallHasRescueVehicle callHasRescueVehicle) {
        return mapCallHasRescueVehicleToCallHasRescueVehicleDto(rescueVehicleService.updateCallHasRescueVehicle(callHasRescueVehicle));
    }
}

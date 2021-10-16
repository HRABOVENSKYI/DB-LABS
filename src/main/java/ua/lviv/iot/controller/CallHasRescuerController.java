package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.callhasrescuer.CallHasRescuerDto;
import ua.lviv.iot.mappers.CallHasRescuerMapper;
import ua.lviv.iot.service.CallHasRescuerService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/call-has-rescuer")
public class CallHasRescuerController {

    private final CallHasRescuerService callHasRescuerService;

    @GetMapping
    List<CallHasRescuerDto> getAllCallHasRescuers() {
        return callHasRescuerService.getAllCallHasRescuers().stream()
                .map(CallHasRescuerMapper::mapCallHasRescuerToCallHasRescuerDto)
                .collect(Collectors.toList());
    }
}

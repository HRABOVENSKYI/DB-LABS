package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.dto.call.CallDto;
import ua.lviv.iot.mappers.CallMapper;
import ua.lviv.iot.service.CallService;

import java.util.List;
import java.util.stream.Collectors;

import static ua.lviv.iot.mappers.CallMapper.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/call")
public class CallController {

    private final CallService callService;

    @GetMapping
    List<CallDto> getAllCalls() {
        return callService.getAllCalls().stream()
                .map(CallMapper::mapCallToCallDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    CallDto getCallById(final @PathVariable("id") Integer id) {
        return mapCallToCallDto(callService.getCallById(id));
    }
}

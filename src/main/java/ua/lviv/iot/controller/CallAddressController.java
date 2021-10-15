package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.calladdress.CallAddressDto;
import ua.lviv.iot.mappers.CallAddressMapper;
import ua.lviv.iot.model.CallAddress;
import ua.lviv.iot.service.CallAddressService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static ua.lviv.iot.mappers.CallAddressMapper.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/call-address")
public class CallAddressController {

    private final CallAddressService callAddressService;

    @PostMapping
    CallAddress createCallAddress(final @Valid @RequestBody CallAddress callAddress) {
        return callAddressService.createCallAddress(callAddress);
    }

    @GetMapping
    List<CallAddressDto> getAllCallAddresses() {
        return callAddressService.getAllCallAddresses().stream()
                .map(CallAddressMapper::mapCallAddressToCallAddressDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    CallAddressDto getCallAddressById(final @PathVariable("id") Integer id) {
        return mapCallAddressToCallAddressDto(callAddressService.getCallAddressById(id));
    }

    @PutMapping
    CallAddress updateCallAddress(final @Valid @RequestBody CallAddress callAddress) {
        return callAddressService.updateCallAddress(callAddress);
    }

    @DeleteMapping("/{id}")
    CallAddress deleteCallAddressById(final @PathVariable("id") Integer id) {
        return callAddressService.deleteCallAddressById(id);
    }
}

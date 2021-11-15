package de.gamomat.challenge.slotmachine.controller;

import de.gamomat.challenge.slotmachine.data.PullResultDTO;
import de.gamomat.challenge.slotmachine.data.SlotMachine;
import de.gamomat.challenge.slotmachine.service.SlotMachineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SlotMachineController {

    private final SlotMachineService slotMachineService;

    public SlotMachineController(final SlotMachineService slotMachineService) {
        this.slotMachineService = slotMachineService;
    }

    @GetMapping("/slot-machine/{id}")
    public PullResultDTO pullSlotMachine(@PathVariable final String id) {
        SlotMachine slotMachine = slotMachineService.getSlotMachine(id);
        return slotMachineService.pullSlotMachine(slotMachine);
    }
}

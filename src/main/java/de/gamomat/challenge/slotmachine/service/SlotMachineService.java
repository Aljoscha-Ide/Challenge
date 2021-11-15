package de.gamomat.challenge.slotmachine.service;
import de.gamomat.challenge.slotmachine.data.PullResultDTO;
import de.gamomat.challenge.slotmachine.data.SlotMachine;

public interface SlotMachineService {
     SlotMachine getSlotMachine(String id);
     PullResultDTO pullSlotMachine(SlotMachine slotMachine);
}

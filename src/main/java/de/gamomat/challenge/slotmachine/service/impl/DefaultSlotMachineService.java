package de.gamomat.challenge.slotmachine.service.impl;

import com.google.common.collect.Iterators;
import com.google.common.collect.TreeBasedTable;
import de.gamomat.challenge.slotmachine.data.*;
import de.gamomat.challenge.slotmachine.service.SlotMachineService;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.*;

@Service
public class DefaultSlotMachineService implements SlotMachineService {

    private static final SecureRandom SPIN_GENERATOR = new SecureRandom();

    @Override
    public SlotMachine getSlotMachine(String id) {
        // Pretend there is a DAO-layer here, which gets the configured slot machines from some database.
        return null;
    }

    @Override
    public PullResultDTO pullSlotMachine(SlotMachine slotMachine) {
        TreeBasedTable<Integer, Integer, Symbol> resultMatrix = TreeBasedTable.create();

        for (Integer reelIndex : slotMachine.getReels().keySet()) {
            final Reel reel = slotMachine.getReels().get(reelIndex);
            final TreeMap<Integer, Symbol> reelSpinResult = spinReelAndGetResult(reel, slotMachine.getResultSize());
            reelSpinResult.forEach((rowIndex, symbol) -> resultMatrix.put(rowIndex, reelIndex, symbol));
        }
        final PullResultDTO pullResultDTO = new PullResultDTO(resultMatrix);

        calculateLines(pullResultDTO, slotMachine);
        calculateTotalWinAmount(pullResultDTO);

        return pullResultDTO;
    }

    private void calculateTotalWinAmount(PullResultDTO pullResultDTO) {
        pullResultDTO.setTotalWinAmount(pullResultDTO.getWinLines().stream().map(WinLineDTO::getWinAmount).reduce(0.0d, Double::sum));
    }

    private void calculateLines(PullResultDTO pullResultDTO, SlotMachine slotMachine) {
        TreeBasedTable<Integer, Integer, Symbol> resultMatrix = pullResultDTO.getResultMatrix();
        final ArrayList<WinLine> winLines = slotMachine.getWinLines();
        final ArrayList<WinLineDTO> linesThatWon = new ArrayList<>();
        for (WinLine winLine : winLines) {
            if(lineWon(resultMatrix, winLine)){
                //Could have more complex logic + converter/populator.
                linesThatWon.add(new WinLineDTO(winLine));
            }
        }
        pullResultDTO.setWinLines(linesThatWon);
    }

    private boolean lineWon(TreeBasedTable<Integer, Integer, Symbol> resultMatrix, WinLine winLine) {
       return winLine.getWinSymbols().stream().allMatch(winSymbol -> symbolMatches(resultMatrix, winSymbol));
    }

    private boolean symbolMatches(TreeBasedTable<Integer, Integer, Symbol> resultMatrix, WinSymbol winSymbol) {
        return winSymbol.getSymbol().equals(resultMatrix.get(winSymbol.getRowIndex(), winSymbol.getColumnIndex()));
    }

    private TreeMap<Integer, Symbol> spinReelAndGetResult(Reel reel, Integer resultSize) {
        final LinkedList<Symbol> symbols = reel.getSymbols();
        final Iterator<Symbol> cyclicSymbolIterator = Iterators.cycle(symbols);
        // Zero means no "rotation" at all, symbols.size() would be a full "rotation",
        // therefore we only allow a rotation to the last element (size() - 1).
        // And yes, I know that low level array logic would be a lot more efficient.
        final Integer rotations = SPIN_GENERATOR.nextInt(symbols.size() - 1);
        spinReel(cyclicSymbolIterator, rotations);
        return getSpinResult(resultSize, cyclicSymbolIterator);
    }

    private TreeMap<Integer, Symbol> getSpinResult(Integer resultSize, Iterator<Symbol> cyclicSymbolIterator) {
        final TreeMap<Integer, Symbol> reelSpinResult = new TreeMap<>();
        for (int i = 0; i < resultSize; i++) {
            reelSpinResult.put(i, cyclicSymbolIterator.next());
        }
        return reelSpinResult;
    }

    private void spinReel(Iterator<Symbol> cyclicSymbolIterator, Integer rotations) {
        for (int i = 0; i <= rotations; i++) {
            cyclicSymbolIterator.next();
        }
    }
}

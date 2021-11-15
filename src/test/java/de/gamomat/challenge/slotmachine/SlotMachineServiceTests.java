package de.gamomat.challenge.slotmachine;

import de.gamomat.challenge.slotmachine.data.*;
import de.gamomat.challenge.slotmachine.service.SlotMachineService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SlotMachineServiceTests {
    final static LinkedList<Symbol> REEL1 = new LinkedList<>() {
        {
            add(Symbol.A);
            add(Symbol.C);
            add(Symbol.A);
            add(Symbol.C);
            add(Symbol.A);
            add(Symbol.C);
            add(Symbol.A);
            add(Symbol.B);
            add(Symbol.C);
            add(Symbol.C);
            add(Symbol.C);
            add(Symbol.A);
            add(Symbol.B);
            add(Symbol.C);
            add(Symbol.B);
            add(Symbol.C);
            add(Symbol.A);
            add(Symbol.C);
            add(Symbol.B);
            add(Symbol.A);
            add(Symbol.B);
            add(Symbol.A);
        }
    };
    final static LinkedList<Symbol> REEL2 = new LinkedList<>() {
        {
            add(Symbol.B);
            add(Symbol.C);
            add(Symbol.A);
            add(Symbol.B);
            add(Symbol.A);
            add(Symbol.C);
            add(Symbol.A);
            add(Symbol.C);
            add(Symbol.B);
            add(Symbol.C);
            add(Symbol.A);
            add(Symbol.A);
            add(Symbol.A);
            add(Symbol.B);
            add(Symbol.A);
            add(Symbol.B);
            add(Symbol.A);
            add(Symbol.B);
            add(Symbol.C);
            add(Symbol.B);
        }
    };
    final static LinkedList<Symbol> REEL3 = new LinkedList<>() {
        {
            add(Symbol.C);
            add(Symbol.B);
            add(Symbol.A);
            add(Symbol.A);
            add(Symbol.A);
            add(Symbol.A);
            add(Symbol.A);
            add(Symbol.C);
            add(Symbol.C);
            add(Symbol.B);
            add(Symbol.B);
            add(Symbol.C);
            add(Symbol.C);
            add(Symbol.A);
            add(Symbol.C);
            add(Symbol.A);
            add(Symbol.C);
            add(Symbol.A);
            add(Symbol.C);
            add(Symbol.A);
            add(Symbol.C);
        }
    };

    @Autowired
    private SlotMachineService slotMachineService;

    @Test
    void pullSlotMachineTest() {
        final SlotMachine testSlotMachine = getTestSlotMachine();

        final PullResultDTO testResult = slotMachineService.pullSlotMachine(testSlotMachine);

        // Not very useful tests
        assertThat(testResult.getResultMatrix()).isNotNull();
        assertThat(testResult.getWinLines()).isNotNull();
        assertThat(testResult.getTotalWinAmount()).isNotNull();
        assertThat(testResult.getTotalWinAmount()).isNotNegative();

        System.out.println(testResult.getResultMatrix());
        System.out.println(testResult.getWinLines().size());
        System.out.println("You won: " + testResult.getTotalWinAmount() + "€");

    }

    private SlotMachine getTestSlotMachine() {
        final SlotMachine testSlotMachine = new SlotMachine();
        testSlotMachine.setId("test");
        testSlotMachine.setResultSize(3);

        final Reel reel1 = new Reel();
        reel1.setId("Reel1");
        reel1.setSymbols(REEL1);
        final Reel reel2 = new Reel();
        reel2.setId("Reel2");
        reel2.setSymbols(REEL2);
        final Reel reel3 = new Reel();
        reel3.setId("Reel3");
        reel3.setSymbols(REEL3);
        final HashMap<Integer, Reel> reelMap = new HashMap<>();
        reelMap.put(0, reel1);
        reelMap.put(1, reel2);
        reelMap.put(2, reel3);
        testSlotMachine.setReels(reelMap);

        testSlotMachine.setWinLines(getWinLines());
        return testSlotMachine;
    }

    private ArrayList<WinLine> getWinLines() {
        final ArrayList<WinLine> winLines = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            final WinSymbol winSymbol11 = new WinSymbol(Symbol.A, i, 0);
            final WinSymbol winSymbol12 = new WinSymbol(Symbol.A, i, 1);
            final WinSymbol winSymbol13 = new WinSymbol(Symbol.A, i, 2);
            final WinSymbol winSymbol21 = new WinSymbol(Symbol.A, 0, i);
            final WinSymbol winSymbol22 = new WinSymbol(Symbol.A, 1, i);
            final WinSymbol winSymbol23 = new WinSymbol(Symbol.A, 2, i);
            final ArrayList<WinSymbol> winSymbols1 = new ArrayList<>() {
                {
                    add(winSymbol11);
                    add(winSymbol12);
                    add(winSymbol13);

                }
            };
            final ArrayList<WinSymbol> winSymbols2 = new ArrayList<>() {
                {
                    add(winSymbol21);
                    add(winSymbol22);
                    add(winSymbol23);
                }
            };
            final WinLine winLine = new WinLine();
            winLine.setWinAmount(0.1d);
            winLine.setWinSymbols(winSymbols1);
            winLines.add(winLine);
            final WinLine winLine2 = new WinLine();
            winLine2.setWinAmount(0.1d);
            winLine2.setWinSymbols(winSymbols2);
            winLines.add(winLine2);
        }

        for (int i = 0; i < 3; i++) {

            final WinSymbol winSymbol11 = new WinSymbol(Symbol.B, i, 0);
            final WinSymbol winSymbol12 = new WinSymbol(Symbol.B, i, 1);
            final WinSymbol winSymbol13 = new WinSymbol(Symbol.B, i, 2);
            final WinSymbol winSymbol21 = new WinSymbol(Symbol.B, 0, i);
            final WinSymbol winSymbol22 = new WinSymbol(Symbol.B, 1, i);
            final WinSymbol winSymbol23 = new WinSymbol(Symbol.B, 2, i);
            final ArrayList<WinSymbol> winSymbols1 = new ArrayList<>() {
                {
                    add(winSymbol11);
                    add(winSymbol12);
                    add(winSymbol13);

                }
            };
            final ArrayList<WinSymbol> winSymbols2 = new ArrayList<>() {
                {
                    add(winSymbol21);
                    add(winSymbol22);
                    add(winSymbol23);
                }
            };
            final WinLine winLine = new WinLine();
            winLine.setWinAmount(0.15d);
            winLine.setWinSymbols(winSymbols1);
            winLines.add(winLine);
            final WinLine winLine2 = new WinLine();
            winLine2.setWinAmount(0.15d);
            winLine2.setWinSymbols(winSymbols2);
            winLines.add(winLine2);
        }

        for (int i = 0; i < 3; i++) {

            final WinSymbol winSymbol11 = new WinSymbol(Symbol.C, i, 0);
            final WinSymbol winSymbol12 = new WinSymbol(Symbol.C, i, 1);
            final WinSymbol winSymbol13 = new WinSymbol(Symbol.C, i, 2);
            final WinSymbol winSymbol21 = new WinSymbol(Symbol.C, 0, i);
            final WinSymbol winSymbol22 = new WinSymbol(Symbol.C, 1, i);
            final WinSymbol winSymbol23 = new WinSymbol(Symbol.C, 2, i);
            final ArrayList<WinSymbol> winSymbols1 = new ArrayList<>() {
                {
                    add(winSymbol11);
                    add(winSymbol12);
                    add(winSymbol13);

                }
            };
            final ArrayList<WinSymbol> winSymbols2 = new ArrayList<>() {
                {
                    add(winSymbol21);
                    add(winSymbol22);
                    add(winSymbol23);
                }
            };
            final WinLine winLine = new WinLine();
            winLine.setWinAmount(0.2d);
            winLine.setWinSymbols(winSymbols1);
            winLines.add(winLine);
            final WinLine winLine2 = new WinLine();
            winLine2.setWinAmount(0.2d);
            winLine2.setWinSymbols(winSymbols2);
            winLines.add(winLine2);
        }


        return winLines;
    }


}

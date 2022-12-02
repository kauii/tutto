package Tutto.Logic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    Printer printer = new Printer();

    @BeforeEach
            public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
            public void restoreStreams() {
        System.setOut(originalOut);
    }

     // Test printer, source:
    //https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
    @Test
    void printTurn() {
        printer.printTurn(new int[]{1,2}, new int[]{5,3,2,1}, 500);
        assertEquals("\r\n==================\r\nCurrent points: 500\r\n=== Kept Dices ===\r\n1 2 \r\n=== Rolled Dices ===\r\nValue: 5 3 2 1 \r\nIndex: 1 2 3 4 \r\n\r\n" , outContent.toString());
    }
}
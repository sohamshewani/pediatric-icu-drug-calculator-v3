package com.example.pediatricicudrugcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputProcessorTest {
    private InputProcessor inputProcessor;
    private ConfigManager configManager;

    @BeforeEach
    public void setUp() {
        configManager = new ConfigManager();
        inputProcessor = new InputProcessor(configManager);
    }

    @Test
    public void testValidInput() throws InvalidInputException {
        Map<String, String> userInputs = Map.of("weight", "10.0", "drugName", "Amoxicillin");
        PatientInput input = inputProcessor.processInput(userInputs);
        assertEquals(10.0, input.getWeight());
        assertEquals("Amoxicillin", input.getDrugName());
    }

    @Test
    public void testInvalidWeight() {
        Map<String, String> userInputs = Map.of("weight", "-10.0", "drugName", "Amoxicillin");
        assertThrows(InvalidInputException.class, () -> inputProcessor.processInput(userInputs));
    }

    @Test
    public void testInvalidDrugName() {
        Map<String, String> userInputs = Map.of("weight", "10.0", "drugName", "");
        assertThrows(InvalidInputException.class, () -> inputProcessor.processInput(userInputs));
    }
}
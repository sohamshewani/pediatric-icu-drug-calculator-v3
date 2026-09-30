package com.example.pediatricicudrugcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SafetyValidatorTest {
    private SafetyValidator safetyValidator;
    private Map<String, String> drugInteractions;

    @BeforeEach
    public void setUp() {
        drugInteractions = Map.of("Amoxicillin", "Ceftriaxone");
        safetyValidator = new SafetyValidator();
    }

    @Test
    public void testValidateSafetyNoInteraction() {
        PatientInput input = new PatientInput(10.0, "Amoxicillin");
        boolean result = safetyValidator.validateSafety(input, drugInteractions);
        assertEquals(true, result);
    }

    @Test
    public void testValidateSafetyWithInteraction() {
        PatientInput input = new PatientInput(10.0, "Ceftriaxone");
        assertThrows(InteractionException.class, () -> safetyValidator.validateSafety(input, drugInteractions));
    }
}
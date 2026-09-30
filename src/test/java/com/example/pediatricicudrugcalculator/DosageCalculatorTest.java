package com.example.pediatricicudrugcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DosageCalculatorTest {
    private DosageCalculator dosageCalculator;
    private Map<String, Double> drugDosageMap;

    @BeforeEach
    public void setUp() {
        drugDosageMap = Map.of("Amoxicillin", 1.0, "Ceftriaxone", 2.0);
        dosageCalculator = new DosageCalculator();
    }

    @Test
    public void testCalculateDosage() {
        PatientInput input = new PatientInput(10.0, "Amoxicillin");
        double dosage = dosageCalculator.calculateDosage(input, drugDosageMap);
        assertEquals(1.0, dosage, 0.01);
    }
}
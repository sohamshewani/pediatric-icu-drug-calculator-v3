package com.example.pediatricicudrugcalculator;

import com.example.pediatricicudrugcalculator.exceptions.InvalidInputException;
import java.util.Map;

public class DosageCalculator {
    public double calculateDosage(PatientInput patientInput, Map<String, Double> drugDosageMap) {
        double weight = patientInput.getWeight();
        String drugName = patientInput.getDrugName();
        double dosage = drugDosageMap.getOrDefault(drugName, 0.0);
        return dosage * (weight / 10); // Assuming 10kg as the standard weight for pediatric calculations
    }
}

public class PatientInput {
    private final double weight;
    private final String drugName;

    public PatientInput(double weight, String drugName) {
        this.weight = weight;
        this.drugName = drugName;
    }

    public double getWeight() {
        return weight;
    }

    public String getDrugName() {
        return drugName;
    }
}
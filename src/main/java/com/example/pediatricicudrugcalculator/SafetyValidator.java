package com.example.pediatricicudrugcalculator;

import com.example.pediatricicudrugcalculator.exceptions.InteractionException;
import java.util.Map;

public class SafetyValidator {
    public boolean validateSafety(PatientInput patientInput, Map<String, String> drugInteractions) {
        String drugName = patientInput.getDrugName();
        if (drugInteractions.containsKey(drugName)) {
            throw new InteractionException("Drug interaction detected for "+ drugName);
        }
        return true;
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
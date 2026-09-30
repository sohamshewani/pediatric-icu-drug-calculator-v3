package com.example.pediatricicudrugcalculator;

import com.example.pediatricicudrugcalculator.exceptions.InvalidInputException;
import java.util.Map;
import java.util.logging.Logger;

public class InputProcessor {
    private static final Logger LOGGER = Logger.getLogger(InputProcessor.class.getName());
    private final ConfigManager configManager;

    public InputProcessor(ConfigManager configManager) {
        this.configManager = configManager;
    }

    public PatientInput processInput(Map<String, String> userInputs) throws InvalidInputException {
        // Validate input parameters
        String patientWeight = userInputs.get("weight");
        String drugName = userInputs.get("drugName");
        double weight = Double.parseDouble(patientWeight);
        if (weight <= 0) {
            throw new InvalidInputException("Invalid patient weight");
        }
        if (drugName == null || drugName.isEmpty()) {
            throw new InvalidInputException("Drug name is required");
        }

        // Validate against safety limits
        double maxWeightLimit = configManager.getMaxWeightLimit(drugName);
        if (weight > maxWeightLimit) {
            throw new InvalidInputException("Patient weight exceeds maximum allowed limit for drug");
        }

        return new PatientInput(weight, drugName);
    }
}

// Example of a simple data class
public class PatientInput {
    private final double weight;
    private final String drugName;

    public PatientInput(double weight, String drugName) {
        this.weight = weight;
        this.drugName = drugName;
    }
}

// Exception handling for input validation
public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}
package com.assignment.apple.problems;

import com.assignment.apple.exception.InputValidationException;

public class TyrannyOfTheRocketEquation {

    private String input;
    private static final String INPUT_ERR_MSG = "Not a Valid Input!!";

    public TyrannyOfTheRocketEquation(String input) {
        this.input = input;
    }

    public String getFuelRequirement() throws InputValidationException {
        if (!isValidInput(input))
            throw new InputValidationException(INPUT_ERR_MSG);

        String[] str = input.split("\n");
        int sum = 0;
        for (String s : str) {
            sum += calculateFuel(Integer.parseInt(s));
        }
        return Integer.toString(sum);
    }

    private int calculateFuel(int d) {
        int fuelReq = (int) Math.floor((double) d / 3) - 2;
        return fuelReq < 1 ? 0 : fuelReq;
    }

    private boolean isValidInput(String input) {
        if (input == null || input.equals("") || input == "") return false;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) return false;
        }
        return true;
    }
}

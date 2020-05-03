package com.assignment.apple.problems;

import com.assignment.apple.exception.InputValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SecureContainer {
    private String input;
    private static final String INPUT_ERR_MSG = "Not a Valid Input!!";

    public SecureContainer(String input) {
        this.input = input;
    }

    public String getNumberOfPasswordInRange() throws InputValidationException {
        if (!isValidInput(input))
            throw new InputValidationException(INPUT_ERR_MSG);
        List<Integer> list = sanatizeAndGetRange(input);
        int count = 0;
        for (int i = list.get(0); i <= list.get(1); i++) {
            if (validatePassword(i)) count++;
        }
        return Integer.toString(count);
    }

    private List<Integer> sanatizeAndGetRange(String input) {
        String[] split = input.split("-");
        int start = Integer.parseInt(split[0].trim());
        int end = split.length > 1 ? Integer.parseInt(split[1].trim()) : start;
        return new ArrayList<Integer>() {
            {
                add(start);
                add(end);
            }
        };
    }

    public boolean validatePassword(int val) {
        char[] chars = Integer.toString(val).toCharArray();
        boolean incrementFlag = true;
        for (int i = 0; i < chars.length - 1; i++) {
            if (!(chars[i] <= chars[i + 1])) {
                incrementFlag = false;
            }
        }
        Map<Character, Long> sequences = Integer.toString(val).chars()
                .mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return incrementFlag && sequences.entrySet().stream().anyMatch(entry -> entry.getValue() > 1L);
    }

    private boolean isValidInput(String input) {
        if (input == null || input.equals("") || input == "" || !input.contains("-")) return false;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) return false;
        }
        return true;
    }
}

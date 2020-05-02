package com.assignment.apple;

import com.assignment.apple.exception.InputValidationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
public class TyrannyOfTheRocketEquationTest {

    public static final String EXPECTED_OUTPUT = "33583";
    public static final String SAMPLE_INPUT = "100756";
    public static final String SAMPLE_STRING_INPUT = "abcd";

    private TyrannyOfTheRocketEquation tyrannyOfTheRocketEquation;

    @Test
    public void getFuelRequirementOnSuccess() throws InputValidationException {
        tyrannyOfTheRocketEquation = new TyrannyOfTheRocketEquation(SAMPLE_INPUT);
        Assert.assertEquals(EXPECTED_OUTPUT, tyrannyOfTheRocketEquation.getFuelRequirement());
    }

    @Test
    public void getFuelRequirementOnNullFailure() throws InputValidationException {
        tyrannyOfTheRocketEquation = new TyrannyOfTheRocketEquation("");
        Exception exception = assertThrows(Exception.class, () -> {
            tyrannyOfTheRocketEquation.getFuelRequirement();
        });

        String expectedMessage = "Not a Valid Input!!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void getFuelRequirementStringInputFailure() throws InputValidationException {
        tyrannyOfTheRocketEquation = new TyrannyOfTheRocketEquation(SAMPLE_STRING_INPUT);
        Exception exception = assertThrows(Exception.class, () -> {
            tyrannyOfTheRocketEquation.getFuelRequirement();
        });
        String expectedMessage = "Not a Valid Input!!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
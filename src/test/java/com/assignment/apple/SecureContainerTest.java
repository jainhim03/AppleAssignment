package com.assignment.apple;

import com.assignment.apple.exception.InputValidationException;
import com.assignment.apple.problems.SecureContainer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
public class SecureContainerTest {

    public static final String EXPECTED_OUTPUT = "2835";
    public static final String SAMPLE_INPUT = "111111-600000";
    public static final String SAMPLE_STRING_INPUT = "abcd";

    private SecureContainer secureContainer;

    @Test
    public void getNumberOfPasswordInRangeOnSuccess() throws InputValidationException {
        secureContainer = new SecureContainer(SAMPLE_INPUT);
        Assert.assertEquals(EXPECTED_OUTPUT, secureContainer.getNumberOfPasswordInRange());
    }

    @Test
    public void getNumberOfPasswordInRangeOnSuccessInputShortRange() throws InputValidationException {
        secureContainer = new SecureContainer("000000-000011");
        Assert.assertEquals("1", secureContainer.getNumberOfPasswordInRange());
    }

    @Test
    public void getNumberOfPasswordInRangeOnSuccessInputNoRange() throws InputValidationException {
        secureContainer = new SecureContainer("000000-000000");
        Assert.assertEquals("0", secureContainer.getNumberOfPasswordInRange());
    }

    @Test
    public void getNumberOfPasswordInRangeOnNullFailure() throws InputValidationException {
        secureContainer = new SecureContainer("");
        Exception exception = assertThrows(Exception.class, () -> {
            secureContainer.getNumberOfPasswordInRange();
        });

        String expectedMessage = "Not a Valid Input!!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void getNumberOfPasswordInRangeStringInputFailure() throws InputValidationException {
        secureContainer = new SecureContainer(SAMPLE_STRING_INPUT);
        Exception exception = assertThrows(Exception.class, () -> {
            secureContainer.getNumberOfPasswordInRange();
        });
        String expectedMessage = "Not a Valid Input!!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void validatePasswordOnSuccess() throws InputValidationException {
        secureContainer = new SecureContainer(SAMPLE_INPUT);
        Assert.assertTrue(secureContainer.validatePassword(111111));
    }

    @Test
    public void validatePasswordOnFailure() throws InputValidationException {
        secureContainer = new SecureContainer(SAMPLE_INPUT);
        Assert.assertFalse(secureContainer.validatePassword(223450));
    }

    @Test
    public void validatePasswordOnFailure1() throws InputValidationException {
        secureContainer = new SecureContainer(SAMPLE_INPUT);
        Assert.assertFalse(secureContainer.validatePassword(123789));
    }
}
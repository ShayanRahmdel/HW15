package util;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Hibervalidation {
   public static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    public static Validator validator = validatorFactory.getValidator();
}

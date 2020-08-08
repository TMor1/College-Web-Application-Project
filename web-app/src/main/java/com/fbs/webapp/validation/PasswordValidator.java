package com.fbs.webapp.validation;

//import com.fbs.webapp.validation.ValidPassword;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.passay.DictionaryRule;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.Rule;
import org.passay.RuleResult;

/* ===== The Validation Classes are Under Development. The code in this folder shows the beginning of the development. ===== */
public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

  public PasswordValidator(List<Rule> list) {
  }
  /* ===== Learned from: https://www.baeldung.com/java-passay - Listed in References in the Techinal Report */
  @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
      PasswordValidator validator = new PasswordValidator(Arrays.asList(
        /* ===== Set Password Rules according to NIST Standards - 8 Characters Min, Allow Passwords, Blacklist Common Passwords ===== */
        /* ===== Min 8 Characters ===== */
        new LengthRule(8, 60),
        /* ===== Dictionary Blacklist ===== */
        new DictionaryRule()
          ));
        
    RuleResult result = validator.validate(new PasswordData(password));
    if (result.isValid()) {
      return true;
    }
      
    List<String> messages = validator.getMessages(result);

    String messageTemplate = messages.stream().collect(Collectors.joining(","));
    
    context.buildConstraintViolationWithTemplate(messageTemplate).addConstraintViolation().disableDefaultConstraintViolation();
    
    return false;
  }

  private RuleResult validate(PasswordData passwordData) {
    return null;
  }

  private List<String> getMessages(RuleResult result) {
    return null;
  }
}
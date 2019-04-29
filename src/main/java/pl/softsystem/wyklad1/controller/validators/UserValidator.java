package pl.softsystem.wyklad1.controller.validators;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.softsystem.wyklad1.model.UserModel;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserModel user = (UserModel) target;

        if (user == null) {
            throw new ValidationException("User can't be null!");
        }

        if (StringUtils.isBlank(user.getName())) {
            throw new ValidationException("User name can't be empty");
        }

        if (StringUtils.isBlank(user.getLogin())) {
            throw new ValidationException("User login can't be empty");
        }

    }
}

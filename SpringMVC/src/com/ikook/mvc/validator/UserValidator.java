package com.ikook.mvc.validator;

import com.ikook.mvc.model.User;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {

        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "username", "Username.is.empty", "用户名不能为空");
        User user = (User) o;

        if (null == user.getPassword() || "".equals(user.getPassword())) {
            // 指定验证失败的字段名、错误码、默认错误信息
            errors.rejectValue("password", "Password.is.empty", "密码不能为空");
        } else if (user.getPassword().length() < 6) {
            // 指定验证失败的字段名、错误码、默认错误信息
            errors.rejectValue("password", "length.to.short", "密码长度不得小于 6 位");
        }
    }
}

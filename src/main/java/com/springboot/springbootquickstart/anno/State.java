package com.springboot.springbootquickstart.anno;

import com.springboot.springbootquickstart.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented // 元注解
@Target({FIELD}) // 元注解
@Retention(RUNTIME) // 元注解
@Constraint(validatedBy = {StateValidation.class}) // 指定提供校验规则的类

public @interface State {
  String message() default "state参数必须为0或1"; // 校验失败信息

  Class<?>[] groups() default {}; // 分组信息

  Class<? extends Payload>[] payload() default {}; // 获取status注解的附加信息
}

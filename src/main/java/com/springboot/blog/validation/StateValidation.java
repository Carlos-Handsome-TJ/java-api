package com.springboot.blog.validation;

import com.springboot.blog.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StateValidation implements ConstraintValidator<State, Integer> {
  //  ConstraintValidator<校验的对象，校验的类型>

  /**
   * @param value   要校验的数据
   * @param context
   * @return
   */
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    // 校验规则
    if (value == null) return false;
    if (value == 0 || value == 1) return true;
    return false;
  }
}

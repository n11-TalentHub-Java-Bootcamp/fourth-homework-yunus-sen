package com.yunussen.debtpaymentws.service;

import com.sun.istack.NotNull;
import com.yunussen.debtpaymentws.shared.dto.UserDto;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserService {

    UserDto getUserById(@NotNull Long id);
    UserDto save(@Validated UserDto user);
    void deleteById(@NotNull Long id);
    UserDto update (@Validated UserDto user);
}

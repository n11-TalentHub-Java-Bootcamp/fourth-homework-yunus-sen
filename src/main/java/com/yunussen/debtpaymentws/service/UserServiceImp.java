package com.yunussen.debtpaymentws.service;

import com.yunussen.debtpaymentws.entity.UserEntity;
import com.yunussen.debtpaymentws.repository.UserRepository;
import com.yunussen.debtpaymentws.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto getUserById(Long id) {
        return modelMapper.map(userRepo.getById(id),UserDto.class) ;
    }

    @Override
    public UserDto save(UserDto user) {
        return modelMapper.map(userRepo.save(modelMapper.map(user, UserEntity.class)),UserDto.class);
    }

    @Override
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserDto update(UserDto user) {
        UserEntity storedUser=userRepo.getById(user.getId());
        storedUser.setName(user.getName());
        storedUser.setName(user.getName());
        storedUser.setPhoneNumber(user.getPhoneNumber());
        return modelMapper.map(userRepo.save(storedUser),UserDto.class);
    }
}

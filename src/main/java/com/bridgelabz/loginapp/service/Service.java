package com.bridgelabz.loginapp.service;

public interface Service {
String login(String userName,String password);
int register(String userName,String email,String password,String cPassword,String mobile,String gender);
}

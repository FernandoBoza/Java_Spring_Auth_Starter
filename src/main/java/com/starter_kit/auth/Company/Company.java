package com.starter_kit.auth.Company;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Company {
    @Id
    public String id;
    public String name;
    public List<String> usersId;
}

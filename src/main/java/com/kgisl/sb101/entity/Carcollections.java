package com.kgisl.sb101.entity;

import org.springframework.data.annotation.Id;
//create unique id in runtime
public record Carcollections(@Id Integer id, Integer customertnno, String customername, String customerdate,String customercar) {

}

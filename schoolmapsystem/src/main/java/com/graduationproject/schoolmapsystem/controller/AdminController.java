package com.graduationproject.schoolmapsystem.controller;


import com.graduationproject.schoolmapsystem.entity.Admin;
import com.graduationproject.schoolmapsystem.service.AdminService;
import com.graduationproject.schoolmapsystem.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ResultCheckStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaoyiquan&panzhengyang
 * @since 2021-01-03
 */
@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("adminDetail")
    public List<Admin> adminDetail(){
        List<Admin> list=adminService.list();
        return list;
    }

}

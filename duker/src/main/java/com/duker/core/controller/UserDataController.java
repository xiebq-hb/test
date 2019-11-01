package com.duker.core.controller;


import com.duker.core.entity.UserDataEntity;
import com.duker.core.service.IUserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiebq
 * @since 2019-10-17
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserDataController {

    @Autowired
    private IUserDataService userDataService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> getUserList(){
        List<UserDataEntity> list = userDataService.list();
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "成功");
        res.put("data", list);
        return res;
    }
}


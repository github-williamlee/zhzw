package com.oracle.hrb.zhzw.web;

import com.oracle.hrb.zhzw.bean.Dic;
import com.oracle.hrb.zhzw.bean.Result;
import com.oracle.hrb.zhzw.service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dic")
public class DicController {
    @Autowired
    DicService dicService;
    @PostMapping
    public Result getDic(@RequestBody ArrayList<String> types) {
        Result r = new Result();
        Map<String, List<Dic>> map = new HashMap<>();
        for(String type : types) {
            List<Dic> dics = dicService.findDicsByType(type);
            map.put(type, dics);
        }
        r.setData(map);
        return r;
    }
}

package com.fzz.controller;

import com.fzz.pojo.MapData;
import com.fzz.service.CityService;
import com.fzz.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by huayu on 2017/6/11.
 */
@RestController
@RequestMapping("map")
public class MapController {
    @Autowired
    CityService cityService;

    @RequestMapping("random")
    public List<MapData> randomtest() {
        List<MapData> data = new ArrayList<>();
        List<String> citys=cityService.getAllCity();
        Iterator<String> cityiterator=citys.iterator();
        while (cityiterator.hasNext()){
            MapData mapData=new MapData();
            mapData.setName(cityiterator.next());
            mapData.setValue(NumberUtil.getRandomInt());
            data.add(mapData);
        }
        return data;
    }
}

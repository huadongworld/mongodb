package com.ys.mongodb.controller;

import com.ys.mongodb.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HD
 * @date 2018/10/17 9:00
 */
@RestController
public class MongoController {

    @Autowired
    private MongoService mongoService;


}

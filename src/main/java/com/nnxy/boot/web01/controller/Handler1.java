package com.nnxy.boot.web01.controller;

import com.nnxy.boot.web01.bean.Person;
import com.nnxy.boot.web01.bean.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author：MengYinChang
 * @create at: 2021-05-01  13:35
 */
@Controller
public class Handler1 {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String source) {
                        if (source != null){
                            Pet pet = new Pet();
                            String[] split = source.split(",");
                            pet.setName(split[0]);
                            pet.setAge(Integer.parseInt(split[1]));
                            return pet;
                        }
                        return null;
                    }
                });
            }
        };



    }



    @ResponseBody
    @GetMapping("/car/{path}")
    public Map getcat(@MatrixVariable("username") String username
                        ,@MatrixVariable("age") Integer age
                        ,@PathVariable("path") String path){
        System.out.println("-----------------S");
        Map<String, Object> map = new HashMap<>();
        map.put("username",username);
        map.put("age",age);
        map.put("path",path);


        return map;
    }

    @ResponseBody// 利用返回值处理器里面的消息转换器进行处理
    @PostMapping("/getPersonInfo")
    public Person getPersonInfo(Person person){

        return person;
    }
    }


package com.service;

import com.entity.Dog;

/**
 * 狗狗表业务逻辑接口
 */
public interface DogService {

    /**
     * 添加狗狗信息到数据库
     * @param dog
     * @return
     */
    public String addDogInfoOf(Dog dog);
}

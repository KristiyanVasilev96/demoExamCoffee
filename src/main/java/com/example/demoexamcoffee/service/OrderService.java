package com.example.demoexamcoffee.service;

import com.example.demoexamcoffee.model.services.OrderServiceModel;
import com.example.demoexamcoffee.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrderByPriceDesc();


    void readyOrder(Long id);
}

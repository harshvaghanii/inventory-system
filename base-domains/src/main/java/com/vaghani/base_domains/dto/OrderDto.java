package com.vaghani.base_domains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private String id;

    private String name;

    private int quantity;

    private double price;
}

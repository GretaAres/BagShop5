package com.example.BagShop.model;

import com.example.BagShop.enums.BagType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bag {
    private   int id;
    private String name;
    private String description;
    private double price;
    private int count;
    private String picUrl;
    private BagType type;
}

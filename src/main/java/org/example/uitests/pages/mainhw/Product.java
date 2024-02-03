package org.example.uitests.pages.mainhw;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)

public class Product {
    private String name;
    private double price;


}


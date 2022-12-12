package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {
    private long id;
    private String name;
    private String author;
    private double price;
    private int quantity;

    @Override
    public String toString() {
        return "Id: " + id + " Name: " + name + " Author: " + author + " Price: " + price + " Quantity: " + quantity;
    }
}

package com.book.dto;


import com.book.json.CustomDeserializer;
import com.book.json.CustomSerializer;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonSerialize(using = CustomSerializer.class)
@JsonDeserialize(using = CustomDeserializer.class)
public class BookDTO {
	private int id;
    private String title;
    private String author;
    private double price;
    private String isbn;
    @JsonGetter("price")
    public String getFormattedPrice() {
        return String.format("%.2f", price);
    }

    // Custom setter for price
    @JsonSetter("price")
    public void setFormattedPrice(String price) {
        this.price = Double.parseDouble(price);
    }
}

package net.skhu.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    int id;
    String title;
    String author;
    int categoryId;
    int price;
    int publisherId;
    Date time;
    boolean available;


    Category category;
    Publisher publisher;

}

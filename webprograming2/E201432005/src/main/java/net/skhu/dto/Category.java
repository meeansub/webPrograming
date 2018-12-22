package net.skhu.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String categoryName;

}

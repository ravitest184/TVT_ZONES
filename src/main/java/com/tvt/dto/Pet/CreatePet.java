package com.tvt.dto.Pet;

import java.util.List;
import lombok.Data;

@Data
public class CreatePet {
    private int id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;
    
}

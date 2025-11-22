package com.example.radio.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("tracks")
@NoArgsConstructor
@AllArgsConstructor
public class TrackEntity {
    @Id
    private String id;
    private String title;
    private String artist;
    private String genre;
    
    private Integer duration; // Нове поле
    private String status;    // Нове поле (PROCESSING, READY, ERROR)
}
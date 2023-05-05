package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="categories")
public class Category {
   @Id
   @Column(name="id")
   private String categoryId;
   
   @Column(name="category_title" ,length=60,nullable = false)
   private String title;
   
   @Column(name="category_desc",length = 500)
   private String description;
   
   private String coverImage;
   
}

package com.example.demo.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "post")
@AllArgsConstructor
@EqualsAndHashCode
@Data
@NoArgsConstructor
@ToString
public class Post implements Serializable {

    @Id
    private Long id;
    @Column(name = "num_of_likes")
    private int numOfLikes;
    private Date date;
    private String content;

}

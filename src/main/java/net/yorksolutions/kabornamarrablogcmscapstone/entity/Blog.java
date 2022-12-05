package net.yorksolutions.kabornamarrablogcmscapstone.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private String body;

    private Date createdDate;

    private Date updatedDate;

    @ManyToOne
    private Account author;
}

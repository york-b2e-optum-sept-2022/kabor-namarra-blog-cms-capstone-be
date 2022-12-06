package net.yorksolutions.kabornamarrablogcmscapstone.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

}

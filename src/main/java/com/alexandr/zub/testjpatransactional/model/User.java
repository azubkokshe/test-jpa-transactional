package com.alexandr.zub.testjpatransactional.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "usr")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Getter
    @Setter
    Long id;

    @Getter
    @Setter
    @NotNull
    String name;

    @Getter
    @Setter
    @NotNull
    int age;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    @NotNull
    Sex sex;
}

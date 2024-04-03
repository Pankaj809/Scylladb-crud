package com.example.entity;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Introspected
@SerdeImport
public class Employee {
    private int eid;
    private String name;
    private String department;

}

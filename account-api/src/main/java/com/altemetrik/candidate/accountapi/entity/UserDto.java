package com.altemetrik.candidate.accountapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

        private Long id;
        private String name;
        private String email;
        private Double monthlySalary;
        private Double monthlyExp;
}

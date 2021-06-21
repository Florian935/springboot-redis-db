package com.florian935.demo.redisdb.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author florian935
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = PRIVATE)
@RedisHash("students")
public class Student {
    String id;

    @NotEmpty(message = "Name can not be null or empty")
    String name;

    @NotNull(message = "Gender can not be null")
    Gender gender;

    @Min(value = 18, message = "Age can not be less than 18")
    int age;

    String errMsg;
}

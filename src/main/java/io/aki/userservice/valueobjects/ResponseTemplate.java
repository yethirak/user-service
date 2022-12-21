package io.aki.userservice.valueobjects;

import io.aki.userservice.entity.UserName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplate {

    private UserName user;
    private Department department;
}

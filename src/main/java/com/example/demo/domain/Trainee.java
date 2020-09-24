package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trainee {

    private Long id;

    @NotNull(message = "姓名不能为空")
    private String name;

    @NotNull(message = "办公室不能为空")
    private String office;

    @NotNull(message = "邮箱地址不能为空")
    @Email(message = "邮箱地址不合法")
    private String email;

    @NotNull(message = "github不能为空")
    private String github;

    @NotNull(message = "zoomId不能为空")
    private String zoomId;
}
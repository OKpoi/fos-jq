package com.fos.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginVO {
  private String userId;
  private String password;
}

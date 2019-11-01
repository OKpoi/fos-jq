package com.fos.vo;

import lombok.Builder;
import lombok.Data;

/** @author FULO2 */
@Data
@Builder
public class LoginVO {
  private String userId;
  private String password;
}

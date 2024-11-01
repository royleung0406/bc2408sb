package com.bootcamp2408.bc_yahoo_finance.util;

public class BusinessException extends RuntimeException {
  private int code;

  // public static BusinessException of(ErrorCode errorCode) {
  //   return new BusinessException(errorCode);
  // }

  // public static BusinessException of(ErrorCode errorCode, String overrideMessage) {
  //   return new BusinessException(errorCode, overrideMessage);
  // }

  public BusinessException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.code = errorCode.getCode();
  }

  public BusinessException(ErrorCode error, String overrideMessage) {
    super(overrideMessage);
    this.code = error.getCode();
  }

  public int getCode() {
    return this.code;
  }
}
package com.bootcamp2408.bc_forum.exception;

import org.springframework.web.client.RestClientException;

public class JPHUserError extends RestClientException {
  public JPHUserError(String msg) {
		super(msg);
}
}

package com.bootcamp2408.bc_forum.exception;

import org.springframework.web.client.RestClientException;

public class JPHPostError extends RestClientException {
  public JPHPostError(String msg) {
		super(msg);
}
}

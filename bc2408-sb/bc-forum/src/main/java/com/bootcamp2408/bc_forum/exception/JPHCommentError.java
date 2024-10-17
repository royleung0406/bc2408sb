package com.bootcamp2408.bc_forum.exception;

import org.springframework.web.client.RestClientException;

public class JPHCommentError extends RestClientException {
  public JPHCommentError(String msg) {
		super(msg);
}
}

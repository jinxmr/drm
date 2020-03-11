package com.ddl.config.exceptionHandler;

import com.ddl.model.AjaxResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler
	public AjaxResult processException(Exception ex, HttpServletRequest request, HttpServletResponse response) {

		if (ex instanceof MissingServletRequestParameterException) {
			return AjaxResult.error(400, ex);
		}
		if (ex instanceof DrmExceptionHandler) {

			log.error("=======" + ex.getMessage() + "=======");
			return AjaxResult.error(401, "sorry，无权限！");

		}

		if (ex instanceof DuplicateKeyException) {
			log.error("=======违反主键约束：主键重复插入=======");
			return AjaxResult.error(400, "主键重复插入！");
		}

		/**
		 * 未知异常
		 */
		log.error(ex.toString() + " - " + ex.getStackTrace()[0].toString());
		return AjaxResult.error(500, ex.getMessage());

	}

}
package com.consulta.security;

import java.time.LocalDate;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler {

	//Exception para un usuario no encontrado
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErroresDetectados> handleAllException(Exception ex, WebRequest request) throws Exception {
		
		ErroresDetectados errores = new ErroresDetectados(LocalDate.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErroresDetectados>(errores, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UsuarioNoEncontrado.class)
	public final ResponseEntity<ErroresDetectados> handleNotFoundException(Exception ex, WebRequest request) throws Exception {
		
		ErroresDetectados errores = new ErroresDetectados(LocalDate.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErroresDetectados>(errores, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

			ErroresDetectados argumentosNoValidos = new ErroresDetectados(LocalDate.now(), 
					"Total De Errores : "+ex.getErrorCount() + "| " + ex.getFieldError().getDefaultMessage(), request.getDescription(false));
		
		return new ResponseEntity(argumentosNoValidos, HttpStatus.BAD_REQUEST);
	}

	
	
	
}

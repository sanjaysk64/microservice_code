package CrudOperations.exceptionhandller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// create map to take custom exception messages
		Map<String, Object> map = new HashMap<>();

		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(exception -> exception.getDefaultMessage()).collect(Collectors.toList());

		// put in map

		map.put("errors", errors);
		map.put("status", HttpStatus.BAD_REQUEST);

		return new ResponseEntity<Object>(map, headers, status);
	}

	@ExceptionHandler
	public String handleInvalidAge(AgeInvalidException ageInvalidException) {
		return ageInvalidException.getMessage();
	}

}

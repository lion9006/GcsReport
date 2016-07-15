package src.common;

import java.io.IOException;

public interface BusinessInterface {
	static final String RESULT_SUCCESS = "SUCCESS"; 
	static final String RESULT_SUCCESS2 = "SUCCESS2";
	static final String RESULT_ERROR = "ERROR";
	static final String RESULT_ERROR2 = "ERROR2";

	
	public String doBusiness(ActionForm formData) throws IOException;
	
}

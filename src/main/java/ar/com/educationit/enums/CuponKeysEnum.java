package ar.com.educationit.enums;

public enum CuponKeysEnum {

	CUPONES("CUPONES"), 
	CUPON("CUPON")
	;
	
	private String key;
	
	private CuponKeysEnum(String key) {
		this.key = key;			
	}

	public String getKey() {
		return key;
	}
	
}

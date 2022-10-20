package ar.com.educationit.domain;

public enum CuponViewEnum {

	LIST("/cupon/list"),
	EDIT("/cupon/edit"),
	NEW("/cupon/new")
	;
	
	private String view;
	
	private CuponViewEnum(String view) {
		this.view = view;
	}

	public String getView() {
		return view;
	}

}

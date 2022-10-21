package ar.com.educationit.enums;

public enum CuponViewEnum {

	LIST("/cupon/list"),
	EDIT("/cupon/edit"),
	NEW("/cupon/new"),
	LIST_REDIRECT("redirect:/cupon/list"),
	;
	
	private String view;
	
	private CuponViewEnum(String view) {
		this.view = view;			
	}

	public String getView() {
		return view;
	}
	
}

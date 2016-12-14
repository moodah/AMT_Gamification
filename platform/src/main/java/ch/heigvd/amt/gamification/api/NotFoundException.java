package ch.heigvd.amt.gamification.api;

@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-13T18:36:02.067Z")

public class NotFoundException extends ApiException {
	private int code;
	public NotFoundException (int code, String msg) {
		super(code, msg);
		this.code = code;
	}
}

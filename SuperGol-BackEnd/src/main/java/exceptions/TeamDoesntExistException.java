package exceptions;

public class TeamDoesntExistException extends RuntimeException {

	public TeamDoesntExistException(String string) {
		super(string);
	}

}

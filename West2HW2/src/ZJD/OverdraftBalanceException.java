package ZJD;

public class OverdraftBalanceException extends RuntimeException{
	String message = "";

    public OverdraftBalanceException(String message) {

       this.message = message;

    }

    @Override

    public String toString() {

       return message;

    }
}

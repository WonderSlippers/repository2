package ZJD;

public class IngredientSortOutException extends RuntimeException {
	String message = "";

    public  IngredientSortOutException(String message) {

       this.message = message;

    }

    @Override

    public String toString() {

       return message;

    }
}

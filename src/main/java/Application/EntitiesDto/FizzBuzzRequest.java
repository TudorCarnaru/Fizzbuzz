package Application.EntitiesDto;

import java.io.Serializable;

public class FizzBuzzRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String lowerBound;
    private String upperBound;

    public String getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(String lowerBound) {
        this.lowerBound = lowerBound;
    }

    public String getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(String upperBound) {
        this.upperBound = upperBound;
    }
}

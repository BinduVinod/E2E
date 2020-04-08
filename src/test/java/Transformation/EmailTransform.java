package Transformation;

import cucumber.api.Transformer;

public class EmailTransform extends Transformer<String> {
    public String transform(String email) {
        return email.concat("@gmail.com");
    }
}

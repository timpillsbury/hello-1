package net.kimleo.hello.message;

import net.kimleo.hello.text.TokenVisitor;
import net.kimleo.hello.validate.Validator;
import net.kimleo.inject.annotation.Component;
import net.kimleo.inject.annotation.Inject;
import net.kimleo.inject.annotation.Qualified;

import java.io.PrintStream;

@Component
public class ConcreteTokenVisitor implements TokenVisitor {

    @Inject
    private Validator<String> validator;

    @Override
    public void visit(String token) {
        validator.validate(token);
    }

    public TokenVisitor withStream(PrintStream stream) {
        return token -> {
            visit(token);
            if (validator.validate(token))
                stream.println(token);
        };
    }
}

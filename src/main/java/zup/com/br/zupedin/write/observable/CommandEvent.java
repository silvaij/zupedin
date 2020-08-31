package zup.com.br.zupedin.write.observable;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import zup.com.br.zupedin.common.InternalEvent;
import zup.com.br.zupedin.write.domain.application.Command;
import zup.com.br.zupedin.write.domain.exception.DomainException;

public class CommandEvent extends InternalEvent {

    private final Command command;

    public CommandEvent(Command command) {
        startTimer();
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    @Override
    public Object getSource() {
        return getCommand();
    }

    public String toJson() {

        try {
            var mapper = new ObjectMapper();
            Map<String, Object> message = new HashMap<>(Map.of("event", getOrigin()));
            message.put("content", getCommand());
            message.put("elapsedTimeInMilli", getElapsedTimeInMilli());

            if (hasError()) {
                message.put("message", getException().getMessage());

                if (getException() instanceof DomainException domainException && domainException.hasError()) {
                    message.put("errors", domainException.getErrors().toString());
                }
            }

            return mapper.writeValueAsString(message);

        } catch (JsonProcessingException jsonException) {
            return String.format("%s - %s", command, jsonException);
        }
    }
}

package zup.com.br.zupedin.common;

public class ServiceBusInvalidObjectException extends RuntimeException {
	
	public ServiceBusInvalidObjectException(InternalEvent event) {
        super(String.format("ServiceBus does not recognizes Object of type: %s",
                event.getSource().getClass().getCanonicalName()));
    }

}

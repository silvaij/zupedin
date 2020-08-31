package zup.com.br.zupedin.read.observable;

import zup.com.br.zupedin.common.InternalEvent;
import zup.com.br.zupedin.read.domain.application.Query;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

public class QueryEvent extends InternalEvent {
    private final Query query;
    
    public QueryEvent(Query query) {
    	startTimer();
    	this.query = query;
    }
    
    public Query getQuery() {
    	return query;
    }

	@Override
	public Object getSource() {		
		return getQuery();
	}

	@Override
	public String toJson() {
		 try {
	           
			    var mapper = new ObjectMapper();
	            Map<String, Object> message = new HashMap<>(Map.of("event", getOrigin()));
	            message.put("content", getQuery());
	            message.put("elapsedTimeInMilli", getElapsedTimeInMilli());

	            if (hasError()) {
	                message.put("message", getException().getMessage());

	               // if (getException() instanceof DomainException domainException && domainException.hasError()) {
	               //     message.put("errors", domainException.getErrors().toString());
	              //  }
	            }

	            return mapper.writeValueAsString(message);

	        } catch (JsonProcessingException jsonException) {
	            return String.format("%s - %s", query, jsonException);
	        }
	    }
	}


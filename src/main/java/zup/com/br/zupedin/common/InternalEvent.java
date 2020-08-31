package zup.com.br.zupedin.common;

import zup.com.br.zupedin.common.Type;

public abstract class InternalEvent {
	
	private Exception exception;
	private long startTime;
	private long stopTime;
	
	
	public abstract Object getSource();

    public abstract String toJson();

    public Type getType() {
        //Type é um enum que esta no mesmo pacote contêm duas constantes Comando , Consulta
        if (getOrigin().contains(Type.COMMAND.toString())) return Type.COMMAND;
        if (getOrigin().contains(Type.QUERY.toString()))   return Type.QUERY;
        return null;
    }

    public String getOrigin() {
        return getSource().getClass().getSimpleName();
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        stopTime = System.nanoTime();
    }

    public long getElapsedTimeInNano() {
        return stopTime - startTime;
    }

    public long getElapsedTimeInMilli() {
        return getElapsedTimeInNano() / 1_000_000L;
    }

    public boolean isSuccess() {
        return exception == null;
    }

    public boolean hasError() {
        return !isSuccess();
    }
}




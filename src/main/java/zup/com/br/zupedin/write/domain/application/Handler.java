package zup.com.br.zupedin.write.domain.application;

public interface Handler<T extends Command> {
	
	void handle(T command);

}

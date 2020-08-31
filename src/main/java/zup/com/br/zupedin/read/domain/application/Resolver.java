package zup.com.br.zupedin.read.domain.application;

public interface Resolver<T extends Query> {
	
	void resolve(T query);

}

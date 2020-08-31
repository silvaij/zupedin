package zup.com.br.zupedin.write.domain.exception;

public class BucketNotExistentException extends DomainException {

    public BucketNotExistentException(Error error) {
        super(error);
    }
}

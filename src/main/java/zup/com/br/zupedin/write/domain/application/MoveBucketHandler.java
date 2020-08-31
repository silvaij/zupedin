package zup.com.br.zupedin.write.domain.application;

import zup.com.br.zupedin.write.domain.core.WriteBucketRepository;
import zup.com.br.zupedin.write.domain.exception.BucketNotExistentException;
import org.springframework.stereotype.Service;

import static zup.com.br.zupedin.write.domain.exception.DomainException.Error.BUCKET_NOT_EXIST;

@Service
public class MoveBucketHandler implements Handler<MoveBucketCommand> {

    private final WriteBucketRepository repository;

    public MoveBucketHandler(WriteBucketRepository repository) {
        this.repository = repository;
    }

    public void handle(MoveBucketCommand command) {

        var optionalBucket = repository.findByExteranlId(command.getExteranlId());

        if (optionalBucket.isEmpty()) {
            throw new BucketNotExistentException(BUCKET_NOT_EXIST);
        }

        var bucket = optionalBucket.get();

        bucket.setPosition(command.getPosition());

        repository.update(bucket);
    }
}

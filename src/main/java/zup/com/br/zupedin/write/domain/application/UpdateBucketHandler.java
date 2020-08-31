package zup.com.br.zupedin.write.domain.application;

import zup.com.br.zupedin.write.domain.core.Bucket;
import zup.com.br.zupedin.write.domain.core.WriteBucketRepository;
import zup.com.br.zupedin.write.domain.exception.BucketNotExistentException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static zup.com.br.zupedin.write.domain.exception.DomainException.Error.BUCKET_NOT_EXIST;

@Service
public class UpdateBucketHandler implements Handler<UpdateBucketCommand> {

    private WriteBucketRepository repository;

    public UpdateBucketHandler(WriteBucketRepository repository) {
        this.repository = repository;
    }

    public void handle(UpdateBucketCommand command) {

        Optional<Bucket> bucketOptional = repository.findByExteranlId(command.getExternalId());

        if (!bucketOptional.isPresent()) {
            throw new BucketNotExistentException(BUCKET_NOT_EXIST);
        }

        var bucket = bucketOptional.get();

        bucket.setName(command.getName());

        repository.update(bucket);
    }
}


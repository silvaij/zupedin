package zup.com.br.zupedin.write.domain.application;

import zup.com.br.zupedin.write.domain.core.Bucket;
import zup.com.br.zupedin.write.domain.core.WriteBucketRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateBucketHandler implements Handler<CreateBucketCommand> {

    private final WriteBucketRepository repository;

    public CreateBucketHandler(WriteBucketRepository repository) {
        this.repository = repository;
    }

    public void handle(CreateBucketCommand command) {

        var bucket = new Bucket()
            .setExternalId(command.getExternalId())
            .setPosition(command.getPosition())
            .setName(command.getName());

        repository.create(bucket);
    }
}

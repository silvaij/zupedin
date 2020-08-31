package zup.com.br.zupedin.write.domain.application;

import zup.com.br.zupedin.write.domain.core.Bucket;
import zup.com.br.zupedin.write.domain.core.Card;
import zup.com.br.zupedin.write.domain.core.WriteBucketRepository;
import zup.com.br.zupedin.write.domain.core.WriteCardRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateCardHandler implements Handler<CreateCardCommand> {

    private WriteBucketRepository bucketRepository;
    private WriteCardRepository cardRepository;

    public CreateCardHandler(WriteBucketRepository bucketRepository, WriteCardRepository cardRepository) {
        this.bucketRepository = bucketRepository;
        this.cardRepository = cardRepository;
    }

    public void handle(CreateCardCommand command) {

        Optional<Bucket> bucketOptional = bucketRepository.findByExteranlId(command.getBucketExternalId());
        var bucket = bucketOptional.get();

        var card = new Card()
                .setBucketId(bucket.getId())
                .setExternalId(command.getExternalId())
                .setPosition(command.getPosition())
                .setName(command.getName());

        cardRepository.create(card);
    }
}

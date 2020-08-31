package zup.com.br.zupedin.read.domain.application;

import zup.com.br.zupedin.read.domain.core.BucketDto;
import zup.com.br.zupedin.read.domain.core.ReadBucketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllBucketResolver implements Resolver<ListAllBucketsQuery> {

    private ReadBucketRepository repository;

    public ListAllBucketResolver(ReadBucketRepository repository) {
        this.repository = repository;
    }

    public void resolve(ListAllBucketsQuery query) {

        List<BucketDto> result = repository.findAll();
        query.setResult(result);
    }
}

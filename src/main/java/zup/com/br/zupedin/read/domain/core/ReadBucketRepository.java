package zup.com.br.zupedin.read.domain.core;

import java.util.List;

public interface ReadBucketRepository {

    List<BucketDto> findAll();
}


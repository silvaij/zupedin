package zup.com.br.zupedin.read.domain.application;

import java.util.List;

import zup.com.br.zupedin.read.domain.core.BucketDto;

public class ListAllBucketsQuery implements Query {

    private List<BucketDto> result;

    public List<BucketDto> getResult() {
        return result;
    }

    public void setResult(List<BucketDto> result) {
        this.result = result;
    }
}
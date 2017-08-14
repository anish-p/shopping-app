package com.tw.shoppingapp.usecases;

public interface UseCase<T extends UseCaseRequest, R extends UseCaseResponse> {
    R execute(T useCaseRequest);
}
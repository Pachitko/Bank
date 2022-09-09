package ru.shibaev.bank.model.models;

import java.util.*;

public class Response<T> {

    public static <T> Response<T> Ok(T value) {
        return new Response<T>(value, new ArrayList<ResponseError>());
    }

    public static <T> Response<T> Fail(T value, List<ResponseError> errors) {
        return new Response<T>(value, errors);
    }

    public T value;

    public Boolean isSucceeded() {
        return _errors != null && _errors.size() == 0;
    }

    private final List<ResponseError> _errors;

    public List<ResponseError> getErrors() {
        return Collections.unmodifiableList(_errors);
    }

    public Response(T value, List<ResponseError> errors) {
        this.value = value;
        this._errors = errors;
    }

    @Override
    public String toString() {
        return isSucceeded() ? "Succeeded" : "Failed";
    }
}

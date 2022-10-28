package org.hewo.core.model.request;


public class ModelRequest<T> extends BaseRequest {

    protected T data;

    public ModelRequest() {
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
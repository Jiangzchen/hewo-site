package org.hewo.core.model.request;

import java.util.List;

public class ListRequest<T> extends BaseRequest {
    protected List<T> data;

    public ListRequest() {
    }

    public List<T> getData() {
        return this.data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
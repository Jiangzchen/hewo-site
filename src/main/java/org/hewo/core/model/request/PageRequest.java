package org.hewo.core.model.request;

public class PageRequest<T> extends ModelRequest<T> {

    private int page;

    private int pageSize;

    public PageRequest() {
    }

    public PageRequest(int page, int pageSize, T data) {
        this.setPage(page);
        this.setPageSize(pageSize);
        this.setData(data);
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
package ru.fafurin.orderservice.domen;

public enum Status {

    AWAIT("Ожидает"),
    IN_WORK("В работе"),
    COMPETED("Завершен"),
    ;

    private final String title;

    Status(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

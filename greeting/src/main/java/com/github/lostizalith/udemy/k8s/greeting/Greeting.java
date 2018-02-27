package com.github.lostizalith.udemy.k8s.greeting;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Greeting {

    private final Long id;
    private final String name;

    private Greeting(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public static Greeting ofGreeting(final Long id, final String name) {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("Greeting id is mandatory!");
        }

        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Greeting name is mandatory!");
        }

        return new Greeting(id, name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Greeting{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}

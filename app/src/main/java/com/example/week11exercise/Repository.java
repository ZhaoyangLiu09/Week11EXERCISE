package com.example.week11exercise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repository<T extends SoccerEntity> implements Serializable {
    private final List<T> data = new ArrayList<>();

    public void add(T entity) {
        if (entity == null) {
            throw new NullPointerException("Cannot add null entity.");
        }
        data.add(entity);
    }

    public void add(List<T> entities) {
        if (entities == null) {
            throw new NullPointerException("Cannot add null entities.");
        }
        data.addAll(entities);
    }

    public List<T> get() {
        // 返回副本，防止外部直接修改
        return new ArrayList<>(data);
    }

    public List<T> filter(Predicate<T> predicate) {
        return data.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<T> sort(Comparator<T> comparator) {
        return data.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
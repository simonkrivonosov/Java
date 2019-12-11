package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? super T> source, T element) {
        if(source == null)
            throw new NullPointerException();

        for (int i = 0; i < source.size(); i++) {
            if (source.get(i).equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public static <T> List<T> limit(List<T> source, int size) {
        if(source == null)
            throw new NullPointerException();
        if(size < 1) {
            throw new RuntimeException("size cant be less then 1");
        }
        List<T> newArray = CollectionUtils.newArrayList();
        for (int i = 0; i < size; i++) {
            newArray.add(source.get(i));
        }
        return newArray;
    }

    public static <T> void add(List<? super T> source, T element) {
        if(source == null)
            throw new NullPointerException();
        source.add(element);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        if(removeFrom == null)
            throw new NullPointerException();
        for (T elemToDelete : c2) {
            removeFrom.remove(elemToDelete);
        }
    }

    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        if(c1 == null || c2 == null )
            throw new NullPointerException();
        for (T elem : c2) {
            if (!c1.contains(elem)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        if(c1 == null || c2==null )
            throw new NullPointerException();
        for (T elem : c2) {
            if (c1.contains(elem)) {
                return true;
            }
        }
        return false;
    }

    public static <L, T extends Comparable<? super L>> List<L> range(List<L> list, T min, T max) {
        if(list == null )
            throw new NullPointerException();
        List<L> newArray = CollectionUtils.newArrayList();
        for (L element : list) {
            if (min.compareTo(element) <= 0 && max.compareTo(element) >= 0 ) {
                newArray.add(element);
            }
        }
        return newArray;
    }

    public static <L, T extends L> List<L> range(List<L> list, T min, T max, Comparator<? super L> comparator) {
        if(list == null )
            throw new NullPointerException();
        List<L> newArray = CollectionUtils.newArrayList();
        for (L element : list) {
            if (comparator.compare(min, element) <= 0 && comparator.compare(max, element) >= 0 ) {
                newArray.add(element);
            }
        }
        return newArray;
    }
}

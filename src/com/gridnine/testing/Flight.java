package com.gridnine.testing;

import java.beans.IntrospectionException;
import java.util.List;
import java.util.stream.Collectors;

public class Flight {

    private final Integer id;
    private final List<Segment> segments;

    public Integer getId(){
        return id;
    }

    List<Segment> getSegments(){
        return segments;
    }

    Flight(final List<Segment> segs, Integer id){
        segments = segs;
        this.id = id;
    }

    @Override
    public String toString(){
        return segments.stream().map(Object::toString).collect(Collectors.joining(" "));
    }
}


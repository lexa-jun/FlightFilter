package com.gridnine.testing;

import java.util.List;

public class Flight {

    private final Integer id;
    private final List<Segment> segments;

    Flight(final List<Segment> segs, Integer id){
        segments = segs;
        this.id = id;
    }
}


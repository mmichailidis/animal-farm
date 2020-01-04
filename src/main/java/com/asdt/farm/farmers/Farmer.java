package com.asdt.farm.farmers;

import com.asdt.farm.Feeder;

public interface Farmer extends Observer {
    Integer getRefills();
    void setFeeder(final Feeder feeder);
}

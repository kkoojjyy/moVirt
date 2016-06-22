package org.ovirt.mobile.movirt.rest.v3;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.ovirt.mobile.movirt.rest.RestEntityWrapperList;

import java.util.List;

public class DataCenters extends RestEntityWrapperList<DataCenter> {
    @JsonCreator
    public DataCenters(@JsonProperty("data_center") List<DataCenter> list) {
        super(list);
    }
}

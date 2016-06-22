package org.ovirt.mobile.movirt.rest.v4;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cluster extends org.ovirt.mobile.movirt.rest.Cluster {
    public DataCenter data_center;

    @Override
    public org.ovirt.mobile.movirt.model.Cluster toEntity() {
        org.ovirt.mobile.movirt.model.Cluster cluster = super.toEntity();
        if (data_center != null) {
            cluster.setDataCenterId(data_center.id);
        }

        return cluster;
    }
}

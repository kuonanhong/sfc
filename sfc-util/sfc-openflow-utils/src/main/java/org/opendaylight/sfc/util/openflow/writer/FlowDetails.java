/*
 * Copyright (c) 2016, 2017 Ericsson Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.sfc.util.openflow.writer;

import java.util.Objects;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.TableKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.Flow;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.FlowKey;

/**
 * Class used to store the details of a flow for easier creation / deletion
 * later.
 */
public class FlowDetails {

    private final String sffNodeName;
    private final FlowKey flowKey;
    private final TableKey tableKey;
    private final Flow flow;
    private final Long rspId;

    /**
     * This constructor is used for storing flows to be added.
     *
     * @param sffNodeName
     *            - which SFF to write the flow to
     * @param flowKey
     *            - the flow identifier
     * @param tableKey
     *            - the table identifier
     * @param flow
     *            - The flow to be written
     */
    public FlowDetails(final String sffNodeName, FlowKey flowKey, TableKey tableKey, Flow flow, Long theRspId) {
        this.sffNodeName = sffNodeName;
        this.flowKey = flowKey;
        this.tableKey = tableKey;
        this.flow = flow;
        rspId = theRspId;
    }

    /**
     * This constructor is used for storing flows to be deleted. Only the path
     * ids are needed
     *
     * @param sffNodeName
     *            - which SFF to write the flow to
     * @param flowKey
     *            - the flow identifier
     * @param tableKey
     *            - the table identifier
     */
    public FlowDetails(final String sffNodeName, FlowKey flowKey, TableKey tableKey, Long theRspId) {
        this(sffNodeName, flowKey, tableKey, null, theRspId);
    }

    public FlowDetails(final String sffNodeName, FlowKey flowKey, TableKey tableKey) {
        this(sffNodeName, flowKey, tableKey, null, null);
    }

    public final String getSffNodeName() {
        return sffNodeName;
    }

    public final FlowKey getFlowKey() {
        return flowKey;
    }

    public final TableKey getTableKey() {
        return tableKey;
    }

    public final Flow getFlow() {
        return flow;
    }

    public final long getRspId() {
        return rspId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sffNodeName, flowKey, tableKey, flow, rspId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        FlowDetails other = (FlowDetails) obj;
        return Objects.equals(rspId, other.rspId)
                && Objects.equals(tableKey, other.tableKey)
                && Objects.equals(sffNodeName, other.sffNodeName)
                && Objects.equals(flowKey, other.flowKey)
                && Objects.equals(flow, other.flow);
    }
}

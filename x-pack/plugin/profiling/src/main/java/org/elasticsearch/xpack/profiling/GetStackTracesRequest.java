/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0; you may not use this file except in compliance with the Elastic License
 * 2.0.
 */
package org.elasticsearch.xpack.profiling;

import org.elasticsearch.action.ActionRequest;
import org.elasticsearch.action.ActionRequestValidationException;
import org.elasticsearch.action.IndicesRequest;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.action.support.TransportAction;
import org.elasticsearch.common.ParsingException;
import org.elasticsearch.common.io.stream.StreamOutput;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.tasks.CancellableTask;
import org.elasticsearch.tasks.Task;
import org.elasticsearch.tasks.TaskId;
import org.elasticsearch.xcontent.ParseField;
import org.elasticsearch.xcontent.XContentParser;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static org.elasticsearch.action.ValidateActions.addValidationError;
import static org.elasticsearch.index.query.AbstractQueryBuilder.parseTopLevelQuery;

/**
 * A request to get profiling details
 */
public class GetStackTracesRequest extends ActionRequest implements IndicesRequest {
    public static final ParseField QUERY_FIELD = new ParseField("query");
    public static final ParseField SAMPLE_SIZE_FIELD = new ParseField("sample_size");
    public static final ParseField INDICES_FIELD = new ParseField("indices");
    public static final ParseField STACKTRACE_IDS_FIELD = new ParseField("stacktrace_ids");
    public static final ParseField REQUESTED_DURATION_FIELD = new ParseField("requested_duration");
    public static final ParseField AWS_COST_FACTOR_FIELD = new ParseField("aws_cost_factor");
    public static final ParseField CUSTOM_CO2_PER_KWH = new ParseField("co2_per_kwh");
    public static final ParseField CUSTOM_DATACENTER_PUE = new ParseField("datacenter_pue");
    public static final ParseField CUSTOM_PER_CORE_WATT_X86 = new ParseField("per_core_watt_x86");
    public static final ParseField CUSTOM_PER_CORE_WATT_ARM64 = new ParseField("per_core_watt_arm64");
    public static final ParseField CUSTOM_COST_PER_CORE_HOUR = new ParseField("cost_per_core_hour");
    private static final int DEFAULT_SAMPLE_SIZE = 20_000;

    private QueryBuilder query;
    private Integer sampleSize;
    private String indices;
    private String stackTraceIds;
    private Double requestedDuration;
    private Double awsCostFactor;
    private Double customCO2PerKWH;
    private Double customDatacenterPUE;
    private Double customPerCoreWattX86;
    private Double customPerCoreWattARM64;
    private Double customCostPerCoreHour;

    // We intentionally don't expose this field via the REST API, but we can control behavior within Elasticsearch.
    // Once we have migrated all client-side code to dedicated APIs (such as the flamegraph API), we can adjust
    // sample counts by default and remove this flag.
    private Boolean adjustSampleCount;

    public GetStackTracesRequest() {
        this(null, null, null, null, null, null, null, null, null, null, null);
    }

    public GetStackTracesRequest(
        Integer sampleSize,
        Double requestedDuration,
        Double awsCostFactor,
        QueryBuilder query,
        String indices,
        String stackTraceIds,
        Double customCO2PerKWH,
        Double customDatacenterPUE,
        Double customPerCoreWattX86,
        Double customPerCoreWattARM64,
        Double customCostPerCoreHour
    ) {
        this.sampleSize = sampleSize;
        this.requestedDuration = requestedDuration;
        this.awsCostFactor = awsCostFactor;
        this.query = query;
        this.indices = indices;
        this.stackTraceIds = stackTraceIds;
        this.customCO2PerKWH = customCO2PerKWH;
        this.customDatacenterPUE = customDatacenterPUE;
        this.customPerCoreWattX86 = customPerCoreWattX86;
        this.customPerCoreWattARM64 = customPerCoreWattARM64;
        this.customCostPerCoreHour = customCostPerCoreHour;
    }

    @Override
    public void writeTo(StreamOutput out) {
        TransportAction.localOnly();
    }

    public Integer getSampleSize() {
        return sampleSize != null ? sampleSize : DEFAULT_SAMPLE_SIZE;
    }

    public Double getRequestedDuration() {
        return requestedDuration;
    }

    public Double getAwsCostFactor() {
        return awsCostFactor;
    }

    public Double getCustomCO2PerKWH() {
        return customCO2PerKWH;
    }

    public Double getCustomDatacenterPUE() {
        return customDatacenterPUE;
    }

    public Double getCustomPerCoreWattX86() {
        return customPerCoreWattX86;
    }

    public Double getCustomPerCoreWattARM64() {
        return customPerCoreWattARM64;
    }

    public Double getCustomCostPerCoreHour() {
        return customCostPerCoreHour;
    }

    public QueryBuilder getQuery() {
        return query;
    }

    public String getIndices() {
        return indices;
    }

    public String getStackTraceIds() {
        return stackTraceIds;
    }

    public boolean isAdjustSampleCount() {
        return Boolean.TRUE.equals(adjustSampleCount);
    }

    public void setAdjustSampleCount(Boolean adjustSampleCount) {
        this.adjustSampleCount = adjustSampleCount;
    }

    public void parseXContent(XContentParser parser) throws IOException {
        XContentParser.Token token = parser.currentToken();
        String currentFieldName = null;
        if (token != XContentParser.Token.START_OBJECT && (token = parser.nextToken()) != XContentParser.Token.START_OBJECT) {
            throw new ParsingException(
                parser.getTokenLocation(),
                "Expected [" + XContentParser.Token.START_OBJECT + "] but found [" + token + "]",
                parser.getTokenLocation()
            );
        }

        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            if (token == XContentParser.Token.FIELD_NAME) {
                currentFieldName = parser.currentName();
            } else if (token.isValue()) {
                if (SAMPLE_SIZE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    this.sampleSize = parser.intValue();
                } else if (INDICES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    this.indices = parser.text();
                } else if (STACKTRACE_IDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    this.stackTraceIds = parser.text();
                } else if (REQUESTED_DURATION_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    this.requestedDuration = parser.doubleValue();
                } else if (AWS_COST_FACTOR_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    this.awsCostFactor = parser.doubleValue();
                } else if (CUSTOM_CO2_PER_KWH.match(currentFieldName, parser.getDeprecationHandler())) {
                    this.customCO2PerKWH = parser.doubleValue();
                } else if (CUSTOM_DATACENTER_PUE.match(currentFieldName, parser.getDeprecationHandler())) {
                    this.customDatacenterPUE = parser.doubleValue();
                } else if (CUSTOM_PER_CORE_WATT_X86.match(currentFieldName, parser.getDeprecationHandler())) {
                    this.customPerCoreWattX86 = parser.doubleValue();
                } else if (CUSTOM_PER_CORE_WATT_ARM64.match(currentFieldName, parser.getDeprecationHandler())) {
                    this.customPerCoreWattARM64 = parser.doubleValue();
                } else if (CUSTOM_COST_PER_CORE_HOUR.match(currentFieldName, parser.getDeprecationHandler())) {
                    this.customCostPerCoreHour = parser.doubleValue();
                } else {
                    throw new ParsingException(
                        parser.getTokenLocation(),
                        "Unknown key for a " + token + " in [" + currentFieldName + "].",
                        parser.getTokenLocation()
                    );
                }
            } else if (token == XContentParser.Token.START_OBJECT) {
                if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    this.query = parseTopLevelQuery(parser);
                }
            } else {
                throw new ParsingException(
                    parser.getTokenLocation(),
                    "Unknown key for a " + token + " in [" + currentFieldName + "].",
                    parser.getTokenLocation()
                );
            }
        }

        token = parser.nextToken();
        if (token != null) {
            throw new ParsingException(parser.getTokenLocation(), "Unexpected token [" + token + "] found after the main object.");
        }
    }

    @Override
    public ActionRequestValidationException validate() {
        ActionRequestValidationException validationException = null;
        if (indices != null) {
            if (stackTraceIds == null || stackTraceIds.isEmpty()) {
                validationException = addValidationError(
                    "[" + STACKTRACE_IDS_FIELD.getPreferredName() + "] is mandatory",
                    validationException
                );
            }
        } else {
            if (stackTraceIds != null) {
                validationException = addValidationError(
                    "[" + STACKTRACE_IDS_FIELD.getPreferredName() + "] must not be set",
                    validationException
                );
            }
        }
        validationException = requirePositive(SAMPLE_SIZE_FIELD, sampleSize, validationException);
        validationException = requirePositive(REQUESTED_DURATION_FIELD, requestedDuration, validationException);
        validationException = requirePositive(AWS_COST_FACTOR_FIELD, awsCostFactor, validationException);
        validationException = requirePositive(CUSTOM_CO2_PER_KWH, customCO2PerKWH, validationException);
        validationException = requirePositive(CUSTOM_DATACENTER_PUE, customDatacenterPUE, validationException);
        validationException = requirePositive(CUSTOM_PER_CORE_WATT_X86, customPerCoreWattX86, validationException);
        validationException = requirePositive(CUSTOM_PER_CORE_WATT_ARM64, customPerCoreWattARM64, validationException);
        validationException = requirePositive(CUSTOM_COST_PER_CORE_HOUR, customCostPerCoreHour, validationException);
        return validationException;
    }

    private static ActionRequestValidationException requirePositive(ParseField field, Number value, ActionRequestValidationException e) {
        if (value != null) {
            if (value.doubleValue() <= 0.0d) {
                return addValidationError("[" + field.getPreferredName() + "] must be greater than 0, got: " + value, e);
            }
        }
        return e;
    }

    @Override
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
        return new CancellableTask(id, type, action, null, parentTaskId, headers) {
            @Override
            public String getDescription() {
                // generating description lazily since the query could be large
                StringBuilder sb = new StringBuilder();
                appendField(sb, "indices", indices);
                appendField(sb, "stacktrace_ids", stackTraceIds);
                appendField(sb, "sample_size", sampleSize);
                appendField(sb, "requested_duration", requestedDuration);
                appendField(sb, "aws_cost_factor", awsCostFactor);
                appendField(sb, "co2_per_kwh", customCO2PerKWH);
                appendField(sb, "datacenter_pue", customDatacenterPUE);
                appendField(sb, "per_core_watt_x86", customPerCoreWattX86);
                appendField(sb, "per_core_watt_arm64", customPerCoreWattARM64);
                appendField(sb, "cost_per_core_hour", customCostPerCoreHour);
                appendField(sb, "query", query);
                return sb.toString();
            }
        };
    }

    private static void appendField(StringBuilder sb, String name, Object value) {
        if (sb.isEmpty() == false) {
            sb.append(", ");
        }
        if (value == null) {
            sb.append(name).append("[]");
        } else {
            sb.append(name).append("[").append(value).append("]");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetStackTracesRequest that = (GetStackTracesRequest) o;
        return Objects.equals(query, that.query)
            && Objects.equals(sampleSize, that.sampleSize)
            && Objects.equals(indices, that.indices)
            && Objects.equals(stackTraceIds, that.stackTraceIds);
    }

    @Override
    public int hashCode() {
        // The object representation of `query` may use Lucene's ByteRef to represent values. This class' hashCode implementation
        // uses StringUtils.GOOD_FAST_HASH_SEED which is reinitialized for each JVM. This means that hashcode is consistent *within*
        // a JVM but will not be consistent across the cluster. As we use hashCode e.g. to initialize the random number generator in
        // Resampler to produce a consistent downsampling results, relying on the default hashCode implementation of `query` will
        // produce consistent results per node but not across the cluster. To avoid this, we produce the hashCode based on the
        // string representation instead, which will produce consistent results for the entire cluster and across node restarts.
        return Objects.hash(Objects.toString(query, "null"), sampleSize, indices, stackTraceIds);
    }

    @Override
    public String[] indices() {
        Set<String> indices = new HashSet<>();
        indices.add("profiling-stacktraces");
        indices.add("profiling-stackframes");
        indices.add("profiling-executables");
        if (this.indices == null) {
            indices.addAll(EventsIndex.indexNames());
        } else {
            indices.add(this.indices);
        }
        return indices.toArray(new String[0]);
    }

    @Override
    public IndicesOptions indicesOptions() {
        return IndicesOptions.STRICT_EXPAND_OPEN;
    }

    @Override
    public boolean includeDataStreams() {
        return true;
    }
}

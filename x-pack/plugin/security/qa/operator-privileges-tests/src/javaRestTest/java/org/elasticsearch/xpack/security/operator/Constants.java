/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0; you may not use this file except in compliance with the Elastic License
 * 2.0.
 */

package org.elasticsearch.xpack.security.operator;

import java.util.Set;

public class Constants {

    public static final Set<String> NON_OPERATOR_ACTIONS = Set.of(
        // "cluster:admin/autoscaling/delete_autoscaling_policy",
        "cluster:admin/autoscaling/get_autoscaling_capacity",
        "cluster:admin/autoscaling/get_autoscaling_policy",
        // "cluster:admin/autoscaling/put_autoscaling_policy",
        "cluster:admin/component_template/delete",
        "cluster:admin/component_template/get",
        "cluster:admin/component_template/put",
        "cluster:admin/deprecation/cache/reset",
        // Desired nodes APIs
        "cluster:admin/desired_nodes/get",
        "cluster:admin/desired_nodes/update",
        "cluster:admin/desired_nodes/delete",
        "cluster:admin/ilm/_move/post",
        "cluster:admin/ilm/delete",
        "cluster:admin/ilm/get",
        "cluster:admin/ilm/operation_mode/get",
        "cluster:admin/ilm/put",
        "cluster:admin/ilm/start",
        "cluster:admin/ilm/stop",
        "cluster:admin/indices/dangling/delete",
        "cluster:admin/indices/dangling/find",
        "cluster:admin/indices/dangling/import",
        "cluster:admin/indices/dangling/list",
        "cluster:admin/ingest/pipeline/delete",
        "cluster:admin/ingest/pipeline/get",
        "cluster:admin/ingest/pipeline/put",
        "cluster:admin/ingest/pipeline/simulate",
        "cluster:admin/ingest/processor/grok/get",
        "cluster:admin/logstash/pipeline/delete",
        "cluster:admin/logstash/pipeline/get",
        "cluster:admin/logstash/pipeline/put",
        "cluster:admin/migrate_to_data_tiers",
        "cluster:admin/migration/get_system_feature",
        "cluster:admin/migration/post_system_feature",
        "cluster:admin/nodes/reload_secure_settings",
        "cluster:admin/persistent/completion",
        "cluster:admin/persistent/remove",
        "cluster:admin/persistent/start",
        "cluster:admin/persistent/update_status",
        "cluster:admin/reindex/rethrottle",
        "cluster:admin/repository/_cleanup",
        "cluster:admin/repository/delete",
        "cluster:admin/repository/get",
        "cluster:admin/repository/put",
        "cluster:admin/repository/verify",
        "cluster:admin/reroute",
        "cluster:admin/script/delete",
        "cluster:admin/script/get",
        "cluster:admin/script/put",
        "cluster:admin/script_context/get",
        "cluster:admin/script_language/get",
        "cluster:admin/scripts/painless/context",
        "cluster:admin/scripts/painless/execute",
        "cluster:admin/settings/update",
        "cluster:admin/slm/delete",
        "cluster:admin/slm/execute",
        "cluster:admin/slm/execute-retention",
        "cluster:admin/slm/get",
        "cluster:admin/slm/put",
        "cluster:admin/slm/start",
        "cluster:admin/slm/stats",
        "cluster:admin/slm/status",
        "cluster:admin/slm/stop",
        "cluster:admin/snapshot/clone",
        "cluster:admin/snapshot/create",
        "cluster:admin/snapshot/delete",
        "cluster:admin/snapshot/get",
        "cluster:admin/snapshot/mount",
        "cluster:admin/snapshot/restore",
        "cluster:admin/snapshot/status",
        "cluster:admin/snapshot/status[nodes]",
        "cluster:admin/features/get",
        "cluster:admin/features/reset",
        "cluster:admin/tasks/cancel",
        "cluster:admin/transform/delete",
        "cluster:admin/transform/preview",
        "cluster:admin/transform/put",
        "cluster:admin/transform/reset",
        "cluster:admin/transform/start",
        "cluster:admin/transform/stop",
        "cluster:admin/transform/update",
        "cluster:admin/transform/upgrade",
        "cluster:admin/transform/validate",
        // "cluster:admin/voting_config/add_exclusions",
        // "cluster:admin/voting_config/clear_exclusions",
        "cluster:admin/xpack/ccr/auto_follow_pattern/activate",
        "cluster:admin/xpack/ccr/auto_follow_pattern/delete",
        "cluster:admin/xpack/ccr/auto_follow_pattern/get",
        "cluster:admin/xpack/ccr/auto_follow_pattern/put",
        "cluster:admin/xpack/ccr/pause_follow",
        "cluster:admin/xpack/ccr/resume_follow",
        "cluster:admin/xpack/deprecation/info",
        "cluster:admin/xpack/deprecation/nodes/info",
        "cluster:admin/xpack/enrich/delete",
        "cluster:admin/xpack/enrich/execute",
        "cluster:admin/xpack/enrich/internal_execute",
        "cluster:admin/xpack/enrich/get",
        "cluster:admin/xpack/enrich/put",
        "cluster:admin/xpack/enrich/reindex",
        "cluster:admin/xpack/license/basic_status",
        // "cluster:admin/xpack/license/delete",
        "cluster:admin/xpack/license/feature_usage",
        // "cluster:admin/xpack/license/put",
        "cluster:admin/xpack/license/start_basic",
        "cluster:admin/xpack/license/start_trial",
        "cluster:admin/xpack/license/trial_status",
        "cluster:admin/xpack/ml/calendars/delete",
        "cluster:admin/xpack/ml/calendars/events/delete",
        "cluster:admin/xpack/ml/calendars/events/post",
        "cluster:admin/xpack/ml/calendars/jobs/update",
        "cluster:admin/xpack/ml/calendars/put",
        "cluster:admin/xpack/ml/data_frame/analytics/delete",
        "cluster:admin/xpack/ml/data_frame/analytics/explain",
        "cluster:admin/xpack/ml/data_frame/analytics/put",
        "cluster:admin/xpack/ml/data_frame/analytics/preview",
        "cluster:admin/xpack/ml/data_frame/analytics/start",
        "cluster:admin/xpack/ml/data_frame/analytics/stop",
        "cluster:admin/xpack/ml/data_frame/analytics/update",
        "cluster:admin/xpack/ml/datafeed/start",
        "cluster:admin/xpack/ml/datafeed/stop",
        "cluster:admin/xpack/ml/datafeeds/delete",
        "cluster:admin/xpack/ml/datafeeds/preview",
        "cluster:admin/xpack/ml/datafeeds/put",
        "cluster:admin/xpack/ml/datafeeds/update",
        "cluster:admin/xpack/ml/delete_expired_data",
        "cluster:admin/xpack/ml/filters/delete",
        "cluster:admin/xpack/ml/filters/get",
        "cluster:admin/xpack/ml/filters/put",
        "cluster:admin/xpack/ml/filters/update",
        "cluster:admin/xpack/ml/inference/delete",
        "cluster:admin/xpack/ml/inference/put",
        "cluster:admin/xpack/ml/inference/model_aliases/put",
        "cluster:admin/xpack/ml/inference/model_aliases/delete",
        "cluster:admin/xpack/ml/job/close",
        "cluster:admin/xpack/ml/job/data/post",
        "cluster:admin/xpack/ml/job/delete",
        "cluster:admin/xpack/ml/job/estimate_model_memory",
        "cluster:admin/xpack/ml/job/flush",
        "cluster:admin/xpack/ml/job/forecast",
        "cluster:admin/xpack/ml/job/forecast/delete",
        "cluster:admin/xpack/ml/job/model_snapshots/delete",
        "cluster:admin/xpack/ml/job/model_snapshots/revert",
        "cluster:admin/xpack/ml/job/model_snapshots/update",
        "cluster:admin/xpack/ml/job/model_snapshots/upgrade",
        "cluster:admin/xpack/ml/job/model_snapshots/upgrade/cancel",
        "cluster:admin/xpack/ml/job/open",
        "cluster:admin/xpack/ml/job/persist",
        "cluster:admin/xpack/ml/job/put",
        "cluster:admin/xpack/ml/job/reset",
        "cluster:admin/xpack/ml/job/update",
        "cluster:admin/xpack/ml/job/validate",
        "cluster:admin/xpack/ml/job/validate/detector",
        "cluster:admin/xpack/ml/trained_models/deployment/start",
        "cluster:admin/xpack/ml/trained_models/deployment/stop",
        "cluster:admin/xpack/ml/trained_models/part/put",
        "cluster:admin/xpack/ml/trained_models/vocabulary/put",
        "cluster:admin/xpack/ml/upgrade_mode",
        "cluster:admin/xpack/monitoring/bulk",
        "cluster:admin/xpack/monitoring/migrate/alerts",
        "cluster:admin/xpack/rollup/delete",
        "cluster:admin/xpack/rollup/put",
        "cluster:admin/xpack/rollup/start",
        "cluster:admin/xpack/rollup/stop",
        "cluster:admin/xpack/searchable_snapshots/cache/clear",
        "cluster:admin/xpack/searchable_snapshots/cache/stats",
        "cluster:admin/xpack/security/api_key/create",
        "cluster:admin/xpack/security/api_key/get",
        "cluster:admin/xpack/security/api_key/grant",
        "cluster:admin/xpack/security/api_key/invalidate",
        "cluster:admin/xpack/security/api_key/query",
        "cluster:admin/xpack/security/cache/clear",
        "cluster:admin/xpack/security/delegate_pki",
        "cluster:admin/xpack/security/enroll/node",
        "cluster:admin/xpack/security/enroll/kibana",
        "cluster:admin/xpack/security/oidc/authenticate",
        "cluster:admin/xpack/security/oidc/logout",
        "cluster:admin/xpack/security/oidc/prepare",
        "cluster:admin/xpack/security/privilege/builtin/get",
        "cluster:admin/xpack/security/privilege/cache/clear",
        "cluster:admin/xpack/security/privilege/delete",
        "cluster:admin/xpack/security/privilege/get",
        "cluster:admin/xpack/security/privilege/put",
        "cluster:admin/xpack/security/profile/activate",
        "cluster:admin/xpack/security/profile/get",
        "cluster:admin/xpack/security/profile/put/data",
        "cluster:admin/xpack/security/profile/suggest",
        "cluster:admin/xpack/security/profile/set_enabled",
        "cluster:admin/xpack/security/realm/cache/clear",
        "cluster:admin/xpack/security/role/delete",
        "cluster:admin/xpack/security/role/get",
        "cluster:admin/xpack/security/role/put",
        "cluster:admin/xpack/security/role_mapping/delete",
        "cluster:admin/xpack/security/role_mapping/get",
        "cluster:admin/xpack/security/role_mapping/put",
        "cluster:admin/xpack/security/roles/cache/clear",
        "cluster:admin/xpack/security/saml/authenticate",
        "cluster:admin/xpack/security/saml/complete_logout",
        "cluster:admin/xpack/security/saml/invalidate",
        "cluster:admin/xpack/security/saml/logout",
        "cluster:admin/xpack/security/saml/prepare",
        "cluster:admin/xpack/security/service_account/get",
        "cluster:admin/xpack/security/service_account/credential/get",
        "cluster:admin/xpack/security/service_account/credential/get[n]",
        "cluster:admin/xpack/security/service_account/token/create",
        "cluster:admin/xpack/security/service_account/token/delete",
        "cluster:admin/xpack/security/token/create",
        "cluster:admin/xpack/security/token/invalidate",
        "cluster:admin/xpack/security/token/refresh",
        "cluster:admin/xpack/security/user/authenticate",
        "cluster:admin/xpack/security/user/change_password",
        "cluster:admin/xpack/security/user/delete",
        "cluster:admin/xpack/security/user/get",
        "cluster:admin/xpack/security/user/has_privileges",
        "cluster:admin/xpack/security/user/list_privileges",
        "cluster:admin/xpack/security/user/put",
        "cluster:admin/xpack/security/user/set_enabled",
        "cluster:admin/xpack/watcher/service",
        "cluster:admin/xpack/watcher/watch/ack",
        "cluster:admin/xpack/watcher/watch/activate",
        "cluster:admin/xpack/watcher/watch/delete",
        "cluster:admin/xpack/watcher/watch/execute",
        "cluster:admin/xpack/watcher/watch/put",
        "cluster:internal/xpack/ml/datafeed/isolate",
        "cluster:internal/xpack/ml/datafeed/running_state",
        "cluster:internal/xpack/ml/inference/infer",
        "cluster:internal/xpack/ml/job/finalize_job_execution",
        "cluster:internal/xpack/ml/job/kill/process",
        "cluster:internal/xpack/ml/job/update/process",
        "cluster:internal/xpack/ml/model_allocation/create",
        "cluster:internal/xpack/ml/model_allocation/delete",
        "cluster:internal/xpack/ml/model_allocation/update",
        "cluster:internal/xpack/ml/reset_mode",
        "cluster:internal/xpack/ml/trained_models/cache/info",
        "cluster:internal/xpack/ml/trained_models/deployments/stats/get",
        "cluster:internal/xpack/transform/reset_mode",
        "cluster:monitor/allocation/explain",
        "cluster:monitor/async_search/status",
        "cluster:monitor/ccr/follow_info",
        "cluster:monitor/ccr/follow_stats",
        "cluster:monitor/ccr/stats",
        "cluster:monitor/eql/async/status",
        "cluster:monitor/health",
        "cluster:monitor/health_api",
        "cluster:monitor/ingest/geoip/stats",
        "cluster:monitor/main",
        "cluster:monitor/nodes/hot_threads",
        "cluster:monitor/nodes/info",
        "cluster:monitor/nodes/stats",
        "cluster:monitor/nodes/usage",
        "cluster:monitor/remote/info",
        "cluster:monitor/state",
        "cluster:monitor/stats",
        "cluster:monitor/task",
        "cluster:monitor/task/get",
        "cluster:monitor/tasks/lists",
        "cluster:monitor/text_structure/findstructure",
        "cluster:monitor/transform/get",
        "cluster:monitor/transform/stats/get",
        "cluster:monitor/xpack/analytics/stats",
        "cluster:monitor/xpack/enrich/coordinator_stats",
        "cluster:monitor/xpack/enrich/stats",
        "cluster:monitor/xpack/eql/stats/dist",
        "cluster:monitor/xpack/info",
        "cluster:monitor/xpack/info/aggregate_metric",
        "cluster:monitor/xpack/info/analytics",
        "cluster:monitor/xpack/info/archive",
        "cluster:monitor/xpack/info/ccr",
        "cluster:monitor/xpack/info/data_streams",
        "cluster:monitor/xpack/info/data_tiers",
        "cluster:monitor/xpack/info/enrich",
        "cluster:monitor/xpack/info/eql",
        "cluster:monitor/xpack/info/frozen_indices",
        "cluster:monitor/xpack/info/graph",
        "cluster:monitor/xpack/info/ilm",
        "cluster:monitor/xpack/info/logstash",
        "cluster:monitor/xpack/info/ml",
        "cluster:monitor/xpack/info/monitoring",
        "cluster:monitor/xpack/info/rollup",
        "cluster:monitor/xpack/info/searchable_snapshots",
        "cluster:monitor/xpack/info/security",
        "cluster:monitor/xpack/info/slm",
        "cluster:monitor/xpack/info/spatial",
        "cluster:monitor/xpack/info/sql",
        "cluster:monitor/xpack/info/transform",
        "cluster:monitor/xpack/info/voting_only",
        "cluster:monitor/xpack/info/watcher",
        "cluster:monitor/xpack/license/get",
        "cluster:monitor/xpack/ml/calendars/events/get",
        "cluster:monitor/xpack/ml/calendars/get",
        "cluster:monitor/xpack/ml/data_frame/analytics/get",
        "cluster:monitor/xpack/ml/data_frame/analytics/stats/get",
        "cluster:monitor/xpack/ml/data_frame/evaluate",
        "cluster:monitor/xpack/ml/datafeeds/get",
        "cluster:monitor/xpack/ml/datafeeds/stats/get",
        "cluster:monitor/xpack/ml/inference/get",
        "cluster:monitor/xpack/ml/inference/stats/get",
        "cluster:monitor/xpack/ml/info/get",
        "cluster:monitor/xpack/ml/job/get",
        "cluster:monitor/xpack/ml/job/model_snapshots/get",
        "cluster:monitor/xpack/ml/job/model_snapshots/upgrade/stats/get",
        "cluster:monitor/xpack/ml/job/results/buckets/get",
        "cluster:monitor/xpack/ml/job/results/categories/get",
        "cluster:monitor/xpack/ml/job/results/influencers/get",
        "cluster:monitor/xpack/ml/job/results/overall_buckets/get",
        "cluster:monitor/xpack/ml/job/results/records/get",
        "cluster:monitor/xpack/ml/job/stats/get",
        "cluster:monitor/xpack/ml/memory/stats/get",
        "cluster:monitor/xpack/ml/trained_models/deployment/infer",
        "cluster:monitor/xpack/repositories_metering/clear_metering_archive",
        "cluster:monitor/xpack/repositories_metering/get_metrics",
        "cluster:monitor/xpack/rollup/get",
        "cluster:monitor/xpack/rollup/get/caps",
        "cluster:monitor/xpack/searchable_snapshots/stats",
        "cluster:monitor/xpack/security/saml/metadata",
        "cluster:monitor/xpack/spatial/stats",
        "cluster:monitor/xpack/sql/async/status", // org.elasticsearch.xpack.core.sql.SqlAsyncActionNames.SQL_ASYNC_GET_STATUS_ACTION_NAME
        "cluster:monitor/xpack/sql/stats/dist",
        "cluster:monitor/xpack/ssl/certificates/get",
        "cluster:monitor/xpack/usage",
        "cluster:monitor/xpack/usage/aggregate_metric",
        "cluster:monitor/xpack/usage/analytics",
        "cluster:monitor/xpack/usage/archive",
        "cluster:monitor/xpack/usage/ccr",
        "cluster:monitor/xpack/usage/data_streams",
        "cluster:monitor/xpack/usage/data_tiers",
        "cluster:monitor/xpack/usage/enrich",
        "cluster:monitor/xpack/usage/eql",
        "cluster:monitor/xpack/usage/frozen_indices",
        "cluster:monitor/xpack/usage/graph",
        "cluster:monitor/xpack/usage/ilm",
        "cluster:monitor/xpack/usage/logstash",
        "cluster:monitor/xpack/usage/ml",
        "cluster:monitor/xpack/usage/monitoring",
        "cluster:monitor/xpack/usage/rollup",
        "cluster:monitor/xpack/usage/searchable_snapshots",
        "cluster:monitor/xpack/usage/security",
        "cluster:monitor/xpack/usage/slm",
        "cluster:monitor/xpack/usage/spatial",
        "cluster:monitor/xpack/usage/sql",
        "cluster:monitor/xpack/usage/transform",
        "cluster:monitor/xpack/usage/voting_only",
        "cluster:monitor/xpack/usage/watcher",
        "cluster:monitor/xpack/watcher/stats/dist",
        "cluster:monitor/xpack/watcher/watch/get",
        "cluster:monitor/xpack/watcher/watch/query",
        "indices:admin/aliases",
        "indices:admin/aliases/get",
        "indices:admin/analyze",
        "indices:admin/auto_create",
        "indices:admin/block/add",
        "indices:admin/block/add[s]",
        "indices:admin/cache/clear",
        "indices:admin/close",
        "indices:admin/close[s]",
        "indices:admin/create",
        "indices:admin/data_stream/create",
        "indices:admin/data_stream/delete",
        "indices:admin/data_stream/get",
        "indices:admin/data_stream/migrate",
        "indices:admin/data_stream/modify",
        "indices:admin/data_stream/promote",
        "indices:admin/delete",
        "indices:admin/flush",
        "indices:admin/flush[s]",
        "indices:admin/forcemerge",
        "indices:admin/freeze",
        "indices:admin/get",
        "indices:admin/analyze_disk_usage",
        "indices:admin/ilm/explain",
        "indices:admin/ilm/remove_policy",
        "indices:admin/ilm/retry",
        "indices:admin/index_template/delete",
        "indices:admin/index_template/get",
        "indices:admin/index_template/put",
        "indices:admin/index_template/simulate",
        "indices:admin/index_template/simulate_index",
        "indices:admin/mapping/auto_put",
        "indices:admin/mapping/put",
        "indices:admin/mappings/fields/get",
        "indices:admin/mappings/fields/get[index]",
        "indices:admin/mappings/get",
        "indices:admin/open",
        "indices:admin/refresh",
        "indices:admin/refresh[s]",
        "indices:admin/reload_analyzers",
        "indices:admin/resize",
        "indices:admin/resolve/index",
        "indices:admin/rollover",
        "indices:admin/seq_no/add_retention_lease",
        "indices:admin/seq_no/global_checkpoint_sync",
        "indices:admin/seq_no/remove_retention_lease",
        "indices:admin/seq_no/renew_retention_lease",
        "indices:admin/settings/update",
        "indices:admin/shards/search_shards",
        "indices:admin/template/delete",
        "indices:admin/template/get",
        "indices:admin/template/put",
        "indices:admin/validate/query",
        "indices:admin/xpack/ccr/forget_follower",
        "indices:admin/xpack/ccr/put_follow",
        "indices:admin/xpack/ccr/unfollow",
        "indices:admin/xpack/rollup",
        "indices:admin/xpack/rollup_indexer",
        "indices:data/read/async_search/delete",
        "indices:data/read/async_search/get",
        "indices:data/read/async_search/submit",
        "indices:data/read/close_point_in_time",
        "indices:data/read/eql",
        "indices:data/read/eql/async/get",
        "indices:data/read/explain",
        "indices:data/read/field_caps",
        "indices:data/read/get",
        "indices:data/read/mget",
        "indices:data/read/mget[shard]",
        "indices:data/read/msearch",
        "indices:data/read/msearch/template",
        "indices:data/read/mtv",
        "indices:data/read/mtv[shard]",
        "indices:data/read/open_point_in_time",
        "indices:data/read/rank_eval",
        "indices:data/read/scroll",
        "indices:data/read/scroll/clear",
        "indices:data/read/search",
        "indices:data/read/search/template",
        "indices:data/read/shard_multi_search",
        "indices:data/read/sql",
        "indices:data/read/sql/close_cursor",
        "indices:data/read/sql/translate",
        "indices:data/read/sql/async/get", // org.elasticsearch.xpack.core.sql.SqlAsyncActionNames.SQL_ASYNC_GET_RESULT_ACTION_NAME
        "indices:data/read/tv",
        "indices:data/read/xpack/ccr/shard_changes",
        "indices:data/read/xpack/enrich/coordinate_lookups",
        "indices:data/read/xpack/graph/explore",
        "indices:data/read/xpack/rollup/get/index/caps",
        "indices:data/read/xpack/rollup/search",
        "indices:data/read/xpack/termsenum/list",
        "indices:data/write/bulk",
        "indices:data/write/bulk[s]",
        "indices:data/write/bulk_shard_operations[s]",
        "indices:data/write/delete",
        "indices:data/write/delete/byquery",
        "indices:data/write/index",
        "indices:data/write/reindex",
        "indices:data/write/update",
        "indices:data/write/update/byquery",
        "indices:monitor/data_stream/stats",
        "indices:monitor/field_usage_stats",
        "indices:monitor/fleet/global_checkpoints[s]",
        "indices:monitor/fleet/global_checkpoints",
        "indices:monitor/recovery",
        "indices:monitor/segments",
        "indices:monitor/settings/get",
        "indices:monitor/shard_stores",
        "indices:monitor/stats",
        "indices:monitor/transform/checkpoint",
        "indices:monitor/transform/checkpoint[n]",
        "internal:admin/ccr/internal_repository/delete",
        "internal:admin/ccr/internal_repository/put",
        "internal:admin/ccr/restore/file_chunk/get",
        "internal:admin/ccr/restore/session/clear",
        "internal:admin/ccr/restore/session/put",
        "internal:admin/snapshot/get_shard",
        "internal:admin/xpack/searchable_snapshots/cache/store",
        "internal:admin/xpack/searchable_snapshots/frozen_cache_info",
        "internal:admin/xpack/searchable_snapshots/frozen_cache_info[n]",
        "internal:cluster/nodes/indices/shard/store",
        "internal:gateway/local/started_shards"
    );
}

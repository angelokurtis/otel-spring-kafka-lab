locals {
  opentelemetry_collector = {
    mode      = "deployment"
    config    = yamldecode(file("${path.root}/opentelemetry-collector.yaml"))
    extraEnvs = [
      {
        name  = "JAEGER_OTLP_ENDPOINT",
        value = "jaeger-collector.${kubernetes_namespace_v1.jaeger.metadata[0].name}.svc.cluster.local:4317"
      },
      {
        name  = "PROMETHEUS_PUSHGATEWAY_ENDPOINT",
        value = "prometheus-server.${kubernetes_namespace_v1.prometheus.metadata[0].name}.svc.cluster.local:80"
      },
    ]
  }
}

resource "kubernetes_ingress_v1" "opentelemetry_collector" {
  metadata {
    name        = "opentelemetry-collector"
    namespace   = kubernetes_namespace_v1.opentelemetry.metadata[0].name
    labels      = { app = "opentelemetry-collector" }
    annotations = { "haproxy-ingress.github.io/backend-protocol" = "grpc" }
  }
  spec {
    ingress_class_name = "haproxy"
    rule {
      host = "otel.lvh.me"
      http {
        path {
          path      = "/"
          path_type = "Prefix"

          backend {
            service {
              name = "default-opentelemetry-collector"
              port {
                number = 4317
              }
            }
          }
        }
      }
    }
  }
}


resource "kubernetes_namespace_v1" "opentelemetry" {
  metadata { name = "otel" }
}

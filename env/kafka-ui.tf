locals {
  kafka_ui = {
    service = { port = 9090 }
    envs    = {
      config = {
        KAFKA_CLUSTERS_0_NAME             = "single"
        KAFKA_CLUSTERS_0_BOOTSTRAPSERVERS = "single-kafka-bootstrap.${kubernetes_namespace_v1.kafka.metadata[0].name}.svc:9092"
      }
    }
  }
}

resource "kubernetes_namespace_v1" "kafka_ui" {
  metadata { name = "kafka-ui" }
}

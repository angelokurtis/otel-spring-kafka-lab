locals {
  kafka_ui = {
  }
}

resource "kubernetes_namespace_v1" "kafka_ui" {
  metadata { name = "kafka-ui" }
}

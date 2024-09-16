# Grafana Alertmanager Tutorial

## 1. Grundidee

``` text
Metrik in Prometheus
        ↓
Grafana Alert Rule
        ↓
Grafana Alertmanager
        ↓
Notification Policy
        ↓
Contact Point (Email, Slack, Webhook)
```

Der eingebaute Grafana Alertmanager gruppiert, dedupliziert und routet
Alerts.

## 2. Contact Point erstellen

Pfad:

``` text
Alerts & IRM → Alerting → Notification configuration → Contact points
```

1.  **New contact point**
2.  Namen vergeben (z. B. `email-admin`)
3.  Integration wählen (Email, Slack, Teams, Webhook)
4.  Konfiguration ausfüllen
5.  **Test** ausführen
6.  Speichern

## 3. Notification Policy

Pfad:

``` text
Alerts & IRM → Alerting → Notification configuration → Notification policies
```

Beispiel:

``` text
Default contact point: email-admin
Group by: alertname, instance
```

Optional:

``` text
Matcher:
severity = critical
```

## 4. Alert Rule erstellen

Pfad:

``` text
Alerts & IRM → Alert rules → New alert rule
```

PromQL:

``` promql
100 - (avg by(instance) (rate(node_cpu_seconds_total{mode="idle"}[5m])) * 100)
```

Bedingung:

``` text
WHEN last() OF query IS ABOVE 80
```

Empfohlene Einstellungen:

``` text
Evaluate every: 1m
For: 5m
Folder: Server Alerts
Evaluation group: node-exporter
```

Labels:

``` text
severity = warning
team = infra
```

Annotations:

``` text
summary = CPU high on {{ $labels.instance }}
description = CPU usage is above 80% for 5 minutes.
```

## 5. Testen

-   Contact Point → Test
-   Alert Rule → Preview
-   Alert Rules → State

Status:

``` text
Normal
Pending
Firing
No Data
Error
```

## 6. Silences

Pfad:

``` text
Alerts & IRM → Alerting → Silences → New silence
```

Beispiel:

``` text
instance = server01:9100
```

## 7. Externer Prometheus Alertmanager

Beispiel-Regel:

``` yaml
groups:
  - name: node-alerts
    rules:
      - alert: HighCPU
        expr: 100 - (avg by(instance) (rate(node_cpu_seconds_total{mode="idle"}[5m])) * 100) > 80
        for: 5m
        labels:
          severity: warning
        annotations:
          summary: "CPU high on {{ $labels.instance }}"
```

## Empfehlung

Für Grafana + Prometheus + Node Exporter reicht in den meisten Fällen
der integrierte Grafana Alertmanager aus und lässt sich vollständig über
die Grafana-Oberfläche verwalten.

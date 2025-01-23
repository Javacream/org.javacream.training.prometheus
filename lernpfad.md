# Lernpfad

* Javacream, Rainer Sawitzki
* rainer.sawitzki@gmail.com

## Ressourcen

* PromLabs _ PromQL Cheat Sheet.pdf
  * Kompaktes Cheat Sheet für PromQL
* prometheus_upandrunning.pdf
  * Frei erhältliches Buch zu Prometheus
* Das Verzeichnis docker enthät die Definition der Praktikumsumgebnung
  * Zum Starten einfach ein 'docker-compose up' geben
* Das Verzeichnis application enthält zwei Java-Anwendungen, die in die Prometheus-Überwachung integriert werden können
  * Simple ist ein einfacher Prozess, der Scheduled Konsolenausgaben macht. Hierin werden keine eigenen Metriken definiert
  * Daneben ein simpler Spring Boot WebService, der die Prometheus Metriken ohne Agent über den Actuator bereitstellt. Weiterhin werden im BooksWebService eigene Metriken definiert

## Technik

* Für das Seminar ist eine Container-Installation mit docker-compose notwendig

## Ablauf

* 8 Unterrichtseinheiten

1. Vorstellung, Aufsetzen der Trainings-Umgebung, Slides 1-11
2. Prometheus First Contact: Was sind Metriken? Das Prometheus-Metrikformat, Erste einfache PromQL-Befehle, Slides 12-21
3. Scraping: Was sind Prometheus-Exporter? Übersicht und Kategorisierung, Hinzufügen eines Exporters für ein Linux-Betriebssystem, Integration in Prometheus, Slides 22-25
4. Scraping Teil 2: Die Spring Boot Applikation, Slides 26-30
5. PromQL im Detail Teil 1, PromQL Cheat Sheet.pdf, Slides 
6. PromQL im Detail Teil 2, PromQL Cheat Sheet.pdf
7. Grafana
8. Überblick Prometheus in der Cloud / Kubernetes, überiggebliebene Themen, Abschluss mit Q&A, Teilnehmerfeedback



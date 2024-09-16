### a simple java application that schedules a console message every minute

* run application using agent -javaagent:./jmx_prometheus_javaagent-1.0.1.jar=8088:config.yaml
* metrics available at lovalhost:8088/metrics
* use ctrl-c to stop application
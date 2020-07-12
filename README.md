# todo-service - backend for Todos on Tanzu Application Service demo application

This is a Spring-based backend for Todos on Tanzu Application Service. See https://github.com/odedia/todo-ui for the frontend.

To run on TAS for VMs:

```
mvn clean package
cf push
```

To run on TAS for Kubernetes:

```
cf push
```

# todo-service - backend for Todos on Tanzu Application Service demo application
 
This is a Spring-based backend for Todos on Tanzu Application Service. See https://github.com/odedia/todo-ui for the frontend.

To run locally:

1. Start a local wavefront proxy:

```
docker run -d \                                                                
-e WAVEFRONT_URL=<YOUR-URL> \
-e WAVEFRONT_TOKEN=<YOUR-TOKEN> \
-e JAVA_HEAP_USAGE=512m \
-e WAVEFRONT_PROXY_ARGS="--traceZipkinListenerPorts 9411 --traceZipkinApplicationName=todo-application-local" \
-p 2878:2878 \
-p 9411:9411 \
wavefronthq/proxy:latest
```
2. Run `SPRING_PROFILES_ACTIVE=local mvn spring-boot:run`

---

To run on TAS for VMs:

1. Edit `manifest-tas4vms.yml` by pointing to your delpoyed wavefront proxy toute.
2. Run `mvn clean package`.
3. Run `cf push -f manifest-tas4vms.yml`

---

To run on TAS for Kubernetes:

1. Edit WAVEFRONT_URL and WAVEFRONT_TOKEN in `k8s/wavefront.yaml`
2. Run `kubectl apply -f k8s/wavefront.yaml`
3. Run `cf push -f manifest-tas4k8s.yml`




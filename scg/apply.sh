tanzu package repository add scg-package-repository \
    --namespace tap-install \
    --url registry.tanzu.vmware.com/spring-cloud-gateway-for-kubernetes/scg-package-repository:1.1.7

tanzu package install spring-cloud-gateway \
    --namespace tap-install \
    --package-name spring-cloud-gateway.tanzu.vmware.com \
    --version 1.1.7

ytt -f gateway.yaml -f httpproxy.yaml -f ../values.yaml --ignore-unknown-comments  | kubectl apply -f-
kubectl apply -f backend-route.yaml
kubectl apply -f ui-route.yaml

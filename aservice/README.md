docker
```$xslt
./mvnw install
docker build -t frankye2099/aservice:0.0.1 .
docker run -p 8080:8080 frankye2099/aservice:0.0.1
docker push frankye2099/aservice:0.0.1
```

kubernetes configmap.yaml
```$xslt
kubectl create configmap hello-config --from-env-file=configmap/hello.properties --dry-run -o=yaml > configmap.yaml
```

kubernetes deployment.yaml
```$xslt
kubectl create deployment aservice --image=frankye2099/aservice:0.0.1 --dry-run -o=yaml > deployment.yaml
echo --- >> deployment.yaml
kubectl create service clusterip aservice --tcp=8080:8080 --dry-run -o=yaml >> deployment.yaml
echo --- >> deployment.yaml
kubectl create service loadbalancer aservice-http --tcp=9091:8080 --dry-run -o=yaml >> deployment.yaml
```
deploy
```$xslt
kubectl apply -f deployment.yaml

curl localhost:9091/actuator/health

kubectl get all
kubectl port-forward svc/aservice 8080:8080
curl localhost:8080/actuator/health
```

ab -n 100 -c 10 http://localhost:9091/actuator/health

kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.0.0-rc3/aio/deploy/recommended.yaml
kubectl proxy
http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/.

kubectl -n kubernetes-dashboard get secret
kubectl -n kubernetes-dashboard describe secrets kubernetes-dashboard-token-b2cxq

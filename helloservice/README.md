docker
```$xslt
./mvnw install
docker build -t frankye2099/helloservice:0.0.2 .
docker run --env-file configmap/hello.properties -p 8080:8080 frankye2099/helloservice:0.0.2
docker push frankye2099/helloservice:0.0.2
```

kubernetes configmap.yaml
```$xslt
kubectl create configmap hello-config --from-env-file=configmap/hello.properties --dry-run -o=yaml > configmap.yaml
```

kubernetes deployment.yaml
```$xslt
kubectl create deployment helloservice --image=frankye2099/helloservice:0.0.2 --dry-run -o=yaml > deployment.yaml
echo --- >> deployment.yaml
kubectl create service clusterip helloservice --tcp=8080:8080 --dry-run -o=yaml >> deployment.yaml
echo --- >> deployment.yaml
kubectl expose service helloservice --port=9090 --target-port=8080 --type=LoadBalancer --name=helloservice-http --dry-run -o=yaml >> deployment.yaml
```

revise deployment.yaml to deployment_final.yaml to using configmap

deploy
```$xslt
kubectl apply -f configmap.yaml
kubectl apply -f deployment_final.yaml

curl localhost:9090/actuator/health

kubectl get all
kubectl port-forward svc/helloservice 8080:8080
curl localhost:8080/actuator/health
```

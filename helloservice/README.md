docker
```$xslt
./mvnw install
docker build -t frankye2099/helloservice .
docker run -p 8080:8080 frankye2099/helloservice
docker push frankye2099/helloservice
```

kubernetes deployment.yaml
```$xslt
kubectl create deployment helloservice --image=frankye2099/helloservice --dry-run -o=yaml > deployment.yaml
echo --- >> deployment.yaml
kubectl create service clusterip helloservice --tcp=8080:8080 --dry-run -o=yaml >> deployment.yaml
```

deploy
```$xslt
kubectl apply -f deployment.yaml
kubectl get all
kubectl port-forward svc/helloservice 8080:8080
curl localhost:8080/actuator/health
```

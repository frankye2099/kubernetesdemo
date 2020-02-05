###kubernetes demo

* aservice: 
    * internal service
    * deployment.yaml
    * service clusterIP - internal 8080
    * service loadbalancer - external 9091

* helloservice
    * call aservice (url in configmap) and return the status of aservice
    * configmap.yaml
    * deployment.yaml - refer to configmap
    * service clusterIP - internal 8080
    * service loadbalancer - external 9090

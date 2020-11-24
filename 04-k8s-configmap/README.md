Demo in which a k8s ConfigMap is used for properties. 

Also includes secrets. Note that you trust EVERYONE with access to k8s. 
Prefer to use a Vault in stead.


1. minikube start 
1a. minikube dashboard

2. kubectl config get-contexts
3. kubectl config use-context minikube
4.  kubectl create configmap k8s-configmap-demo --from-literal=demo2.one=k8s
./mvnw spring-boot:build-image
>  Successfully built image 'docker.io/library/k8s-configmap:0.0.1-SNAPSHOT'
docker run -p 8080:8080 k8s-configmap:0.0.1-SNAPSHOT

$ kubectl create deployment k8s-configmap --image=k8s-configmap --dry-run=client -o=yaml > deployment.yaml
$ kubectl create service clusterip k8s-configmap --tcp=8080:8080 --dry-run=client -o=yaml >> deployment.yaml
$ cat deployment.yaml 
$ kubectl apply -f deployment.yaml

$ mvn compile jib:dockerBuild

minikube service list
http://172.17.0.4:30501

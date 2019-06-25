## Kubernetes Cheat Sheet
### Important Commands
#### Cluster
1. Cluster Info - `kubectl cluster-info`

#### Nodes
1. Get Node - `kubectl get nodes`
2. Describe node - `kubectl describe node <node-name>`

#### Pods
- Creating pod from kubectl run - `kubectl run <name-replication-controller> --image=<image-registry-location> --port=<port-number> --generator=run/v1`
- Creating pod from yaml file - `kubectl create -f <yaml-file-name>.yaml`
- Get pods - `kubectl get pods`
- Get pods with addiitonal details - `kubectl get pods -o wide`
- Get yaml file of deployed pod - `kubectl get po <pod-name> -o yaml`
- Describe pod - `kubectl describe pod <pod-name>`
- Logs - `kubectl logs <pod-name>`
- Logs for each contained for multiple-container in pods - `kubectl logs <pod-name> -c <container-name>`
- Explain Pod definition - `kubectl explain po`
- Explain each attribute of Pod definition - `kubectl explain pod.<attribute-name>`
- Conecting to pods -`kubectl port-forward <pod-name> <localhost-port-number>:<pod-port-number>`

#### Replication Controller
- Creating replication controller - `kubectl run <name-replication-controller> --image=<image-registry-location> --port=<port-number> --generator=run/v1`
- Get replication controller - `kubectl get replicationcontrollers`
- Scale replication controller - `kubectl scale rc <replication-controller-name> --replicas=3`

#### Service
1. Creating loadbalancer service for replication controller - `kubectl expose rc <replication-controller-name> --type=LoadBalancer --name <name-of-service>` <BR>
  **Note:** Minikube doesn’t support LoadBalancer services, so the service will never get an external IP. But you can access the service anyway through its external port  [Refer Opening loadbalancer service](https://github.com/gautam-borkar/tutorials/blob/master/kubernetes/README.md#minikube)<BR>
2. Get services - `kubectl get services`

#### Minikube
1. Start Minikube - `minikube start`
2. SSH to minikube vm - `minikube ssh`
3. Opening loadbalancer service - `minikube service <loadbalancer-service-name>`
4. Minikube dashboard - `minikube dashboard`

### Building docker image and push to docker hub
1. Download the source code from github
  `git clone git@github.com:gautam-borkar/tutorials.git`
2. Build the docker image
  `docker build -t kubernetes-tutorial .`
3. Login to docker
  `docker login`
4. Push to docker hub
  `docker push gautamborkar/kubernetes-tutorial`
  
### Running the tutorial project
1. Start minikube
2. Running the app in kubernetes
  `kubectl run kubernetes-tutorial --image=gautamborkar/kubernetes-tutorial --port=8080 --generator=run/v1`
3. Creating a Service object 
  `kubectl expose rc kubernetes-tutorial --type=LoadBalancer --name kubernetes-tutorial-http`


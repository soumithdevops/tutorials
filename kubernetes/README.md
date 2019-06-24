### Important Commands
#### Cluster
1. Cluster Info - `kubectl cluster-info`

#### Nodes
1. Get Node - `kubectl get nodes`
2. Describe node - `kubectl describe node <node-name>`

#### Pods
1. Get pods - `kubectl get pods`
2. Describer pod - `kubectl describe pod <pod-name>`

#### Service
1. Creating loadbalancer service for replication controller - `kubectl expose rc <replication-controller-name> --type=LoadBalancer --name <name-of-service>` <BR>
  **Note:** Minikube doesn’t support LoadBalancer services, so the service will never get an external IP. But you can access the service anyway through its external port  [Refer here](https://github.com/gautam-borkar/tutorials/blob/master/kubernetes/README.md#minikube)
  
2. Get services - `kubectl get services`

#### Minikube
1. Start Minikube - `minikube start`
2. SSH to minikube vm - `minikube ssh`
3. Opening loadbalancer service - `minikube service <loadbalancer-service-name>`

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


## Kubernetes Cheat Sheet
### Important Commands
#### Cluster
1. Cluster Info - `kubectl cluster-info`

#### Nodes
1. Get Node - `kubectl get nodes`
2. Describe node - `kubectl describe node <node-name>`

#### Pods
1. Creating pod from kubectl run - `kubectl run <name-replication-controller> --image=<image-registry-location> --port=<port-number> --generator=run/v1`
1. Creating pod from yaml file - `kubectl create -f <yaml-file-name>.yaml`
1. Get pods - `kubectl get pods`
1. Get pods with addiitonal details - `kubectl get pods -o wide`
1. Get yaml file of deployed pod - `kubectl get po <pod-name> -o yaml`
1. Get pods by label - `kubectl get pods --show-labels`
1. Get pods by specific labels - `kubectl get po -L <label-name-1>,<label-name-2>`
1. Adding labels on existing pods - `kubectl label po <pod-name> <label-name>=<label-value>`
1. Change label value - `kubectl label po <pod-name> <label-name>=<label-value> --overwrite`
1. Listing pods using a label selector - `kubectl get po -l <label-name>=<label-value>`
1. List all pods that include the label, whatever its value is - `kubectl get pods -l env`
1. List all pods that dont have a label - `kubectl get pods -l '!<label-name>'`
  1. `<label-name>!=<label-value>` to select pods with the <label-name> label with any value other than <label-value>
  1. `<label-name> in (<label-value-1>,<label-value-2>)` to select pods with the <label-name> label set to either <label-value-1> or <label-value-2>
 1. `<label-name> notin (<label-value-1>,<label-value-2>)` to select pods with the `<label-name>` label set to any value other than `<label-value-1>` or `<label-value-2>`
1. Describe pod - `kubectl describe pod <pod-name>`
1. Logs - `kubectl logs <pod-name>`
1. Logs for each contained for multiple-container in pods - `kubectl logs <pod-name> -c <container-name>`
1. Explain Pod definition - `kubectl explain po`
1. Explain each attribute of Pod definition - `kubectl explain pod.<attribute-name>`
1. Conecting to pods -`kubectl port-forward <pod-name> <localhost-port-number>:<pod-port-number>`

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


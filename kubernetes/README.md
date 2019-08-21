## Kubernetes Cheat Sheet
### Important Commands
#### Cluster
1. Cluster Info - `kubectl cluster-info`

#### Nodes
- Get Node - `kubectl get nodes`
- Describe node - `kubectl describe node <node-name>`
- Adding label - `kubectl label node <node-name> <label-name>=<label-value>`

#### Pods
1. Creating pod from kubectl run - `kubectl run <name-replication-controller> --image=<image-registry-location> --port=<port-number> --generator=run/v1`
1. Creating pod from yaml file - `kubectl 
-f <yaml-file-name>.yaml`
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
   - `<label-name>!=<label-value>` to select pods with the `<label-name>` label with any value other than `<label-value>`
   - `<label-name> in (<label-value-1>,<label-value-2>)` to select pods with the `<label-name>` label set to either `<label-value-1>` or `<label-value-2>`
   - `<label-name> notin (<label-value-1>,<label-value-2>)` to select pods with the `<label-name>` label set to any value other than `<label-value-1>` or `<label-value-2>`
1. List pods that match multiple labels - `kubectl get pods -L <label-name-1>=<label-value-1>,<label-name-2>=<label-value-2>`
1. Annotate pods - `kubectl annotate pods <pod-name> <annotation-name>="<annotation-value>"`
1. Describe pod - `kubectl describe pod <pod-name>`
1. Logs - `kubectl logs <pod-name>`
1. Logs previous pods `kubectl logs <pod-name> --previous`
1. Logs for each contained for multiple-container in pods - `kubectl logs <pod-name> -c <container-name>`
1. Explain Pod definition - `kubectl explain po`
1. Explain each attribute of Pod definition - `kubectl explain pod.<attribute-name>`
1. Conecting to pods -`kubectl port-forward <pod-name> <localhost-port-number>:<pod-port-number>`.
1. Deleting pods - `kubectl delete po <pod-name>`
1. Delete all pods in current namespace - `kubectl delete po --all`

#### Namespaces
1. List namespaces - `kubectl get ns`
1. Get pods in namespace - `kubectl get po --namespace <namespace-name>`
1. Create a namespace - `kubectl create namespace <namespace-name>`
1. Create namespace from yaml file - `kubectl create -f <yaml-filename>`
1. Create pod in namespace - `kubectl create -f <yaml-file> -n <namespace-name>`
1. Delete the namespace - `kubectl delete ns <namespace-name>`
1. Deleting all resources in namespace - `kubectl delete all --all`

#### Replication Controller
- Creating replication controller - `kubectl run <name-replication-controller> --image=<image-registry-location> --port=<port-number> --generator=run/v1`
- Get replication controller - `kubectl get replicationcontrollers`
- Scale replication controller - `kubectl scale rc <replication-controller-name> --replicas=3`
- Editing replication controller - `kubectl edit rc <replication-controller-name>`
- Deleting replication controller and deleting the pods - `kubectl delete rc <replication-controller-name>`
- Deleting replication controller without deleting the pods - `kubectl delete rc <replication-controller-name> --cascade=false`

#### Replica Set
- Get replica set - `kubectl get rs`
- Deleting replica set - `kubectl delete rs <replica-set-name>`
- Operators in replica set :-
   - In: Label’s value must match one of the specified values.
   - NotIn: Label’s value must not match any of the specified values.
   - Exists: Pod must include a label with the specified key (the value isn’
   t important). When using this operator, you shouldn’t specify the values field.
   - DoesNotExist: Pod must not include a label with the specified key. The values property must not be specified.

#### Daemon Set
- Get daemon set - `kubectl get ds`
- Deleting daemon set - `kubectl delete ds <daemonset-name>`

#### Job
- Get job - `kubectl get jobs`
- Deleting job - `kubectl delete job <job-name>`
- Scale job - `kubectl scale job <job-name> --replicas <number-of-pods>`

#### Service
- Creating loadbalancer service for replication controller - `kubectl expose rc <replication-controller-name> --type=LoadBalancer --name <name-of-service>` <BR>
  **Note:** Minikube doesn’t support LoadBalancer services, so the service will never get an external IP. But you can access the service anyway through its external port  [Refer Opening loadbalancer service](https://github.com/gautam-borkar/tutorials/blob/master/kubernetes/README.md#minikube)<BR>
- Get services - `kubectl get services`

#### Minikube
1. Start Minikube - `minikube start`
2. SSH to minikube vm - `minikube ssh`
3. Opening loadbalancer service - `minikube service <loadbalancer-service-name>`
4. Minikube dashboard - `minikube dashboard`
5. Minikube Get ip of node - `minikube ip`
6. Minikube access your NodePort services - `minikube service <service-name> [-n <namespace>]`

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
  
### Michellenous 
1. Configuring kubectl editor - `export KUBE_EDITOR="<editor-location>"`

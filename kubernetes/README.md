### Important Commands
#### Cluster
1. Cluster Info - `kubectl cluster-info`

#### Nodes
1. Get Node - `kubectl get nodes`
2. Describe node - `kubectl describe node <node-name>`

#### Minikube
1. Start Minikube - `minikube start`
2. SSH to minikube vm - `minikube ssh`

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
2. 

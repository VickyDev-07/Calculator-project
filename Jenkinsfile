node{
   stage('SCM Checkout'){
     git 'https://github.com/VickyDev-07/Calculator-project.git'
   }
   stage('Compile-Package'){

      def mvnHome =  tool name: 'maven3', type: 'maven'   
      sh "${mvnHome}/bin/mvn clean package"
	  sh 'mv target/Calculator-0.0.1-SNAPSHOT.war target/calculator.war'
   }
   stage('Build Docker Imager'){
   sh 'docker build -t vickydevendran/calc:0.0.1 .'
   }
   stage('Docker Image Push'){
   withCredentials([string(credentialsId: 'dockerPass', variable: 'dockerPassword')]) {
   sh "docker login -u vickydevendran -p ${dockerPassword}"
    }
   sh 'docker push vickydevendran/calc:0.0.1'
   }
   stage('Remove Previous Container'){
	try{
		sh 'docker rm -f tomcattest'
	}catch(error){
		//  do nothing if there is an exception
	}
   stage('Docker deployment'){
   sh 'docker run -d -p 8090:8080 --name tomcattest vickydevendran/calc:0.0.1' 
   }
}
}

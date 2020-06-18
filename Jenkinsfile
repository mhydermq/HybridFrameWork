pipeline {
  agent any
  stages {
    stage('checkout') {
      steps {
        git 'https://github.com/mhydermq/HybridFrameWork.git'
      }
    }
    stage('test') {
      steps {
        bat 'mvn test'
      }
    }
  }
}

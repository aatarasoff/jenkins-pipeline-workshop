pipeline {
  agent {
    node {
      label 'docker'
    }
  }

  stages {
    stage('clone') {
      steps {
        checkout scm
      }
      post {
        success {
          echo 'This is worlks'
        }
        failure {
          echo 'This is bad'
          mail to: 'support', content: 'WHAAAT!!!'
        }
        always {

        }
      }
    }

    stage('build') {
      steps {
        buildTypicalSapProject name: 'dsfsdffds', sapVersion: 1.1.111
      }
    }
    stage('deploy') {
      steps {
        deploySapProejct name: 'dsfdsdsfdsf'
      }
    }
  }

  post {
    success {
      echo 'This is worlks'
    }
    failure {
      echo 'This is bad'
    }
    always {

    }
  }

}

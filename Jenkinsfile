pipeline {
  agent any
  triggers {
          cron('0 21 * * *')
      }
  parameters {
    string(name: 'BRANCH', defaultValue: 'master', description: 'Git branch to build')
    string(name: 'TAGS', defaultValue: '@Regression', description: 'The test suite to run')
    string(name: 'ENV', defaultValue: 'AUTO', description: 'Environment test data set')
    choice(name: 'DRIVERTYPE', choices: ['WINDOW_CHROME', 'WINDOW_FIREFOX','WINDOW_EDGE', 'MAC_SAFARI', 'MAC_CHROME', 'MAC_FIREFOX','IOS_SAFARI', 'ANDROID_CHROME' ], description: 'Environment to run tests on')
  }
  stages {
    stage('Checkout') {
      steps {
        git branch: params.BRANCH, url: 'https://github.com/MinhVo4398/maven-hybrid-demonopcomerce-practice.git'
      }
    }
    stage('Build') {
            steps {
                script {
                        def javaHome = tool 'Java 17'
                        def mvnHome = tool 'Maven 3.8.6'

                        env.JAVA_HOME = javaHome
                        env.PATH = "${mvnHome}/bin:${env.JAVA_HOME}/bin:${env.PATH}"

                }
                sh 'mvn clean package'
            }
        }
    stage('Test') {
      steps {
        sh "mvn clean test"
      }
    }
}
post {
        always {
            cucumber jsonReportDirectory: 'target',
                 fileIncludePattern: '**/cucumber.json',
                 fileExcludePattern: '',
                 trendsLimit: 10
        }
    }

}
pipeline{
    agent any
    stages{
        stage('Checkout'){
            steps{ git https://github.com/supriyakupekar1999-lgtm/testing_folder.git
        }
        stage('Build'){
            steps { sh 'mvn clen install' }
        }
        stage('Test'){
            steps{ sh 'mvn test' }
        }
    }
    post{
        always { junit 'target/surefire-reports/*.xml'
    }
}

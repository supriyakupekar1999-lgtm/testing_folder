pipeline {
agent any

```
stages {

    stage('Checkout') {
        steps {
            git 'https://github.com/supriyakupekar1999-lgtm/testing_folder.git'
        }
    }

    stage('Build') {
        steps {
            dir('Saucedemo_Automation_Project') {
                bat 'mvn clean install'
            }
        }
    }

    stage('Test') {
        steps {
            dir('Saucedemo_Automation_Project') {
                bat 'mvn test'
            }
        }
    }
}

post {
    always {
        junit 'Saucedemo_Automation_Project/target/surefire-reports/*.xml'
    }
}
```

}


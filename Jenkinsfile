pipeline {
    agent any

    stages {
        stage('Verificar Diretório') {
            steps {
                sh 'ls -la'
            }
        }
        stage('Checkout Código') {
            steps {
                git 'https://github.com/damiao-git/estudo-java-angular-cicd'
            }
            
        }
        stage('Instalar Dependências') {
            steps {
                sh 'cd backend && ./gradlew dependencies' 
            }
        }
        stage('Compilar Código') {
            steps {
                sh 'cd backend && ./gradlew build'
            }
        }
        stage('Rodar Testes') {
            steps {
                sh 'cd backend && ./gradlew test' 
            }
        }
        stage('Gerar Artefato') {
            steps {
                sh 'cd backend && ./gradlew assemble'
            }
        }
    }
}
